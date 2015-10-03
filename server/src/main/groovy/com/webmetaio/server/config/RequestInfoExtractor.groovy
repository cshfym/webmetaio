package com.webmetaio.server.config

import javax.servlet.http.HttpServletRequest

@Singleton
class RequestInfoExtractor {

  public String extractRequestParameters(HttpServletRequest request) {
    "remoteAddr [${request.remoteAddr}], remoteHost [${request.remoteHost}], method [${request.method}], requestURI [${request.requestURI}]"
  }

}
