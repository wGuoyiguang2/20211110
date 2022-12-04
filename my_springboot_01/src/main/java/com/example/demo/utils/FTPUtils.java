package com.example.demo.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.SocketException;

/**
 * @author darly
 * @version ftp 1.0
 * @date 2020年6月15日15:47:22
 */
@Configuration
public class FTPUtils {


    // FTP 登录用户名
    private static final Log logger = LogFactory.getLog(FTPUtils.class);
    private static String userName;
    // FTP 登录密码
    private static String password;
    // FTP 服务器地址IP地址
    private static String ip;
    // FTP 端口
    private static int port;
    // FTP状态码
    public static int i = 1;

    /**
     *   参数初始化
     *     
     */
    static boolean init() {
        userName = "ftpup";
        password = "ftp@123";
        ip = "10.237.204.223";
        port = 21;
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(ip) || StringUtils.isEmpty(port)){
            return false;
        }

        return true;
    }

    /**
     *  连接到服务器
     * @return true 连接服务器成功，false 连接服务器失败
     *     
     */
    public static FTPClient startFtpConnectServer() {
        if (!init()) {
            return null;
        }
        FTPClient ftpClient = new FTPClient();
        int reply;
        try {
            // 默认是 ISO-8859-1 设置成 UTF-8 读文件时防止文件名出现乱码
            ftpClient.setControlEncoding("UTF-8");
            //  启动被动模式的 (解决上传失败问题)
            ftpClient.enterLocalPassiveMode();
            ftpClient.connect(ip, port);
            ftpClient.login(userName, password);

            System.out.println("connect to server");

            // 获取响应字符串（FTP服务器上可设置）
            String replyString = ftpClient.getReplyString();
            System.out.println("replyString: " + replyString);

            // 获取响应码用于验证是否连接成功
            reply = ftpClient.getReplyCode();
            ftpClient.setConnectTimeout(600000);
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                logger.debug("FTP 服务拒绝连接！");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            logger.debug("登录ftp服务器 " + ip + " 失败,连接超时！");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("登录ftp服务器 " + ip + " 失败，FTP服务器无法打开！");
            return null;
        }
        return ftpClient;
    }

    /**
     *   上传文件
     *   @param remoteFileName 远程文件路径,支持多级目录嵌套,
     *   @param localFile  本地文件名称，绝对路径
     *   文件以临时文件tmp形式上传，上传后重命名为正式文件
     *
     */
    public static boolean uploadFile(String remoteFileName, File localFile, FTPClient ftpClient) throws IOException {
        boolean flag = false;
        String remoteFileTmp = remoteFileName + ".tmp";
        InputStream in = new FileInputStream(localFile);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        if (ftpClient.storeFile(remoteFileName, in)) {
            ftpClient.rename(remoteFileTmp, remoteFileName);
            flag = true;
        }
        in.close();
        return flag;
    }

    /**
     *   上传文件
     *   @param remoteFileName 远程文件路径,支持多级目录嵌套,
     *   @param localFile  本地文件名称，绝对路径
     *   文件以临时文件tmp形式上传，上传后重命名为正式文件
     *
     */
    public static boolean uploadFile(String remoteFileName,InputStream in , FTPClient ftpClient) throws IOException {
        boolean flag = false;
        //默认为ASCII_FILE_TYPE，修改成BINARY_FILE_TYPE防止文件打不开
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setControlEncoding("UTF-8");
        //  转码 解决文件是中文名称上传 返回 false 问题
        // if (ftpClient.storeFile(new String(remoteFileName.getBytes("UTF-8"),"iso-8859-1"), in)) {
        if (ftpClient.storeFile(new String(remoteFileName.getBytes("UTF-8"),"iso-8859-1"), in)) {
            ftpClient.rename(remoteFileName, remoteFileName);
            flag = true;
        }
        in.close();
        return flag;
    }

    /**
     * 下载文件
     *
     * @param remoteFilePath --服务器上路径
     * @param localFilePath -- 本地路径
     * @param fileName -- 文件名
     * @return true 下载成功，false 下载失败
     *     
     */
    public static boolean downloadFile(String remoteFilePath, String localFilePath, String fileName, FTPClient ftpClient) {
        boolean flag = false;
        try {
            ftpClient.changeWorkingDirectory(remoteFilePath);
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localFilePath + File.separator + fileName);
                    OutputStream is = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(ff.getName(), is);
                    is.close();
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("本地文件下载失败！", e);
        }
        return flag;
    }

    /**
     *  关闭连接
     *     
     */
    public static void closeConnect(FTPClient ftpClient) {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置传输文件的类型[文本文件或者二进制文件]
     * 文本模式传输文本文件，
     * 如果将二进制文件按照文本模式传输，则文件传输完毕后会多出3个字节
     * @param fileType--BINARY_FILE_TYPE、ASCII_FILE_TYPE
     **     
     */
    public void setFileType(int fileType, FTPClient ftpClient) {
        try {
            ftpClient.setFileType(fileType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  列出服务器上文件和目录
     *
     *  @param regStr --匹配的正则表达式
     *     
     */
    public void listRemoteFiles(String regStr, FTPClient ftpClient) {
        try {
            String files[] = ftpClient.listNames(regStr);
            if (files == null || files.length == 0) {
                logger.debug("没有任何文件!");
            } else {
                for (int i = 0; i < files.length; i++) {
                    System.out.println(files[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *    列出Ftp服务器上的所有文件和目录
     *     
     */
    public void listRemoteAllFiles(FTPClient ftpClient) {
        try {
            String[] names = ftpClient.listNames();
            for (int i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  进入到服务器的某个目录下
     *    
     *  @param directory
     *     
     */
    public static boolean changeWorkingDirectory(String directory, FTPClient ftpClient) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                logger.debug("进入文件夹" + directory + " 成功！");
            } else {
                logger.debug("进入文件夹" + directory + " 失败！");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    /**
     *    返回到上一层目录
     *     
     */
    public static void changeToParentDirectory(FTPClient ftpClient) {
        try {
            ftpClient.changeToParentDirectory();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     *  重命名文件
     *    
     *  @param oldFileName --原文件名
     *  @param newFileName --新文件名
     *     
     */
    public void renameFile(String oldFileName, String newFileName, FTPClient ftpClient) {
        try {
            ftpClient.rename(oldFileName, newFileName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     *  转码[ISO-8859-1 -> GBK] 不同的平台需要不同的转码
     *     
     */
    @SuppressWarnings("unused")
    private String iso8859togbk(Object obj) {
        try {
            if (obj == null) {
                return "";
            } else {
                return new String(obj.toString().getBytes("iso-8859-1"), "GBK");
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     *在服务器上创建一个文件夹
     *     
     *@param dir 文件夹名称，不能含有特殊字符，如 \ 、/ 、: 、* 、?、 "、 <、>...
     *     
     */
    public static boolean makeDirectory(String dir, FTPClient ftpClient) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                logger.debug("创建文件夹" + dir + " 成功！");
            } else {
                logger.debug("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *  在服务器上检查目录是否存在
     *     
     */
    public static boolean existFile(String path, FTPClient ftpClient) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     *  递归创建远程服务器目录
     * @param remote 远程服务器文件绝对路径
     * @return 目录创建是否成功
     * @throws IOException   
     */
    public synchronized static boolean CreateDirecroty(String remote, FTPClient ftpClient) throws IOException {
        boolean success = true;
        if (!remote.endsWith("/")) {
            remote = remote + "/";
        }
        String directory = remote;
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory), ftpClient)) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                if (!changeWorkingDirectory(subDirectory, ftpClient)) {
                    if (makeDirectory(subDirectory, ftpClient)) {
                        changeWorkingDirectory(subDirectory, ftpClient);
                    } else {
                        logger.debug("创建目录[" + subDirectory + "]失败");
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        success = false;
                        return success;
                    }
                }
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }
}
