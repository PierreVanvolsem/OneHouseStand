package be.OneHouseStand.springbyexamplepersistence;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;   									
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;  // HV 20150210
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;      // HV 20150210
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("be.OneHouseStand")
@EnableTransactionManagement
public class PersistenceConfig {
    
    @Bean
    public BasicDataSource datasource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ohs");
        ds.setUsername("sc4");
        ds.setPassword("sc4");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setDefaultTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
        return ds;
    }
    
    // HV 20150210 - Aangepast aan Hibernate 4
    //
    @Bean (destroyMethod="close")
    public SessionFactory sessionFactory() throws Exception{
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(datasource());
        sf.setPackagesToScan(new String[]{"be.OneHouseStand.domain"});
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        sf.setHibernateProperties(hibernateProperties);
        sf.afterPropertiesSet();                 // omdat deze configuratie wijze ...
        return (SessionFactory) sf.getObject();  // nog wat scherpe kantjes heeft
    }
    
    @Bean
    public HibernateTransactionManager transactionManager() throws Exception{
        return new HibernateTransactionManager(sessionFactory());
    }
    
}
