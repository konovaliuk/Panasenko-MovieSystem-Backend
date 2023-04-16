package com.example.accessingdatarest.models

import jakarta.persistence.*


@Entity
@Table(name = "seats")
data class Seat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val rowNumberSeat: Int = 0,
    val columnNumberSeat: Int = 0,
    val isAvailable: Boolean = true,
)