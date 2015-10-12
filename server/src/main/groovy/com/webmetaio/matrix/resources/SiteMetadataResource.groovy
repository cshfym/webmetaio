package com.webmetaio.matrix.resources

import com.webmetaio.matrix.converters.SiteMetadataConverter
import com.webmetaio.matrix.models.SiteMetadata
import com.webmetaio.matrix.models.UrlRequest
import com.webmetaio.matrix.models.UrlRequestResponse
import com.webmetaio.matrix.services.SiteMetadataApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
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

  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  public SiteMetadata getById(@PathVariable Long id) {
    SiteMetadataConverter.instance.toDomain(siteMetadataApiService.findById(id))
  }

  @RequestMapping(value= "/uri/{uri}", method=RequestMethod.GET)
  public Set<SiteMetadata> getByAttributes(@PathVariable String uri) {
    def siteMetadataList = siteMetadataApiService.findAllByUri(uri)
    siteMetadataList.collect { SiteMetadataConverter.instance.toDomain(it) } as Set<SiteMetadata>
  }

  @ResponseBody
  @RequestMapping(value = "/request", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
  public UrlRequestResponse postRequest(@RequestBody UrlRequest urlRequest) {
    def requestId = siteMetadataApiService.postRequest(urlRequest.url)
    new UrlRequestResponse(id: requestId)
  }
}
