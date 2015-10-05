package com.webmetaio.server.services

import com.webmetaio.common.converters.SiteMetadataConverter
import com.webmetaio.services.SiteMetadataService
import com.webmetaio.common.models.SiteMetadata
import org.springframework.stereotype.Service

import javax.inject.Inject

/**
 * Core-Data object in, common object out.
 */
@Service
class SiteMetadataApiService {

  @Inject
  SiteMetadataService siteMetadataService

  Set<SiteMetadata> findAll() {
    def siteMetadataList = siteMetadataService.findAll()
    siteMetadataList.collect { SiteMetadataConverter.instance.toDomain(it) } as Set<SiteMetadata>
  }

  SiteMetadata findById(Long id) {
    def siteMetadata = siteMetadataService.findById(id)
    SiteMetadataConverter.instance.toDomain(siteMetadata)
  }

  Set<SiteMetadata> findAllByUri(String uri) {
    def siteMetadataList = siteMetadataService.findAllByUri(uri)
    siteMetadataList.collect { SiteMetadataConverter.instance.toDomain(it) } as Set<SiteMetadata>
  }
}
