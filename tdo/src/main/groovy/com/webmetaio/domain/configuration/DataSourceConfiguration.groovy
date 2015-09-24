package com.webmetaio.domain.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(locations = "classpath:datasource.properties", ignoreUnknownFields = false, prefix = "datasource")
class DataSourceConfiguration {

  String url

  String username

  String password

  String driverClassname

  String databaseType

  boolean showSql

}
