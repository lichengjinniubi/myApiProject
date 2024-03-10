package api.service.shejimoshi.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestBean implements Serializable {

    private static final long serialVersionUID = 1423037707053194486L;
    private boolean aa = true;


    private String bb;
}
