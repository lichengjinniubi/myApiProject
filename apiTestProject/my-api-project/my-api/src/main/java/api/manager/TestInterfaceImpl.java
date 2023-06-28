package api.manager;

import org.springframework.stereotype.Service;

@Service
public class TestInterfaceImpl implements TestInterFace{

    @Override
    public String getDD() {
        return "222222";
    }
}
