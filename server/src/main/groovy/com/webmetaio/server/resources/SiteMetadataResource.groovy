package com.webmetaio.server.resources

import com.webmetaio.common.converters.SiteMetadataConverter
import com.webmetaio.common.models.SiteMetadata
import com.webmetaio.server.services.SiteMetadataApiService

import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/sitemetadata")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SiteMetadataResource {

  @Inject
  SiteMetadataApiService siteMetadataApiService


  @GET
  public Set<SiteMetadata> getAll() {

    def siteMetadataList = siteMetadataApiService.findAll()

    siteMetadataList.collect { SiteMetadataConverter.instance.toDomain(it) } as Set<SiteMetadata>

    siteMetadataList
  }

  @GET
  @Path("/{id}")
  public SiteMetadata getOne(@PathParam("id")Long id){

    if(id == 888) {
      throw new WebApplicationException(Response.Status.NOT_FOUND)
    }
    new SiteMetadata(id: id, description: "Testing")
  }

  @POST
  public SiteMetadata save(@Valid SiteMetadata siteMetadata) {
    // siteMetadataApiService.save(siteMetadata)
    throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED)
  }


}
