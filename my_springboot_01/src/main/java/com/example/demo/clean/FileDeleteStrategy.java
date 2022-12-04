package com.example.demo.clean;


import java.io.File;
import java.io.IOException;
/**
 * @program: 删除文件的工具类
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-07 11:06
 **/
public class FileDeleteStrategy {
    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
    private final String name;
    protected FileDeleteStrategy(String name) {
        this.name = name;
    }



    public static boolean doDelete(File fileToDelete) throws IOException {

        if (fileToDelete == null || fileToDelete.exists() == false){
            System.out.println("文件"+fileToDelete.getPath()+ "不存在");
            return false;
        }
        System.out.println("准备 删除文件"+fileToDelete.getPath());
        boolean delete = fileToDelete.delete();
        System.out.println(" 删除文件 result  " +   delete);
        return delete;
    }



}
















