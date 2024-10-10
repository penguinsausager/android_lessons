package com.example.myapplication.corporation

fun main() {
    val assistant = WorkersRepository.findAssistant()
    assistant?.printInfo()

    val director = WorkersRepository.findDirector()
    if (assistant != null) {
        director?.takeCoffee(assistant)
    }

    val directorSalary = director?.salary ?: 0
    val assistantSalary = assistant?.salary ?: 0
    val a = method()


}
fun method(){

}
