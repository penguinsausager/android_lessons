package com.example.myapplication.corporation

fun main() {

//    val workers = WorkersRepository.workers
//    for (worker in workers){
//        worker.work()
//    }

    val workers = mutableSetOf<Worker>()
    val a = Director(0, "", 0, 0)
    val b = Director(0, "", 0, 0)
    workers.add(a)
    workers.add(b)

    for (worker in workers){
        worker.printInfo()
    }

    println()
}