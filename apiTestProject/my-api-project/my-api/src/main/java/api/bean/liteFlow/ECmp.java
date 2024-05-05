package api.bean.liteFlow;

import com.yomahub.liteflow.core.NodeBooleanComponent;
import org.springframework.stereotype.Component;

@Component("e")
public class ECmp extends NodeBooleanComponent {


    @Override
    public boolean processBoolean() throws Exception {
        return true;
    }
}
