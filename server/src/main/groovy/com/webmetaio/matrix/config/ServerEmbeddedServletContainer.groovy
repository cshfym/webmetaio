package com.webmetaio.matrix.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory
import org.springframework.boot.context.embedded.ErrorPage
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

import java.util.concurrent.TimeUnit

@Component
class ServerEmbeddedServletContainer {

  @Value('${webmetaio.server.port}')
  Integer port

  @Bean
  public EmbeddedServletContainerFactory servletContainer() {
    JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory()
    factory.setPort(port)
    factory.setSessionTimeout(10, TimeUnit.MINUTES)
    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"))
    factory
  }


}