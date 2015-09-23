package com.webmetaio.common.converters

import com.webmetaio.common.models.SiteMetadata
import com.webmetaio.core.model.SiteMetadata as CoreSiteMetadata
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

