package com.example.vue.service;

import com.example.vue.dao.sys.SysMapper;
import com.example.vue.pojo.Hr;
import com.example.vue.pojo.MsgContent;
import com.example.vue.pojo.SysMsg;
import com.example.vue.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMsgService {
    @Autowired
    SysMapper sysMapper;
    @Autowired
    HrService hrService;
    public List<SysMsg> getSysMsgByPage(Integer page,Integer size){
        int start=(page-1)*size;
        return sysMapper.getSysMsg(start,size, HrUtils.getCurrentHr().getId());
    }
    @PreAuthorize("hasRole('ROLE_admin')")//只有管理员可以发送系统消息
    public boolean sendMsg(MsgContent msg) {
        int result = sysMapper.sendMsg(msg);
        List<Hr> allHr = hrService.getAllHr(HrUtils.getCurrentHr().getId());
        int result2 = sysMapper.addMsg2AllHr(allHr, msg.getId());
        return result2==allHr.size();
    }
    public boolean markRead(Long flag) {
        if (flag != -1) {
            return sysMapper.markRead(flag,HrUtils.getCurrentHr().getId())==1;
        }
        sysMapper.markRead(flag,HrUtils.getCurrentHr().getId());
        return true;
    }
}
