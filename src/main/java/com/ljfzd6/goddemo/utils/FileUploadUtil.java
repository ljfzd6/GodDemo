package com.ljfzd6.goddemo.utils;



import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUploadUtil {
    /**
     * 上传文件
     *
     * @param multipartFile
     * @return 文件存储路径
     */
    public static String upload(MultipartFile multipartFile) {
        // 文件存储位置，文件的目录要存在才行，可以先创建文件目录，然后进行存储
        String property = System.getProperty("user.dir");
        String originalFilename = multipartFile.getOriginalFilename();
        String filePath = property + "/src/main/resources/static/user";
        filePath=filePath.replaceAll("\\\\", "/");
        File file=new File(new File(filePath).getAbsolutePath()+"\\"+originalFilename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
        // 文件存储
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
