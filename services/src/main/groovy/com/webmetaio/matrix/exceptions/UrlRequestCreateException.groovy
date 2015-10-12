package com.webmetaio.matrix.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Could not create URL request.")
class UrlRequestCreateException extends RuntimeException {

  String url

  UrlRequestCreateException(String url) {
    this.url = url
  }

}
