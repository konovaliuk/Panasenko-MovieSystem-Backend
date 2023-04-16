package com.example.accessingdatarest.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "schedules")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    val movie: Movie? = null,

    val startTime: LocalDateTime = LocalDateTime.now(),
)