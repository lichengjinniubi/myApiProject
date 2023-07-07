package api.enums;

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
}
