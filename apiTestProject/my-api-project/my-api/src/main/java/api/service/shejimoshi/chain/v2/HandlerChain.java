package api.service.shejimoshi.chain.v2;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

    private List<Handler> handlerList = new ArrayList<>();

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        handlerList.add(handler);
    }

    public void handle() {
        for(Handler handler : handlerList){
            handler.handle();
        }
    }
}
