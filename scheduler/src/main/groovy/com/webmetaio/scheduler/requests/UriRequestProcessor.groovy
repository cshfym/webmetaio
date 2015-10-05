package com.webmetaio.scheduler.requests

import com.webmetaio.domain.model.UriRequest
import com.webmetaio.services.urirequest.UriRequestService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Slf4j
@Component
class UriRequestProcessor {

  @Autowired
  UriRequestService uriRequestService

  @Scheduled(fixedRate=5000L)
  public void process() {
    List<UriRequest> uriRequests = uriRequestService.allUriRequests()
    log.info "Processing ${uriRequests.size()} URI requests."
  }
}
