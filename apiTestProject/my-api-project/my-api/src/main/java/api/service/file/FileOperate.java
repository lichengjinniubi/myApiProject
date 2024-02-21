package api.service.file;


import api.bean.excel.Student;
import api.manage.TestSmartInstanceManager;
import api.utils.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Service
public class FileOperate {

    @Autowired
    private HttpServletResponse httpServletResponse;

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


    public void exportExcel() throws Exception {
        String data = "[{\n" +
                "    \"studentId\": \"20210101\",\n" +
                "    \"name\": \"Alice\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 80\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210102\",\n" +
                "    \"name\": \"Bob\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 85\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210103\",\n" +
                "    \"name\": \"Charlie\",\n" +
                "    \"age\": 22,\n" +
                "    \"credit\": 90\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210104\",\n" +
                "    \"name\": \"David\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 75\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210105\",\n" +
                "    \"name\": \"Emily\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 82\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210106\",\n" +
                "    \"name\": \"Frank\",\n" +
                "    \"age\": 22,\n" +
                "    \"credit\": 88\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210107\",\n" +
                "    \"name\": \"Grace\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 81\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210108\",\n" +
                "    \"name\": \"Henry\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 89\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210109\",\n" +
                "    \"name\": \"Isaac\",\n" +
                "    \"age\": 22,\n" +
                "    \"credit\": 92\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210110\",\n" +
                "    \"name\": \"John\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 78\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210111\",\n" +
                "    \"name\": \"Kelly\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 84\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210112\",\n" +
                "    \"name\": \"Linda\",\n" +
                "    \"age\": 22,\n" +
                "    \"credit\": 87\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210113\",\n" +
                "    \"name\": \"Mike\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 77\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210114\",\n" +
                "    \"name\": \"Nancy\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 83\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210115\",\n" +
                "    \"name\": \"Oscar\",\n" +
                "    \"age\": 22,\n" +
                "    \"credit\": 91\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210116\",\n" +
                "    \"name\": \"Paul\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 76\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210117\",\n" +
                "    \"name\": \"Queen\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 86\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210118\",\n" +
                "    \"name\": \"Rachel\",\n" +
                "    \"age\": 22,\n" +
                "    \"credit\": 94\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210119\",\n" +
                "    \"name\": \"Sarah\",\n" +
                "    \"age\": 20,\n" +
                "    \"credit\": 79\n" +
                "  },\n" +
                "  {\n" +
                "    \"studentId\": \"20210120\",\n" +
                "    \"name\": \"Tom\",\n" +
                "    \"age\": 21,\n" +
                "    \"credit\": 80\n" +
                "  }\n" +
                "]\n";
        ExcelUtils.exportExcel("学生信息", data, Student.class, httpServletResponse);
    }
}
