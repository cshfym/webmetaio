package com.webmetaio.domain.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate4.SpringSessionContext
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate

import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = "com.webmetaio.domain")
public class SqlInitialization{

  @Value('${datasource.driver.classname}')
  String driverClassName

  @Value('${datasource.url}')
  String baseUrl

  @Value('${datasource.username}')
  String userName

  @Value('${datasource.password}')
  String credentials

  @Value('${jpa.show-sql}')
  String showSql

  @Bean
  public DataSource dataSource() {

    DriverManagerDataSource dataSource = new DriverManagerDataSource()

    dataSource.with {
      driverClassName = driverClassName
      url = baseUrl
      username = userName
      password = credentials
    }

    dataSource
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean()
    entityManagerFactoryBean.with {
      dataSource = dataSource()
    }

    entityManagerFactoryBean.setPackagesToScan("com.webmetaio.domain")
    entityManagerFactoryBean.setJpaProperties(buildHibernateProperties())

    entityManagerFactoryBean.setJpaProperties(new Properties() {{
      put("hibernate.current_session_context_class", SpringSessionContext.class.getName())
    }})

    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {{
      setDatabase(Database.MYSQL)
    }})

    entityManagerFactoryBean
  }

  protected Properties buildHibernateProperties() {

    Properties hibernateProperties = new Properties()

    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
    hibernateProperties.setProperty("hibernate.show_sql", showSql)
    hibernateProperties.setProperty("hibernate.use_sql_comments", "false")
    hibernateProperties.setProperty("hibernate.format_sql", "false")
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "false")
    hibernateProperties.setProperty("hibernate.generate_statistics", "false")
    hibernateProperties.setProperty("javax.persistence.validation.mode", "none")

    //Audit History flags
    hibernateProperties.setProperty("org.hibernate.envers.store_data_at_delete", "true")
    hibernateProperties.setProperty("org.hibernate.envers.global_with_modified_flag", "true")

    hibernateProperties
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    new JpaTransactionManager()
  }

  @Bean
  public TransactionTemplate transactionTemplate() {
    new TransactionTemplate(transactionManager())
  }
}

