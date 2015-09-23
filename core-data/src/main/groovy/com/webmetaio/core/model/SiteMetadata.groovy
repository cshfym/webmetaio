package com.webmetaio.core.model


class SiteMetadata {

  Long id

  String uri

  boolean ping

  String content

  Date lastVisit

  @Override
  public String toString() {
    "SiteMetadata (Core) id=[${id}], uri=[${uri}], ping=[${ping}], lastVisit=[${lastVisit}]"
  }
}

