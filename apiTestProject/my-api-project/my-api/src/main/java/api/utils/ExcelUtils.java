package api.utils;

import api.bean.excel.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static final org.slf4j.Logger loggerV2 = LoggerFactory.getLogger("info");


    public static void exportExcel(String fileName, String data, Class<?> c, HttpServletResponse response) throws Exception {
        try {
            // 创建表头
            // 创建工作薄
            //new HSSFWorkbook().getBytes();
            HSSFWorkbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            // 创建表头行
            Row rowHeader = sheet.createRow(0);
            if (c == null) {
                throw new RuntimeException("Class对象不能为空!");
            }
            java.lang.reflect.Field[] declaredFields = c.getDeclaredFields();
            List<String> headerList = new ArrayList<>();
            if (declaredFields.length == 0) {
                return;
            }
            for (int i = 0; i < declaredFields.length; i++) {
                Cell cell = rowHeader.createCell(i, CellType.STRING);
                String headerName = String.valueOf(declaredFields[i].getName());
                cell.setCellValue(headerName);
                headerList.add(i, headerName);
            }
            // 填充数据
            ObjectMapper objectMapper = new ObjectMapper();
            List<?> objects = (List) objectMapper.readValue(data, TypeFactory.defaultInstance().constructCollectionType(List.class, Student.class));
//            List<?> objects = objectMapper.readValue(data, new TypeReference<List<Student>>() {});
//            List<Student> list = JSONArray.parseArray(jsonData, Student.class);
            //List<?> objects = JSONObject.parseArray(data, c);
            loggerV2.info("excelDataInfo objects:{}", objects);
            Object obj = c.newInstance();
            if (!CollectionUtils.isEmpty(objects)) {
                for (int o = 0; o < objects.size(); o++) {
                    Row rowData = sheet.createRow(o + 1);
                    loggerV2.info("createRowInfo rowData:{}", rowData);
                    for (int i = 0; i < headerList.size(); i++) {
                        Cell cell = rowData.createCell(i);
                        Field nameField = c.getDeclaredField(headerList.get(i));
                        nameField.setAccessible(true);
                        String value = String.valueOf(nameField.get(objects.get(o)));
                        cell.setCellValue(value);
                    }
                }
            }

            response.setContentType("application/vnd.ms-excel");
            String resultFileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + resultFileName + ";" + "filename*=utf-8''" + resultFileName);
            workbook.write(response.getOutputStream());
            workbook.close();
            response.flushBuffer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
