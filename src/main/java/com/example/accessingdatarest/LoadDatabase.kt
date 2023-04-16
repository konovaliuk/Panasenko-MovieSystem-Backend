package com.example.accessingdatarest

import com.example.accessingdatarest.models.*
import com.example.accessingdatarest.repository.MovieRepository
import com.example.accessingdatarest.repository.ScheduleRepository
import com.example.accessingdatarest.repository.SeatRepository
import com.example.accessingdatarest.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.Month


@Configuration
open class LoadDatabase {
    @Bean
    open fun initUsers(userRepository: UserRepository): CommandLineRunner {
        return CommandLineRunner {
            userRepository.save(
                User(
                    username = "root",
                    password = "root",
                    email = "root@gmail.com",
                    role = Role.ADMIN
                )
            )
        }
    }

    @Bean
    open fun initSeats(seatRepository: SeatRepository): CommandLineRunner {
        return CommandLineRunner {
            val seats = mutableListOf<Seat>()
            repeat(SCHEDULES_NUMBER) {
                for (rowNumber in 1..ROW_NUMBER) {
                    for (columnNumber in 1..COLUMN_NUMBER) {
                        val seat = Seat(rowNumberSeat = rowNumber, columnNumberSeat = columnNumber, isAvailable = true)
                        seats.add(seat)
                    }
                }
            }
            seatRepository.saveAll(seats)
        }
    }

    @Bean
    open fun initMovies(movieRepository: MovieRepository): CommandLineRunner {
        return CommandLineRunner {
            movieRepository.saveAll(movieList)
        }
    }

    @Bean
    open fun initSchedules(scheduleRepository: ScheduleRepository): CommandLineRunner {
        return CommandLineRunner {
            scheduleRepository.saveAll(
                listOf(
                    Schedule(startTime = LocalDateTime.now().minusMinutes(16), movie = movieList[0]),
                    Schedule(startTime = LocalDateTime.now().plusHours(2), movie = movieList[1]),
                    Schedule(startTime = LocalDateTime.now().plusHours(4), movie = movieList[2]),
                    Schedule(startTime = LocalDateTime.now().plusHours(6), movie = movieList[3]),
                    Schedule(startTime = LocalDateTime.now().plusHours(8), movie = movieList[4]),
                    Schedule(startTime = LocalDateTime.now().plusHours(10), movie = movieList[5])
                )
            )
        }
    }

    companion object {
        private const val ROW_NUMBER = 4
        private const val COLUMN_NUMBER = 4
        private const val SCHEDULES_NUMBER = 49
        private val movieList = listOf(
            Movie(
                id = 1,
                title = "The Shawshank Redemption",
                releaseDate = LocalDateTime.of(1994, Month.SEPTEMBER, 22, 1, 1),
                director = "Frank Darabont",
                genre = "Drama",
                posterUrl = "https://images.unsplash.com/photo-1589707181684-24a34853641d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2370&q=80",
                rating = 9.3F,
            ),
            Movie(
                id = 2,
                title = "The Godfather",
                releaseDate = LocalDateTime.of(1972, Month.MARCH, 24, 1, 1),
                director = "Francis Ford Coppola",
                genre = "Crime, Drama",
                posterUrl = "https://images.unsplash.com/photo-1633352845295-a51456b6cb61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3387&q=80",
                rating = 9.2F,
            ),
            Movie(
                id = 3,
                title = "The Dark Knight",
                genre = "Action, Crime, Drama",
                releaseDate = LocalDateTime.of(2008, Month.JULY, 18, 1, 1),
                director = "Christopher Nolan",
                rating = 9.0F,
                posterUrl = "https://images.unsplash.com/photo-1524602997322-c1900e093d3d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=927&q=80",
            ),
            Movie(
                id = 4,
                title = "Inception",
                releaseDate = LocalDateTime.of(2010, Month.JULY, 16, 1, 1),
                director = "Christopher Nolan",
                genre = "Action, Adventure, Sci-Fi",
                posterUrl = "https://images.unsplash.com/photo-1607100921698-e7de7c568742?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1364&q=80",
                rating = 8.8F,
            ),
            Movie(
                id = 5,
                title = "The Lord of the Rings: The Fellowship of the Ring",
                releaseDate = LocalDateTime.of(2001, Month.DECEMBER, 19, 1, 1),
                director = "Peter Jackson",
                genre = "Action, Adventure, Drama",
                posterUrl = "https://images.unsplash.com/photo-1524602997322-c1900e093d3d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=927&q=80",
                rating = 8.8F,
            ),
            Movie(
                id = 6,
                title = "The Matrix",
                releaseDate = LocalDateTime.of(1999, Month.MARCH, 31, 1, 1),
                director = "Lana Wachowski, Lilly Wachowski",
                genre = "Action, Sci-Fi",
                posterUrl = "https://images.unsplash.com/photo-1633352845295-a51456b6cb61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3387&q=80",
                rating = 8.7F,
            )
        )
    }
}