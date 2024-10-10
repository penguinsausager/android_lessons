package com.example.myapplication.corporation

fun main() {
    val director = WorkersRepository.findDirector()
        ?: throwDirectorIsRequired()
    director?.printInfo()
}

fun throwDirectorIsRequired() : Nothing{
    throw IllegalArgumentException("Director is required for this program")
}
