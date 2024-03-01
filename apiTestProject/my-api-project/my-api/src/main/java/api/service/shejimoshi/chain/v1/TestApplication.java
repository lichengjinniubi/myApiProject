package api.service.shejimoshi.chain.v1;

public class TestApplication {


    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());

        handlerChain.handle();
    }
}
