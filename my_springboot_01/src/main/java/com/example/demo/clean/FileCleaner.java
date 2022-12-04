package com.example.demo.clean;


import java.io.File;
/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-07 11:12
 **/
public class FileCleaner {


    /**
     * The instance to use for the deprecated, static methods.
     */
    static final FileCleaningTracker theInstance = new FileCleaningTracker();

    public static void addTracker(String path, Object marker) {
        theInstance.addTracker(path, marker);
    }



    public static FileCleaningTracker getInstance() {
        return theInstance;
    }
    //简单测试
    public static void main(String[] args){
        // E:\shan
//        getInstance().track("E:\\shan\\tt.txt", new Object());
//        getInstance().track("E:\\shan\\ttt.txt",new Object());
//        System.gc();
//        System.exit(0);
    }
}
