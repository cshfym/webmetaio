package com.webmetaio.matrix.domain.repository

import com.webmetaio.matrix.domain.model.UriRequest
import org.springframework.data.jpa.repository.JpaRepository


interface UriRequestRepository extends JpaRepository<UriRequest, Long> {

}
