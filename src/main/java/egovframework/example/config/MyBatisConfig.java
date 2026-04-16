package egovframework.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MyBatis SqlSessionFactory / SqlSessionTemplate 명시적 설정
 * eGovFramework는 mybatis-spring-boot-starter 자동 구성을 포함하지 않으므로
 * SqlSessionFactory를 직접 빈으로 등록해야 MemoMapper가 정상 주입됨
 */
@Configuration
public class MyBatisConfig {

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setMapperLocations(
      new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml")
    );
    factoryBean.setTypeAliasesPackage("egovframework.example");

    // application.yml의 mybatis.configuration 설정을 대체
    org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
    config.setMapUnderscoreToCamelCase(true);
    factoryBean.setConfiguration(config);

    return factoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
