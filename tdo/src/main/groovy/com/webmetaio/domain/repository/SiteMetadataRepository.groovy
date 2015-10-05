package com.webmetaio.domain.repository

import com.webmetaio.domain.model.SiteMetadata
import org.springframework.data.jpa.repository.JpaRepository


interface SiteMetadataRepository extends JpaRepository<SiteMetadata, Long> {

  SiteMetadata findByUriContaining(String uri)
}
