package com.webmetaio.services.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Entity not found")
class NotFoundException extends RuntimeException {

  String attribute
  String value

  NotFoundException(Class type, String attribute, String value) {
    super("Cound not find entity type [${type.name}] by attribute [${attribute}] with value [${value}]")
    this.attribute = attribute
    this.value = value
  }

}
