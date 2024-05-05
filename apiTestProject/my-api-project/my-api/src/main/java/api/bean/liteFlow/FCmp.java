package api.bean.liteFlow;

import api.bean.liteFlow.context.TaskContext;
import com.yomahub.liteflow.core.NodeBooleanComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("f")
@Slf4j
public class FCmp extends NodeBooleanComponent {


    @Override
    public boolean processBoolean() throws Exception {
        TaskContext contextBean = this.getContextBean(TaskContext.class);
        log.info("getContextF info:{}", contextBean.getTaskMap());
        Map<String, Object> taakMap =  contextBean.getTaskMap();
        int money = MapUtils.getIntValue(taakMap, "money", 0);
        return money < 200;
    }
}
