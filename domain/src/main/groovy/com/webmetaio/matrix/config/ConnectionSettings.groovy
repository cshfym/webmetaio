package com.webmetaio.matrix.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
public class ConnectionSettings {

  @Value('${webmetaio.db.jpa.driverClassName}')
  String driverClassname

  @Value('${webmetaio.db.jpa.url}')
  String url

  @Value('${webmetaio.db.jpa.username}')
  String username

  @Value('${webmetaio.db.jpa.password}')
  String password

  @Value('${webmetaio.db.jpa.maxPoolSize : 100}')
  Integer showSql

}
