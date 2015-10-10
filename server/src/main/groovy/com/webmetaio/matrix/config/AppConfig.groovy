package com.webmetaio.matrix.config

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.webmetaio.configuration.server.AbstractApplicationConfiguration


class AppConfig extends AbstractApplicationConfiguration {

  AppConfig() {
    super('webmetaio', ConfigFactory.load())
  }

  AppConfig(Config config) {
    super('webmetaio', ConfigFactory.load(config))
  }
}
