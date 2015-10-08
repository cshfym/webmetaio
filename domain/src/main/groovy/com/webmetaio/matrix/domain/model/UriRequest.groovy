package com.webmetaio.matrix.domain.model

import javax.persistence.*

@Entity
@Table(name="uri_request")
class UriRequest {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  @Column(name="uri")
  String uri

  @Column(name="date_requested")
  Date dateRequested

  @Column(name="processed")
  boolean processed

  @Override
  public String toString() {
    "UriRequest (Domain) id=[${id}], uri=[${uri}], dateRequested=[${dateRequested}], processed=[${processed}]"
  }
}

