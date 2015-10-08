package com.webmetaio.matrix.converters

import com.webmetaio.matrix.coredata.model.SiteMetadata as CoreSiteMetadata
import com.webmetaio.matrix.domain.model.SiteMetadata as DomainSiteMetadata
import com.webmetaio.tools.converters.CoreDataConverter


@Singleton
class DomainUriRequestConverter extends CoreDataConverter {

  @Override
  Class getDomainClass() {
    DomainSiteMetadata
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
      dateRequested: "dateRequested",
      processed: "processed"
    ]
  }
}
