package bitcamp.myapp.config;

import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan({"bitcamp.myapp.dao", "bitcamp.myapp.service"})
@PropertySource({"classpath:config/ncp.properties",
  "classpath:config/ncp-secret.properties"})
public class RootConfig {

  private final Log log = LogFactory.getLog(this.getClass());

  public RootConfig() {
    log.debug("생성자 호출됨!");
  }

  //@Bean
  public SqlSessionFactory sqlSessionFactory(ApplicationContext ctx, DataSource dataSource)
    throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setTypeAliasesPackage("bitcamp.myapp.vo");
    sqlSessionFactoryBean.setMapperLocations(ctx.getResources("classpath:mapper/*Mapper.xml"));
    sqlSessionFactoryBean.setDataSource(dataSource);

    return sqlSessionFactoryBean.getObject();
  }
}
