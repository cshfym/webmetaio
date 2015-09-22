package com.webmetaio.server

import com.webmetaio.server.configuration.JerseyInitialization
import org.glassfish.jersey.servlet.ServletContainer
import org.glassfish.jersey.servlet.ServletProperties
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean


@EnableAutoConfiguration
public class Server {

  public static void main(String[] args) {
    new SpringApplicationBuilder(Server.class).run(args)
  }

  @Bean
  public ServletRegistrationBean jerseyServlet() {

    ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*")
    registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyInitialization.class.getName())
    registration
  }
}
