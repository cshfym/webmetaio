package com.webmetaio.server.services

import com.webmetaio.common.converters.SiteMetadataConverter
import com.webmetaio.services.SiteMetadataService
import com.webmetaio.common.models.SiteMetadata
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service
class SiteMetadataApiService {

  @Inject
  SiteMetadataService siteMetadataService

  Set<SiteMetadata> findAll() {

    def siteMetadataList = siteMetadataService.findAll()

    // Convert from core data to common
    siteMetadataList.collect { SiteMetadataConverter.instance.toDomain(it) } as Set<SiteMetadata>

    // Core comes in, Common goes out.
  }

}
