package api.service.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Builder
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "ID", orderNum = "0")
    private Long id;
    @Excel(name = "姓名", orderNum = "1")
    private String userName;
    @Excel(name = "年龄", orderNum = "2")
    private Integer age;
    @Excel(name = "邮箱", orderNum = "3")
    private String email;
    @Excel(name = "出生日期", exportFormat = "yyyy-MM-dd",importFormat="yyyy-MM-dd",orderNum = "4")
    private Date birth;
}
