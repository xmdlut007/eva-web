package com.cn.xm.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private static final String FILE_UPLOAD_DIR = "/usr/local/Cellar/tomcat/8.5.3/libexec/webapps/filestorage";
    private static final File tempFileDir;
    static {
        tempFileDir = new File(FILE_UPLOAD_DIR);
        if (!tempFileDir.exists()) {
            tempFileDir.mkdirs();
        }
    }
    public static File createTempFile(String name) {
        try {
            return File.createTempFile(name + System.currentTimeMillis(), "", tempFileDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 后台普通文件上传方式
    public static int uploadFile(MultipartFile multipartFile) {
        if (multipartFile == null) {
            return 0;
        }

        String name = multipartFile.getOriginalFilename();
        long remainSize = multipartFile.getSize();
        logger.info("上传文件名称=[" + name + "],文件大小=" + remainSize);
        if (remainSize == 0) {
            return 0;
        }

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        File tempFile = null;
        try {
            inputStream = multipartFile.getInputStream();
            tempFile = createTempFile(name);
            fileOutputStream = new FileOutputStream(tempFile);

            int readLen = 0;
            byte[] buffer = new byte[512];
            while (remainSize > 0) {
                readLen = inputStream.read(buffer);
                logger.info("xxxxxxx上传文件大小 {}", readLen);
                if (readLen == -1) {
                    break;
                }

                remainSize -= readLen;
                fileOutputStream.write(buffer, 0, readLen);
            }
            logger.info("上传文件 {} {}", tempFile.getCanonicalPath());
            fileOutputStream.close();

        } catch (Exception e) {
            logger.info("文件上传过程遇到异常", e);
            return 0;
        } finally {
            cleanUpFileRelatedResource(inputStream, fileOutputStream, tempFile);
        }
        return 1;
    }
    private static void cleanUpFileRelatedResource(InputStream inputStream, FileOutputStream fileOutputStream, File tempFile) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // if (tempFile != null) {
        // tempFile.delete();
        // }
    }
}
