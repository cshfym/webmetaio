package com.webmetaio.domain.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class SiteMetadata {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  @Column(name="uri")
  String uri

  @Column(name="ping")
  boolean ping

  /*
          Type | Maximum length
  -----------+-------------------------------------
    TINYTEXT |           255 (2 8−1) bytes
        TEXT |        65,535 (216−1) bytes = 64 KiB
  MEDIUMTEXT |    16,777,215 (224−1) bytes = 16 MiB
    LONGTEXT | 4,294,967,295 (232−1) bytes =  4 GiB
   */
  @Column(name="content") // MEDIUMTEXT
  String content

  @Column(name="lastVisit")
  Date lastVisit

  @Override
  public String toString() {
    "SiteMetadata (Domain) id=[${id}], uri=[${uri}], ping=[${ping}], lastVisit=[${lastVisit}]"
  }
}

