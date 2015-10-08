package com.webmetaio.matrix.converters

import com.webmetaio.matrix.models.SiteMetadata
import com.webmetaio.matrix.coredata.model.SiteMetadata as CoreSiteMetadata
import com.webmetaio.tools.converters.CoreDataConverter

@Singleton
class SiteMetadataConverter extends CoreDataConverter {

  @Override
  Class getDomainClass() {
    SiteMetadata
  }

  @Override
  Class getCoreDataClass() {
    CoreSiteMetadata
  }

  void additionalCopyToCoreData(domain, coreData, Map objectMap) { }

  void additionalCopyToDomain(coreData, domain, Map objectMap) { }

  @Override
  Map getMappedProperties() {
    [
      id: "id",
      uri: "uri",
      ping: "ping",
      content: "content",
      lastVisit: "lastVisit"
    ]
  }

}

