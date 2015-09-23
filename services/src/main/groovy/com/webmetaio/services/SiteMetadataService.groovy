package com.webmetaio.services

import com.webmetaio.core.model.SiteMetadata
import com.webmetaio.domain.repository.SiteMetadataRepository
import com.webmetaio.services.converters.TdoSiteMetadataConverter

import javax.inject.Inject

// Core in, Core out.
class SiteMetadataService {

  @Inject
  SiteMetadataRepository siteMetadataRepository

  Set<SiteMetadata> findAll() {

    def siteMetadataList = siteMetadataRepository.findAll()

    // Convert from domain to core data
    siteMetadataList.collect { TdoSiteMetadataConverter.instance.toCoreData(it) } as Set<SiteMetadata>
  }

}
