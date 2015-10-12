package com.webmetaio.matrix.urirequest

import com.webmetaio.matrix.domain.model.UriRequest
import com.webmetaio.matrix.domain.repository.UrlRequestRepository
import com.webmetaio.matrix.converters.DomainUriRequestConverter
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class UriRequestService {

  @Autowired
  private UrlRequestRepository uriRequestRepository

  public Set<UriRequest> getAllUriRequests() {
    def uriRequestList = uriRequestRepository.findAll()
    uriRequestList.collect { DomainUriRequestConverter.instance.toCoreData(it) } as Set<UriRequest>

  }


}
