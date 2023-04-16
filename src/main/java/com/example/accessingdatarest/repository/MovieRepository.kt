package com.example.accessingdatarest.repository

import com.example.accessingdatarest.models.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@Repository
@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
interface MovieRepository : PagingAndSortingRepository<Movie, Long>, CrudRepository<Movie, Long>