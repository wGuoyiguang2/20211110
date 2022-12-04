package com.example.demo.controller;


import com.example.demo.entity.Vo.UploadFileOutput;
import com.example.demo.utils.FTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @program: springboot_01
 * @description:   文件上传工具类  ftpFileUpload/upload
 * @author: guoyiguang
 * @create: 2021-06-25 11:50
 **/
@Controller
@Slf4j
public class FtpFileUploadController {

    @Autowired
    private RestTemplate restTemplate;

    


    /**
     * @Description:   单文件上传
     * @Param:   List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
     * @return:
     * @Author: guoyiguang
     * @Date:
     */
    @PostMapping("/ftpFileUpload/upload")
    public void upload(HttpServletRequest request,HttpServletResponse response){

        String path = request.getParameter("path");


        String robotUrl = "http://192.168.43.161:8091/ftpFileUpload/upload2" ;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("path", path);
        // 调用B 系统 获取输入流(获取流对象，要用 org.springframework.core.io.Resource 对象接收)
        ResponseEntity<Resource> entity = restTemplate.postForEntity(robotUrl, requestEntity, Resource.class);
        InputStream inputStream = null ;
        OutputStream output = null;
        try {

             inputStream = entity.getBody().getInputStream();
              output = response.getOutputStream();

            byte[] bts = new byte[8192];
            int len = -1;
            while((len=inputStream.read(bts))!=-1){
                output.write(bts,0,len);
            }

            response.setHeader("topic2","stream  测试2");
            // 返给客户端输出流
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(null != output){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }




    /**
     * 上传文件
     * @param file 文件
     * @return
     */
    @PostMapping(value = {"/fileUpload","uploadFile"})
    @ResponseBody
    public UploadFileOutput uploadFile(@RequestParam(value = "file") MultipartFile file, HttpServletResponse response) {
        try {
            byte[] bytes = file.getBytes();
            response.setContentType("image/png");
            InputStream in = new ByteArrayInputStream(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new UploadFileOutput("123456789","条形码");

    }




}
