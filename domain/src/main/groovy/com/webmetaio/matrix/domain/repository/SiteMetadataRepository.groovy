package com.webmetaio.matrix.domain.repository

import com.webmetaio.matrix.domain.model.SiteMetadata
import org.springframework.data.jpa.repository.JpaRepository


interface SiteMetadataRepository extends JpaRepository<SiteMetadata, Long> {

  SiteMetadata findByUriContaining(String uri)
}
