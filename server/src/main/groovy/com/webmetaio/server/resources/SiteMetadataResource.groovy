package com.webmetaio.server.resources

import com.webmetaio.common.converters.SiteMetadataConverter
import com.webmetaio.common.models.SiteMetadata
import com.webmetaio.server.services.SiteMetadataApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sitemetadata")
public class SiteMetadataResource {

  @Autowired
  SiteMetadataApiService siteMetadataApiService

  @RequestMapping(value="", method=RequestMethod.GET)
  public Set<SiteMetadata> getAll() {
    def siteMetadataList = siteMetadataApiService.findAll()
    siteMetadataList.collect { SiteMetadataConverter.instance.toDomain(it) } as Set<SiteMetadata>
  }

}
