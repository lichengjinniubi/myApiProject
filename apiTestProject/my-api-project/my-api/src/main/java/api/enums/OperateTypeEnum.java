package api.enums;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public enum OperateTypeEnum {

    OPERATE_FIRST("first", ""),
    OPERATE_SECOND("second", "");

    private String type;

    private String desc;

    OperateTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }


    public String getType(){
        return this.type;
    }


    public static OperateTypeEnum getByType(String type){
        return Arrays.stream(OperateTypeEnum.values()).filter(s -> type.equals(s.toString())).findFirst().orElse(null);
    }
}
