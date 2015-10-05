package com.webmetaio.scheduler.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@Configuration
@PropertySources([
  @PropertySource(value="classpath:/application.properties", ignoreResourceNotFound=true),
  @PropertySource(value="file:/opt/webmetaio/webmetaio.properties", ignoreResourceNotFound=true)
])
public class SchedulerSettings {

  @Value('${scheduler.http.port}')
  public Integer port

}
