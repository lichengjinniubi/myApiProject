package api;



import api.bean.excel.Student;
import api.utils.ExcelUtils;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class TestApplication {


    public static void main(String[] args) throws Exception {
        //读取文件
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/momo/springBootLearn/myApiProject/apiTestProject/my-api-project/my-api/src/main/java/api/service/file/inputText.txt");
            byte[] bytes = new byte[4];
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            int read;
            while ((read = dataInputStream.read(bytes)) != -1) {
                // 把byte数组转换成字符串
                System.out.print(new String(bytes, 0, read));
            }
            fileInputStream.close();
            dataInputStream.close();
        }catch (Exception e){
            System.out.println(e);
        }


        //复制文件
//        try {
//            FileInputStream fileInputStream = new FileInputStream("/Users/momo/springBootLearn/myApiProject/apiTestProject/my-api-project/my-api/src/main/java/api/service/file/inputText.txt");
//            FileOutputStream fileOutputStream = new FileOutputStream("/Users/momo/springBootLearn/myApiProject/apiTestProject/my-api-project/my-api/src/main/java/api/service/file/inputTextCopy.txt");
//            byte[] bytes = new byte[4];
//            int read;
//            while ((read = fileInputStream.read(bytes)) != -1) {
//                // 把byte数组转换成字符串
//                fileOutputStream.write(bytes, 0, read);
//            }
//            fileInputStream.close();
//            fileOutputStream.close();
//        }catch (Exception e){
//            System.out.println(e);
//        }

//        new InputStream();
//        new FileInputStream();
//        new DataInputStream();
//        new BufferedInputStream()
    }
}
