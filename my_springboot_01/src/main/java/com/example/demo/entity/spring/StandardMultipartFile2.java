package com.example.demo.entity.spring;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * @program: springboot_01 spring 的  StandardMultipartFile 方法是私有的，所以重新写一个
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-05 20:24
 **/
public class StandardMultipartFile2  implements MultipartFile, Serializable {


    private final Part part;

    private final String filename;

    public StandardMultipartFile2(Part part, String filename) {
        this.part = part;
        this.filename = filename;
    }

    @Override
    public String getName() {
        return this.part.getName();
    }

    @Override
    public String getOriginalFilename() {
        return this.filename;
    }

    @Override
    public String getContentType() {
        return this.part.getContentType();
    }

    @Override
    public boolean isEmpty() {
        return (this.part.getSize() == 0);
    }

    @Override
    public long getSize() {
        return this.part.getSize();
    }

    @Override
    public byte[] getBytes() throws IOException {
        return FileCopyUtils.copyToByteArray(this.part.getInputStream());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return this.part.getInputStream();
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        this.part.write(dest.getPath());
    }
}
