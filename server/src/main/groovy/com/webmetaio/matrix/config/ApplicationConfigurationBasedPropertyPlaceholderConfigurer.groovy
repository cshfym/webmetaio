package com.webmetaio.matrix.config

import com.typesafe.config.Config
import com.webmetaio.configuration.server.ConfigurationProvider
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer


public class ApplicationConfigurationBasedPropertyPlaceholderConfigurer<AppConfigType extends ConfigurationProvider>
  extends PropertyPlaceholderConfigurer implements ConfigurationProvider {

  AppConfigType applicationConfiguration

  private Config config

  public void setApplicationConfiguration(AppConfigType appConfig) {
    applicationConfiguration = appConfig
    config = applicationConfiguration.config
  }

  @Override
  protected String resolveSystemProperty(final String key) {

    if ([placeholderPrefix, placeholderSuffix].every { key.contains(it) }) {
      // Let Spring deal with the parsing and wait for another pass
      return null
    }

    String usedKey = key
    int separatorIdx = valueSeparator ? key.indexOf(valueSeparator) : -1
    if (separatorIdx > -1) {
      usedKey = key.substring(0, separatorIdx)
      String defaultValue = key.substring(separatorIdx + valueSeparator.length())
      if (!config.hasPath(usedKey)) {
        return defaultValue.trim()
      }
    }
    config.getAnyRef(usedKey).toString()

  }

  @Override
  Config getConfig() {
    config
  }

}
