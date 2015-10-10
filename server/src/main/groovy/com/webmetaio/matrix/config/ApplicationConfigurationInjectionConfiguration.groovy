package com.webmetaio.matrix.config

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource


@Configuration
class ApplicationConfigurationInjectionConfiguration {

  @Bean
  static public ApplicationConfigurationBasedPropertyPlaceholderConfigurer appConfigHolder() {

    def config = new ApplicationConfigurationBasedPropertyPlaceholderConfigurer()

    def configurationFile = new FileSystemResource("/opt/webmetaio/webmetaio.conf")
    if (configurationFile.exists()) {
      Config parsedFile = ConfigFactory.parseFile(configurationFile.file)
      config.applicationConfiguration = new AppConfig(parsedFile)
    } else {
      config.applicationConfiguration = new AppConfig()
    }

    config
  }

}