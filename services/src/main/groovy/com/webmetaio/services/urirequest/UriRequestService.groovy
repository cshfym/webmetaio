package com.webmetaio.services.urirequest

import com.webmetaio.domain.model.UriRequest
import com.webmetaio.domain.repository.UriRequestRepository
import com.webmetaio.services.converters.DomainUriRequestConverter
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class UriRequestService {

  @Autowired
  private UriRequestRepository uriRequestRepository

  public Set<UriRequest> getAllUriRequests() {
    def uriRequestList = uriRequestRepository.findAll()
    uriRequestList.collect { DomainUriRequestConverter.instance.toCoreData(it) } as Set<UriRequest>

  }


}
