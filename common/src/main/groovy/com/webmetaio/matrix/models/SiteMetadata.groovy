package com.webmetaio.matrix.models

class SiteMetadata {

  Long id

  String uri

  boolean ping

  String content

  Date lastVisit

  @Override
  public String toString() {
    "SiteMetadata (Common) id=[${id}], uri=[${uri}], ping=[${ping}], lastVisit=[${lastVisit}]"
  }

}
