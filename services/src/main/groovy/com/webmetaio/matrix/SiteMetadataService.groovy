package com.webmetaio.matrix

import com.webmetaio.matrix.coredata.model.SiteMetadata
import com.webmetaio.matrix.domain.model.UriRequest
import com.webmetaio.matrix.domain.repository.SiteMetadataRepository
import com.webmetaio.matrix.converters.DomainSiteMetadataConverter
import com.webmetaio.matrix.domain.repository.UrlRequestRepository
import com.webmetaio.matrix.exceptions.NotFoundException
import com.webmetaio.matrix.exceptions.UrlRequestCreateException
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

import javax.inject.Inject

// Core in, Core out.
@Slf4j
@Service
class SiteMetadataService {

  @Inject
  SiteMetadataRepository siteMetadataRepository

  @Inject
  UrlRequestRepository urlRequestRepository

  Set<SiteMetadata> findAll() {
    def siteMetadataList = siteMetadataRepository.findAll()
    siteMetadataList.collect { DomainSiteMetadataConverter.instance.toCoreData(it) } as Set<SiteMetadata>
  }

  SiteMetadata findById(Long id) {
    def siteMetadata = siteMetadataRepository.findOne(id)
    if (!siteMetadata) {
      throw new NotFoundException(SiteMetadata.class, "id", id)
    }
    DomainSiteMetadataConverter.instance.toCoreData(siteMetadata)
  }

  Set<SiteMetadata> findAllByUri(String uri) {
    def siteMetadataList = siteMetadataRepository.findByUriContaining(uri)
    siteMetadataList.collect { DomainSiteMetadataConverter.instance.toCoreData(it) } as Set<SiteMetadata>
  }

  /**
   * Posts a URL request for later processing by the scheduler.
   * @param url
   * @return ID for requested URL.
   */
  String postUrlRequest(String url) {

    def urlRequest = urlRequestRepository.save(
      new UriRequest(
        uri: url,
        dateRequested: new Date(),
        processed: false
      )
    )

    if (!urlRequest) {
      throw new UrlRequestCreateException(url)
    }

    urlRequest.id
  }
}
