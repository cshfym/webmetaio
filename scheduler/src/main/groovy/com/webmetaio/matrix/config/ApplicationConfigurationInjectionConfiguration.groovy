package com.webmetaio.matrix.config

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.webmetaio.configuration.server.ApplicationConfigurationBasedPropertyPlaceholderConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource


@Configuration
class ApplicationConfigurationInjectionConfiguration {

  /**
   * Load external configuration file, if available - otherwise fall back to the default classpath application.conf.
   * @return
   */
  @Bean
  static public ApplicationConfigurationBasedPropertyPlaceholderConfigurer appConfigHolder() {

    def config = new ApplicationConfigurationBasedPropertyPlaceholderConfigurer()

    def configurationFile = new FileSystemResource("/opt/webmetaio/webmetaio-scheduler.conf")
    if (configurationFile.exists()) {
      Config parsedFile = ConfigFactory.parseFile(configurationFile.file)
      config.applicationConfiguration = new AppConfig(parsedFile)
    } else {
      config.applicationConfiguration = new AppConfig()
    }

    config
  }

}