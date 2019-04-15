package com.example.vue.dao.employee;

import com.example.vue.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> getAllEmployeeListByPage(Integer currPage,Integer pageSize);
    int count();
    int addEmps(@Param("emps") List<Employee> emps);
    List<Employee> getEmployeeByPage(@Param("start")Integer start, @Param("size") Integer size, @Param("keywords") String keywords, @Param("politicId") Integer politicId, @Param("nationId") Integer nationId, @Param("posId") Integer posId, @Param("jobLevelId") Integer jobLevelId, @Param("engageForm") String engageForm, @Param("departmentId")Integer  departmentId, @Param("startBeginDate") Date startBeginDate, @Param("endBeginDate")Date endBeginDate);
    int getMaxWorkID();
    int getCountByKeywords(@Param("keywords") String keywords, @Param("politicId") Integer politicId, @Param("nationId") Integer nationId, @Param("posId") Integer posId, @Param("jobLevelId") Integer jobLevelId, @Param("engageForm") String engageForm, @Param("departmentId")Integer  departmentId, @Param("startBeginDate") Date startBeginDate, @Param("endBeginDate") Date endBeginDate);
    int addEmp(Employee employee);
}
