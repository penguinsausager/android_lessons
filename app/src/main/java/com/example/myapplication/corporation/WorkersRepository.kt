package com.example.myapplication.corporation

import java.io.File

object WorkersRepository {

    private val fileWorkers = File("workers.txt")
    private val _workers = loadAllEmployees()
    val workers
        get() = _workers.toList()


    fun registerNewEmployee(newWorker: Worker) {
        _workers.add(newWorker)
    }

    fun findAssistant(): Assistant? {
        for(worker in _workers){
            if (worker is Assistant){
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director? {
        for(worker in _workers){
            if (worker is Director){
                return worker
            }
        }
        return null
    }

    fun changeSalary(id: Int, salary: Int) {
        for ( worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(salary = salary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }

    }

    fun fireAnEmployee(id: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                _workers.remove(worker)
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (worker in _workers) {
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.position}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    private fun loadAllEmployees(): MutableSet<Worker> {
        val employees = mutableSetOf<Worker>()
        val content = fileWorkers.readText().trim()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (emp in employeesAsText) {
            val prop = emp.split("%")
            val id = prop[0].toInt()
            val name = prop[1]
            val age = prop[2].toInt()
            val salary = prop[3].toInt()
            val positionAsText = prop.last()
            val pos = Position.valueOf(positionAsText)
            val worker = when (pos) {
                Position.DIRECTOR -> Director(id, name, age, salary)
                Position.ACCOUNTANT -> Accountant(id, name, age, salary)
                Position.ASSISTANT -> Assistant(id, name, age, salary)
                Position.CONSULTANT -> Consultant(id, name, age, salary)
            }
            employees.add(worker)
        }
        return employees
    }

    fun changeAge(id: Int, age: Int) {
        for ( worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(age = age)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

}