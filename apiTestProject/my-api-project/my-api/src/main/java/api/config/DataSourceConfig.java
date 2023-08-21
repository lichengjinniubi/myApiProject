package api.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

///////////////使用连接池连接///////////////////
//    @MapperScan(basePackages = "api.mybatis.mapper")
//    private class giftOrderMapperScan {
//    }
//
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource getData(){
//        return new DruidDataSource();
//    }

//////////////////////////使用sqlSession直接连接//////////////
    @MapperScan(basePackages = "api.mybatis.mapper", sqlSessionTemplateRef = "giftOrderSqlSessionTemplate")
    private class giftOrderMapperScan {
    }

    @Bean("giftOrderSqlSessionTemplate")
    public SqlSessionTemplate giftOrderSqlSessionTemplate(@Qualifier("giftOrderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("giftOrderSqlSessionFactory")
    public SqlSessionFactory giftOrderSqlSessionFactory(@Qualifier("testDb1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        return factory.getObject();
    }

    @Bean("testDb1")
    @ConfigurationProperties(prefix = "mybatis.datasource.db1")
    public DataSource giftOrderDatasource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        System.out.println(dataSource.getClass().getName());
        return dataSource;
    }

}
