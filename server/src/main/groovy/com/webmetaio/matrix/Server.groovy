package com.webmetaio.matrix

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages=["com.webmetaio.matrix"])
@EnableAutoConfiguration
public class Server {

  public static void main(String[] args) {
    new SpringApplicationBuilder(Server.class).run(args)
  }

}
