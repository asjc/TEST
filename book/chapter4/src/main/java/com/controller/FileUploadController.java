package com.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class FileUploadController {
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd/");

//    public String upload(MultipartFile[] uploadFiles,HttpServletRequest request){
//        String realPath=request.getSession().getServletContext().getRealPath("/uploadFile/");
//        String format=simpleDateFormat.format(new Date());
//        StringBuffer sb=new StringBuffer();
//        File file=new File(realPath+format);
//        if(!file.isDirectory()){
//            file.mkdirs();
//        }
//        for(MultipartFile uploadFile : uploadFiles){
//            String oldName=uploadFile.getOriginalFilename();
//            String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
//            try {
//                uploadFile.transferTo(new File(file,newName));
//                String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/uploadFile/"+format+newName;
//                sb.append(filePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "文件上传失败";
//            }
//        }
//        return sb.toString();
//    }
    @PostMapping("/uploads")
    public String upload(MultipartFile uploadFile, HttpServletRequest request){
        String realPath=request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format=simpleDateFormat.format(new Date());
        File file=new File(realPath+format);
        if(!file.isDirectory()){
            file.mkdirs();
        }
        String oldName=uploadFile.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            uploadFile.transferTo(new File(file,newName));
            String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/uploadFile/"+format+newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件上传失败";
    }



}
