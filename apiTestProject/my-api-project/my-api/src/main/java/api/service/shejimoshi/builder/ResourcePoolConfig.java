package api.service.shejimoshi.builder;

public class ResourcePoolConfig {

    private static final int DEFAULT_MAX_TOTAL = 8;

    private String name;
    private int masTotal = DEFAULT_MAX_TOTAL;

    private ResourcePoolConfig(String name, int masTotal){
        this.name = name;
        this.masTotal = masTotal;
    }
}
