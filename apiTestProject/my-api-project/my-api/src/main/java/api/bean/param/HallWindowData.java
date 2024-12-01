package api.bean.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(onlyExplicitlyIncluded = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HallWindowData implements Serializable {

    private static final long serialVersionUID = -2249614040903958923L;

    private int id;
    /**
     * 浮窗类型
     * TEXT : 固定文案; TIME : 时间倒计时
     */
    private String type;

    private String desc;

    private String image;

    /**
     * 倒计时秒数
     */
    private Long countDown;

    /**
     * 固定跳转的goto
     */
    private String gotoUrl;



}
