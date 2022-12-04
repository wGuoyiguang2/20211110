package com.example.demo.controller;


import com.example.demo.entity.Vo.UploadFileOutput;
import com.example.demo.utils.BarCodeUtils;
import com.example.demo.utils.FTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;


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
    RestTemplate  restTemplate;


    @Value("${front.cover.height}")
    private String height;

    @Value("${front.cover.width}")
    private String width;



    /** 
    * @Description:   单文件上传
    * @Param:  
    * @return:  
    * @Author: guoyiguang
    * @Date:  
    */ 
    @PostMapping("/ftpFileUpload/upload")
    public String upload(@RequestParam("file") MultipartFile file){

        String originalFilename = file.getOriginalFilename();

        log.info("call   ftpFileUpload/upload  method  originalFilename {} " ,originalFilename);
        String name = file.getName();
        log.info("call   ftpFileUpload/upload  method  name {} " ,name);


        try {
            InputStream inputStream2 = file.getInputStream();
            System.out.println(inputStream2);
//            FTPClient ftpClient = FTPUtils.startFtpConnectServer();
//            InputStream inputStream = file.getInputStream();
//            boolean flag = FTPUtils.uploadFile(originalFilename, inputStream, ftpClient);
//            if (flag){
//                return "上传成功";
//            }else{
//                return "上传失败";
//            }

        } catch (IOException e) {
            log.error("ftp 上传 文件 错误，原因 {}",e.getMessage());
            e.printStackTrace();
        }
        return "上传失败";

    }






    /**
     * @Description: 上传多个 ，指定 ftp
     * @Param:
     * @return:
     * @Author: guoyiguang
     * @Date:
     */
    @PostMapping("/ftpFileUpload/multiUpload")
    public String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String originalFilename = file.getOriginalFilename();

            log.info("call   ftpFileUpload/upload  method  originalFilename {} " ,originalFilename);
            String name = file.getName();
            log.info("call   ftpFileUpload/upload  method  name {} " ,name);
            FTPClient ftpClient = FTPUtils.startFtpConnectServer();
            try {
                InputStream inputStream = file.getInputStream();
                FTPUtils.uploadFile(originalFilename,inputStream,ftpClient);
            } catch (IOException e) {
                log.error("ftp 上传 文件 错误，原因 {}",e.getMessage());
                return "上传第" + (i++) + "个文件失败";
            }
        }
        return "上传成功";

    }




    /** 
    * @Description: 上传多个 ，指定路径
    * @Param:  
    * @return:  
    * @Author: guoyiguang
    * @Date:  
    */ 
    @PostMapping("/ftpFileUpload/multiUpload2")
    public String multiUpload2(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
        //linux 服务器地址
        //String filePath = "/Users/itinypocket/workspace/temp/";
        // window 地址
        String filePath = "D:\\ftpServer\\picture";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                log.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";

    }



    /**
     * @Description:   单文件上传
     * @Param:   List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
     * @return:
     * @Author: guoyiguang
     * @Date:
     */
    @PostMapping("/ftpFileUpload/upload2")
    @ResponseBody
    public void upload2(HttpServletRequest request,HttpServletResponse response){

        // 获取请求消费者参数
        String path = request.getParameter("path");

        FileInputStream inputStream = null;
        OutputStream output = null;
        if (StringUtils.isEmpty(path)){
            System.out.println("path is  empty");
            return;
        }
        //服务器端
        try {

            //注意： 得到  inputStream 后，不能直接 return inputStream , 消费者是拿不到的 InputStream 这个对象的
            //InputStream inputStream  =   files.get(0).getInputStream();
           // FileInputStream inputStream = new FileInputStream("E:\\test1\\doc\\郑宇_20200908162125_退款确认书_032CE223-AB92-4F68-A1A6-91CAF06F7051.JPG");
            // inputStream = new FileInputStream("E:\\test1\\pdf\\LeetCode 101 - A LeetCode Grinding Guide (C   Version).PDF");
            inputStream = new FileInputStream(path);
            // 将输入流转化为 输出流 传给消费者，供消费者消费
             output = response.getOutputStream();


            byte[] bts = new byte[8192];
            int len = -1;
            while((len=inputStream.read(bts))!=-1){
                output.write(bts,0,len);
            }

            response.setHeader("topic","stream  测试");
            // 返给客户端
            output.flush();
        } catch (IOException e) {
            System.out.println("io  exception");
        }finally {

            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            //
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
     * @Description:   单文件上传
     * @Param:   List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
     * @return:
     * @Author: guoyiguang
     * @Date:
     */
    @PostMapping("/ftpFileUpload/upload3")
    @ResponseBody
    public void upload3(HttpServletRequest request,HttpServletResponse response){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        //服务器端
        try {
            InputStream inputStream  =   files.get(0).getInputStream();
            OutputStream output = response.getOutputStream();


            byte[] bts = new byte[8192];
            int len = -1;
            while((len=inputStream.read(bts))!=-1){
                output.write(bts,0,len);
            }

            response.setHeader("topic","stream  测试");
            // 返给客户端
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @GetMapping("test0")
    public void test0(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // 生成的内容
        // byte[] bytes = BarCodeUtils.generateBarCode128("DCTK_202108030001", 1.50, 0.214,  true, true);
        byte[] bytes = BarCodeUtils.generateBarCode128("DCTK_202108030001", 20.00, 0.65,  true, true);

        InputStream inputStream = new ByteArrayInputStream(bytes);
        OutputStream output = response.getOutputStream();


        byte[] bts = new byte[8192];
        int len = -1;
        while((len=inputStream.read(bts))!=-1){
            output.write(bts,0,len);
        }

        response.setHeader("topic","stream  测试");
        // 返给客户端
        output.flush();




    }

    @GetMapping("test00")
    public void test00(HttpServletRequest request, HttpServletResponse response) throws IOException {


        System.out.println(Double.valueOf(height));
        System.out.println(Double.valueOf(width));
        System.out.println(Double.valueOf(width));

        // 生成的内容  20.00, 0.65
        // byte[] bytes = BarCodeUtils.generateBarCode128("DCTK_202108030001", 1.50, 0.214,  true, true);
        byte[] bytes = BarCodeUtils.generateBarCode128("DCTK_202108030001", 12.00, 0.40,  true, true);

        InputStream inputStream = new ByteArrayInputStream(bytes);
        OutputStream output = response.getOutputStream();


        byte[] bts = new byte[8192];
        int len = -1;
        while((len=inputStream.read(bts))!=-1){
            output.write(bts,0,len);
        }

        response.setHeader("topic","stream  测试");
        // 返给客户端
        output.flush();




    }


    @GetMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String parameter = request.getParameter("");
        byte[] bytes = BarCodeUtils.generateBarCode128("DCTK_202108030001", 5.00, 0.05, true, false);


        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpHeaders fileHeader = new HttpHeaders();
        // TODO
       // fileHeader.setContentType(MediaType.parseMediaType(uploadFile.getContentType()));
        fileHeader.setContentDispositionFormData("file", "123456789");

        Map result = null;

            HttpEntity<ByteArrayResource> fileEntity = new HttpEntity<>(new ByteArrayResource(bytes),
                    fileHeader);
            // file  和 Controller 方法的 接参对应
            multiValueMap.add("file", fileEntity);
            // other params
            //multiValueMap.add("uploader", uploader);

            String url = "http://127.0.0.1:8092/fileUpload";

            HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap, header);
            //ResponseEntity<Resource> resultFromB = restTemplate.postForEntity(url, httpEntity, Resource.class);
            // 错误写法：
            ResponseEntity<UploadFileOutput> resultFromB = restTemplate.postForEntity(url, httpEntity, UploadFileOutput.class);


        System.out.println(result.toString());
        System.out.println(result.toString());



    }





    @GetMapping("testInputStream")
    public InputStream  testInputStream(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String parameter = request.getParameter("");
        byte[] bytes = BarCodeUtils.generateBarCode128("DCTK_202108030001", 10.00, 0.3, true, false);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

//        OutputStream outputStream = item.getOutputStream();
//        // 写入内容
//        // outputStream.write(BarCodeUtils.generateBarCode128("DCTK_202108030001", 10.00, 0.3, true, false));
//        outputStream.write("DCTK_202108030001".getBytes(StandardCharsets.UTF_8));


           return byteArrayInputStream;


    }





















}
