package com.example.vue.dao.sys;

import com.example.vue.pojo.Hr;
import com.example.vue.pojo.MsgContent;
import com.example.vue.pojo.SysMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMapper {
    int sendMsg(MsgContent msg);

    int addMsg2AllHr(@Param("hrs") List<Hr> hrs, @Param("mid") Long mid);

    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size,@Param("hrid") int hrid);

    int markRead(@Param("flag") Long flag, @Param("hrid") int hrid);
}
