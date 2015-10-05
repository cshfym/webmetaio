package com.webmetaio.services

import com.webmetaio.core.model.SiteMetadata
import com.webmetaio.domain.repository.SiteMetadataRepository
import com.webmetaio.services.converters.TdoSiteMetadataConverter
import com.webmetaio.services.exceptions.NotFoundException
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import javax.inject.Inject

// Core in, Core out.
@Slf4j
@Service
class SiteMetadataService {

  @Inject
  SiteMetadataRepository siteMetadataRepository

  Set<SiteMetadata> findAll() {
    def siteMetadataList = siteMetadataRepository.findAll()
    siteMetadataList.collect { TdoSiteMetadataConverter.instance.toCoreData(it) } as Set<SiteMetadata>
  }

  SiteMetadata findById(Long id) {
    def siteMetadata = siteMetadataRepository.findOne(id)
    if (!siteMetadata) {
      throw new NotFoundException(SiteMetadata.class, "id", id)
    }
    TdoSiteMetadataConverter.instance.toCoreData(siteMetadata)
  }

  Set<SiteMetadata> findAllByUri(String uri) {
    def siteMetadataList = siteMetadataRepository.findByUriContaining(uri)
    siteMetadataList.collect { TdoSiteMetadataConverter.instance.toCoreData(it) } as Set<SiteMetadata>
  }
}
