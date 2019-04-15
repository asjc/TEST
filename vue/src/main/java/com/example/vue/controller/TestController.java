package com.example.vue.controller;

import com.example.vue.pojo.Employee;

import com.example.vue.pojo.Position;
import com.example.vue.service.AllEntityService;
import com.example.vue.service.EmployeeService;
import com.example.vue.util.RespBean;
import com.example.vue.util.email.EmailRunnable;
import com.example.vue.util.importAndexport.Export;
import com.example.vue.util.importAndexport.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@RestController
public class TestController {
    @Autowired
    ExecutorService executorService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    AllEntityService allEntityService;
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/employee/advanced/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/employee/basic/hello")
    public String hello1(){
        return "hello1";
    }
    @RequestMapping(value = "/employee/basic/basicdata")
    public Map<String, Object> getAllNations() {
        Map<String, Object> map = new HashMap<>();
        List politicList= allEntityService.getAllPolitic();
        map.put("politics",politicList);

        //名族
        List nationList= allEntityService.getAllNation();
        map.put("nations",nationList);

        //职位
        List positionList= allEntityService.getAllPosition();
        map.put("positions",positionList);

        //职称
        List levelList=allEntityService.getAllLevel();
        map.put("joblevels",levelList);


        //部门
        List departmentList= allEntityService.getAllDepartment();
        map.put("deps",departmentList);
        map.put("workID", String.format("%08d", employeeService.getMaxWorkID() + 1));
        return map;
    }
    @RequestMapping(value="/employee/basic/emp",method = RequestMethod.GET)
    public Map<String,Object> emp(@RequestParam(defaultValue = "1")Integer page,
                                                  @RequestParam(defaultValue ="10")Integer size,
                                                  @RequestParam(defaultValue = "")String keywords,
                                                  Integer politicId,Integer nationId,Integer posId,
                                                  Integer jobLevelId,String engageForm,Integer departmentId,
                                                  String beginDateScope){
        Map map=new HashMap();
        List<Employee> employeeByPage = employeeService.employeeList(page, size,
                keywords,politicId, nationId, posId, jobLevelId, engageForm,
                departmentId, beginDateScope);
        int count = employeeService.count(keywords,politicId, nationId,
                posId,jobLevelId, engageForm, departmentId, beginDateScope);
        map.put("emps", employeeByPage);
        map.put("count", count);
        return map;
    }

    @RequestMapping(value="/employee/basic/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", employeeService.getMaxWorkID() + 1);
    }
    @RequestMapping(value="/employee/basic/emp",method = RequestMethod.POST)
    public RespBean add(Employee employee){
        employeeService.add(employee);
        List<Position> positionList=allEntityService.getAllPosition();
        if(employee!=null){
            for(Position position:positionList){
                if(position.getId()==employee.getPosId())
                    employee.setPosName(position.getName());
            }
            executorService.execute(new EmailRunnable(employee,javaMailSender,templateEngine));
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping("employee/basic/exportEmp")
    public ResponseEntity<byte[]> exportEmp(){
        return Export.exportEmp(employeeService.employeeList(1,1000,"",null,null,null,null,null,null,null));
    }
    @RequestMapping(value = "employee/basic/importEmp")
    public RespBean importEmp(MultipartFile file) {
        List<Employee> emps = Import.importEmp(file,
                allEntityService.getAllNation(), allEntityService.getAllPolitic(),
                allEntityService.getAllDepartment(), allEntityService.getAllPosition(),
                allEntityService.getAllLevel());
        if (employeeService.addEmps(emps) == emps.size()) {
            return RespBean.ok("导入成功");
        }
        return RespBean.error("导入失败");
    }
}
