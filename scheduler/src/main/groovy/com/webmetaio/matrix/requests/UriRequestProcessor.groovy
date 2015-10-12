package com.webmetaio.matrix.requests

import com.webmetaio.matrix.domain.model.UriRequest
import com.webmetaio.matrix.urirequest.UriRequestService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.scheduling.annotation.Scheduled

@Slf4j
@Configuration
class UriRequestProcessor {

  @Autowired
  UriRequestService uriRequestService

  @Scheduled(cron = '${webmetaio.scheduler.polling.frequency}')
  public void process() {
    Set<UriRequest> uriRequests = uriRequestService.getAllUriRequests()
    log.info "Processing ${uriRequests.size()} URI requests."
  }
}
