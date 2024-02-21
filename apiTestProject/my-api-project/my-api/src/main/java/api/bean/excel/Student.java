package api.bean.excel;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {


    private static final long serialVersionUID = 8202377070383941228L;

    private String studentId;

    private String name;

    private int age;

    private int credit;

}
