package com.webmetaio.services.converters

import com.webmetaio.core.model.SiteMetadata as CoreSiteMetadata
import com.webmetaio.domain.model.SiteMetadata as TdoSiteMetadata
import com.webmetaio.tools.converters.CoreDataConverter


@Singleton
class DomainSiteMetadataConverter extends CoreDataConverter {

  @Override
  Class getDomainClass() {
    TdoSiteMetadata
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
