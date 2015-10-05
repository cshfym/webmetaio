package com.webmetaio.scheduler

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling


@Configuration
@ComponentScan(basePackages=
  [
    "com.webmetaio.scheduler",
    "com.webmetaio.services",
    "com.webmetaio.domain"
  ]
)
@EnableAutoConfiguration
@EnableScheduling
public class Scheduler {

  public static void main(String[] args) {
    new SpringApplicationBuilder(Scheduler.class).run(args)
  }

}
