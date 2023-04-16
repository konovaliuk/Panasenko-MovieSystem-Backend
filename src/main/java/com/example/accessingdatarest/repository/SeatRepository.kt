package com.example.accessingdatarest.repository

import com.example.accessingdatarest.models.Seat
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource(collectionResourceRel = "seats", path = "seats")
interface SeatRepository : PagingAndSortingRepository<Seat, Long>, CrudRepository<Seat, Long>