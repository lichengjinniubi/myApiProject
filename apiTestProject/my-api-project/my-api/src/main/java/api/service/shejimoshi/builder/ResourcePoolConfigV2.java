package api.service.shejimoshi.builder;

public class ResourcePoolConfigV2 {

    private String name;

    private int maxTotal;

    public ResourcePoolConfigV2(Builder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
    }

    public int getMaxTotal(){
        return this.maxTotal;
    }

    public static class Builder{

        private static final int DEFAULT_MAX_TOTAL = 8;

        private String name;
        private int maxTotal =  DEFAULT_MAX_TOTAL;

        public ResourcePoolConfigV2 build(){
            if(maxTotal <= 10){
                throw  new IllegalArgumentException(".....");
            }

            return new ResourcePoolConfigV2(this);
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal){
            this.maxTotal = maxTotal;
            return this;
        }

        public int getMaxTotal(){
            return this.maxTotal;
        }
    }




}
