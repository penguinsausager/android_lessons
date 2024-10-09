package com.example.myapplication.corporation

enum class OperationCode(val title: String) {
    BREAK_OPERATION(title = "exit"),
    REGISTER_OPERATION(title = "register new item"),
    SHOW_ALL_ITEMS(title = "Show all items"),
    REMOVE_PRODUCT_CARD(title = "Remove product card"),
    REGISTER_NEW_EMPLOYEE(title = "Register new employee"),
    FIRE_AN_EMPLOYEE(title = "Fire an employee"),
    SHOW_ALL_EMPLOYEES(title = "Show all employees"),
    CHANGE_SALARY(title = "Change salary")
}