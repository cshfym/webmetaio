package com.webmetaio.server.configuration

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.ServerProperties

public class JerseyInitialization extends ResourceConfig {

  public JerseyInitialization(){

    this.packages(true, "com.webmetaio.server.resources")
    this.register(new JacksonJsonProvider(ObjectMapperFactory.create()))
    this.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true)
    this.property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true)

  }
}
