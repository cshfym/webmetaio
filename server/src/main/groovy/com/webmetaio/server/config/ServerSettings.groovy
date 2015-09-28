package com.webmetaio.server.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@Configuration
@PropertySources([
  @PropertySource(value="classpath:/application.properties", ignoreResourceNotFound=true),
  @PropertySource(value="file:/opt/webmetaio/webmetaio.properties", ignoreResourceNotFound=true)
])
public class ServerSettings {

  @Value('${connection.http.port}')
  public Integer port

  @Value('${database.driverClassname}')
  public String driverClassname

  @Value('${database.url}')
  public String databaseUrl

  @Value('${database.username}')
  public String databaseUsername

  @Value('${database.password}')
  public String databasePassword

  @Value('${database.showSql}')
  public String showSql

}
