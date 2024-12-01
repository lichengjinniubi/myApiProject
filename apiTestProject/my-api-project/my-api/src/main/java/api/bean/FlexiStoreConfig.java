package api.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * dao配置
 */
@Getter
@Setter
public class FlexiStoreConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据源地址
     */
    private String address;

    /**
     * 连接池大小
     */
    private String pool;

    /**
     * 超时时间（毫秒）
     */
    private int timeout = 500;


    @Override
    public String toString() {
        return this.getAddress() + "---" + this.getPool();
    }
}
