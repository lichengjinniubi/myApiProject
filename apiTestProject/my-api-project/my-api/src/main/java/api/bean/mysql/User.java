package api.bean.mysql;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4720293493698648680L;

    private int id;

    private String name;

    private int tel;
}
