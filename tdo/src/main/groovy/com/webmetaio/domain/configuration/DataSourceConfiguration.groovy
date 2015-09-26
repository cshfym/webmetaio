package com.webmetaio.domain.configuration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@EnableAutoConfiguration
@PropertySource(["classpath:application.properties"])
@ConfigurationProperties(prefix="database")
class DataSourceConfiguration {

  String url

  String username

  String password

  String driverClassname

  String databaseType

  boolean showSql

}
