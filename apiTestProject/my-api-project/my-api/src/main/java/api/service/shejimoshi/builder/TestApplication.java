package api.service.shejimoshi.builder;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.io.*;
import java.util.*;

public class TestApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ResourcePoolConfigV2 build = new ResourcePoolConfigV2.Builder().setName("1111").setMaxTotal(90).build();
//        System.out.println(build.getMaxTotal());
//        StringBuilder aa1 = new StringBuilder().append("aa");
        //System.out.println(aa);


        TestBean testBean = new TestBean();
        testBean.setBb("Bb");




//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(testBean);
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        List<Byte> aa = new ArrayList<>();
//        for (byte b :bytes){
//            aa.add(b);
//        }
//        System.out.println(aa);
//
//        byte[] bytesTmp = new byte[100];
//        int i = 0;
//        for (Byte a : aa){
//            bytesTmp[i] = a;
//                    i++;
//        }
//        System.out.println(bytesTmp);
//        byteArrayOutputStream.close();
//        objectOutputStream.close();

        // 2、字节数组转对象
//        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        final Object object = objectInputStream.readObject();
//        final TestBean xiaowang = (TestBean) object;
//        byteArrayInputStream.close();
//        objectInputStream.close();
//        System.out.println(xiaowang);


/**
 * 存储成文件
 */

        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
            objectOutputStream.writeObject(testBean);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // 反序列化对象
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
            //System.out.println(objectInputStream.readByte());
            TestBean restoredPerson = (TestBean) objectInputStream.readObject();
            System.out.println(restoredPerson);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
