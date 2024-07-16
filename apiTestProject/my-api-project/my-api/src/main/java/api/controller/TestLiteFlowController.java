package api.controller;

import api.bean.liteFlow.context.TaskContext;
import api.config.TestRuleSource;
import api.service.ITestService;
import api.service.IUserService;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@Slf4j
public class TestLiteFlowController {


    @Resource
    private FlowExecutor flowExecutor;



    @RequestMapping("/testRule")
    public String testRule(){
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
        return response.getExecuteStepStrWithTime();
    }


    @RequestMapping("/testRuleV2")
    public Boolean testRuleV2(){
        LiteflowResponse response = flowExecutor.execute2Resp("chain2", "arg");
        log.info("testRuleV2info path:{}", response.getExecuteStepStrWithTime());
        return response.isSuccess();
    }


    @RequestMapping("/testRuleV3")
    public Boolean testRuleV3(){
        TaskContext taskContext = new TaskContext();
        HashMap<String, Object> taskMap = new HashMap<>();
        taskMap.put("money", 100);
        taskContext.setTaskMap(taskMap);

        LiteflowResponse response = flowExecutor.execute2Resp("chain2", null, taskContext);
        log.info("testRuleV3info path:{}", response.getExecuteStepStrWithTime());
        return response.isSuccess();
    }


    @RequestMapping("/testRuleV4")
    public void testRuleV4(){
        flowExecutor.reloadRule();
    }








}
