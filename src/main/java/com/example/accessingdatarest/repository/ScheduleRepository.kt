package com.example.accessingdatarest.repository

import com.example.accessingdatarest.models.Schedule
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@Repository
@RepositoryRestResource(collectionResourceRel = "schedules", path = "schedules")
interface ScheduleRepository : PagingAndSortingRepository<Schedule, Long>, CrudRepository<Schedule, Long>