package es.tuke.besties_structured.configDBs;

import javax.sql.DataSource;
import java.util.Map;
import java.util.HashMap;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;




@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "securityEntityManagerFactory",
 transactionManagerRef = "securityTransactionManager",
 basePackages = { "es.tuke.besties_structured.security.persistence.repositories"})
public class SecurityDBConfig {

    @Value("${security.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Bean(name = "securityDataSource")
    @ConfigurationProperties(prefix = "security.datasource")
    public DataSource dataSource(){ return DataSourceBuilder.create().build();}



    @Bean(name = "securityEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
        @Qualifier("securityDataSource" )DataSource dataSource)
    {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("es.tuke.besties_structured.security.persistence.entities");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(adapter);

        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto", "update");
        properties.put("hibernate.format_sql", "true");



        factoryBean.setJpaPropertyMap(properties);

        
        return factoryBean;
    } 

    @Bean(name = "securityTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
        @Qualifier("securityEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ){

        return new JpaTransactionManager(entityManagerFactory);

    }
    
}
