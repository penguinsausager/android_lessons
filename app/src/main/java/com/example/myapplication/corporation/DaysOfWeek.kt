package com.example.myapplication.corporation

enum class DaysOfWeek(val title: String) {
    SUNDAY("Воскресенье"),
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
}

fun tusk(){
    val allDays = DaysOfWeek.entries
    for (i in allDays){
        println(i.title)
    }
}