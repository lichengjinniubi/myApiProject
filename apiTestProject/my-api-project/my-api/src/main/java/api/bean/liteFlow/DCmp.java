package api.bean.liteFlow;

import com.yomahub.liteflow.core.NodeBooleanComponent;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("d")
public class DCmp extends NodeBooleanComponent {


    @Override
    public boolean processBoolean() throws Exception {
        return true;
    }
}
