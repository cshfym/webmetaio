package com.webmetaio.matrix.config

import com.google.common.io.CharStreams

import javax.servlet.http.HttpServletRequest

@Singleton
class RequestInfoExtractor {

  public String extractRequestParameters(HttpServletRequest request) {
    "remoteAddr [${request.remoteAddr}] " +
    "remoteHost [${request.remoteHost}] " +
    "method [${request.method}] " +
    "requestURI [${request.requestURI}] "  //+
    //"POST".equalsIgnoreCase(request.method) ? "requestBody [${CharStreams.toString(request.reader)}]" : ""
  }

}
