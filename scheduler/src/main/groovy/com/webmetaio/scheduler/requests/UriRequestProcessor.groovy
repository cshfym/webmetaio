package com.webmetaio.scheduler.requests

import com.webmetaio.domain.model.UriRequest
import com.webmetaio.services.urirequest.UriRequestService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Slf4j
@Configuration
class UriRequestProcessor {

  @Autowired
  UriRequestService uriRequestService

  @Scheduled(fixedRate=5000L)
  public void process() {
    Set<UriRequest> uriRequests = uriRequestService.getAllUriRequests()
    log.info "Processing ${uriRequests.size()} URI requests."
  }
}
