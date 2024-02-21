package api.service.file;


import api.manage.TestSmartInstanceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Service
public class FileOperate {

    private static final org.slf4j.Logger loggerV2 = LoggerFactory.getLogger("info");


    Logger logger = LogManager.getLogger(FileOperate.class);
    public void fileInputTest(){
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/momo/springBootLearn/myApiProject/apiTestProject/my-api-project/my-api/src/main/java/api/service/file/inputText.txt");
            loggerV2.info("fileInputStreamInfo fileInputStream:{}", fileInputStream);
            int read;
            byte[] bytes = new byte[4];
            while ((read = fileInputStream.read(bytes)) != -1) {
                // 把byte数组转换成字符串
                loggerV2.info("fileInputStreamInfo bytes:{} fileInputStream:{}", bytes, new String(bytes, 0, read));
            }
            fileInputStream.close();
        }catch (Exception e){
            logger.error("fileInputTestError", e);
        }

    }


    public void copyFileTest(){
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/momo/springBootLearn/myApiProject/apiTestProject/my-api-project/my-api/src/main/java/api/service/file/inputText.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/momo/springBootLearn/myApiProject/apiTestProject/my-api-project/my-api/src/main/java/api/service/file/inputTextCopy.txt");
            byte[] bytes = new byte[4];
            int read;
            while ((read = fileInputStream.read(bytes)) != -1) {
                // 把byte数组转换成字符串
                fileOutputStream.write(bytes, 0, read);
            }


            fileInputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
