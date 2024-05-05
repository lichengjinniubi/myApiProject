package api.bean.liteFlow.context;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class TaskContext implements Serializable {


    private static final long serialVersionUID = 4886179594977729352L;


    private Map<String, Object> taskMap = new HashMap<>();
}
