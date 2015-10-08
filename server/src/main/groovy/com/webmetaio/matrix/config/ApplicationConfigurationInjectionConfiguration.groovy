package com.webmetaio.matrix.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
class ApplicationConfigurationInjectionConfiguration {

  @Bean
  static public ApplicationConfigurationBasedPropertyPlaceholderConfigurer appConfigHolder() {

    def metaData = new ClassPathResource('webmetaio-server.properties')
    def config = new ApplicationConfigurationBasedPropertyPlaceholderConfigurer()
    config.applicationConfiguration = new AppConfig()
    if (metaData.exists()) {
      config.location = metaData
    }
    config

  }

}