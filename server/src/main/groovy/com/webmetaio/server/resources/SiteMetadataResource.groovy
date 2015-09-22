package com.webmetaio.server.resources

import com.webmetaio.common.models.SiteMetadata

import javax.ws.rs.Consumes
import javax.ws.rs.GET
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

  @GET
  public List<SiteMetadata> getAll(){

    def siteMetadataList = []
    siteMetadataList.add(new SiteMetadata(id: 1L, description: "Testing"))

    siteMetadataList
  }

  @GET
  @Path("/{id}")
  public SiteMetadata getOne(@PathParam("id")Long id){

    if(id == 888){
      throw new WebApplicationException(Response.Status.NOT_FOUND)
    }

    new SiteMetadata(id: id, description: "Testing")

  }
}
