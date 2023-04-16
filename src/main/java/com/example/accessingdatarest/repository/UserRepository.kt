package com.example.accessingdatarest.repository

import com.example.accessingdatarest.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
interface UserRepository : PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
    @GetMapping("/{username}")
    fun findByUsername(@Param("username") username: String): User?
}