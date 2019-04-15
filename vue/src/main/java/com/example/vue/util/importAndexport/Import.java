package com.example.vue.util.importAndexport;

import com.example.vue.pojo.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Import {
    public static List<Employee> importEmp(MultipartFile file,
                                           List<Nation> allNations,
                                           List<PoliticsStatus> allPolitics,
                                           List<Department> allDepartment,
                                           List<Position> allPos,
                                           List<JobLevel> allJobLevels){
        List<Employee> emps = new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Employee employee;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                    String cellValue = cell.getStringCellValue();
                                    if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 1:
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        employee.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        employee.setGender(cellValue);
                                        break;
                                    case 4:
                                        employee.setBirthday(cellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(cellValue);
                                        break;
                                    case 7:
                   /*                     int nationIndex = allNations.indexOf(new Nation(cellValue));*/
                                        for(Nation nation:allNations){
                                            if(nation.getName().equals(cellValue)){
                                                employee.setNationId(nation.getId());
                                            }
                                        }
                       /*                 employee.setNationId(allNations.get(nationIndex).getId());*/
                                        break;
                                    case 8:
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        /*int psIndex = allPolitics.indexOf(new PoliticsStatus(cellValue));
                                        employee.setPoliticId(allPolitics.get(psIndex).getId());*/
                                        for(PoliticsStatus politicsStatus:allPolitics){
                                            if(politicsStatus.getName().equals(cellValue)){
                                                employee.setPoliticId(politicsStatus.getId());
                                            }
                                        }
                                        break;
                                    case 10:
                                        employee.setPhone(cellValue);
                                        break;
                                    case 11:
                                        employee.setAddress(cellValue);
                                        break;
                                    case 12:
                                        /*int depIndex = allDepartment.indexOf(new Department(cellValue));
                                        employee.setDepartmentId(allDepartment.get(depIndex).getId());*/
                                        for(Department department:allDepartment){
                                            if(department.getName().equals(cellValue)){
                                                employee.setDepartmentId(department.getId());
                                            }
                                        }
                                        break;
                                    case 13:
                                        /*int jlIndex = allJobLevels.indexOf(new JobLevel(cellValue));
                                        employee.setJobLevelId(allJobLevels.get(jlIndex).getId());*/
                                        for(JobLevel jobLevel:allJobLevels){
                                            if(jobLevel.getName().equals(cellValue)){
                                                employee.setJobLevelId(jobLevel.getId());
                                            }
                                        }
                                        break;
                                    case 14:
                                        /*int posIndex = allPos.indexOf(new Position(cellValue));
                                        employee.setPosId(allPos.get(posIndex).getId());*/
                                        for(Position position:allPos){
                                            if(position.getName().equals(cellValue)){
                                                employee.setPosId(position.getId());
                                            }
                                        }
                                        break;
                                    case 15:
                                        employee.setEngageForm(cellValue);
                                        break;
                                    case 16:
                                        employee.setTiptopDegree(cellValue);
                                        break;
                                    case 17:
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 18:
                                        employee.setSchool(cellValue);
                                        break;
                                    case 19:
                                        employee.setBeginDate(cellValue);
                                        break;
                                    case 20:
                                        employee.setWorkState(cellValue);
                                        break;
                                    case 21:
                                        employee.setEmail(cellValue);
                                        break;
                                    case 23:
                                        employee.setBeginContract(cellValue);
                                        break;
                                    case 24:
                                        employee.setEndContract(cellValue);
                                        break;
                                }
                            }
                            break;
                            default: {
                                switch (k) {
                                    case 22:
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    emps.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emps;
    }
}
