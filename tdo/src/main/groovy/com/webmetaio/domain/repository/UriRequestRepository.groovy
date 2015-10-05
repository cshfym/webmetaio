package com.webmetaio.domain.repository

import com.webmetaio.domain.model.UriRequest
import org.springframework.data.jpa.repository.JpaRepository


interface UriRequestRepository extends JpaRepository<UriRequest, Long> {

}
