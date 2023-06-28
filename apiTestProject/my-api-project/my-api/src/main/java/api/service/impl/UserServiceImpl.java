package api.service.impl;

import api.aspect.ThirdAnnotation;
import api.service.ITestService;
import api.service.IUserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(prefix = "test.name", name="userService", havingValue = "true")
//@ConditionalOnMissingBean(ITestService.class)
public class UserServiceImpl implements IUserService {

    @Override
    @ThirdAnnotation
    public String getUserName() {
        return "new name";
    }
}
