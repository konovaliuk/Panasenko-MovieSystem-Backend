package com.example.accessingdatarest.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "movies")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String = "",
    val director: String = "",
    val releaseYear: Int = 0,
    val rating: Float = 0.0F,
    val description: String = "",
    val releaseDate: LocalDateTime = LocalDateTime.now(),
    val genre: String = "",
    val posterUrl: String = "",
)