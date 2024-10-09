package com.example.myapplication.corporation


class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    position = Position.ACCOUNTANT,
    salary = salary
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository
    private val productCardsRepository = ProductCardsRepository

    override fun work() {
        val operationCodes = OperationCode.entries
        while (true) {
            println("Enter the operation code: ")
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}\n")
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]

            when (operationCode) {
                OperationCode.BREAK_OPERATION -> {
                    workersRepository.saveChanges()
                    productCardsRepository.saveChanges()
                    break
                }
                OperationCode.REGISTER_OPERATION -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun changeSalary(){
        println("Enter employee's id to change salary: ")
        val id = readln().toInt()
        println("Enter new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id, salary)

    }

    private fun fireAnEmployee() {
        println("Enter employee's id to fire: ")
        val id = readln().toInt()
        workersRepository.fireAnEmployee(id)
    }

    private fun showAllEmployees() {
        val emps = workersRepository.workers
        for (emp in emps) {
            emp.printInfo()
        }
    }

    private fun registerNewEmployee() {
        println("Choose position: ")
        val positionTypes = Position.entries

        for ((index, i) in positionTypes.withIndex()) {
            print("$index - ${i.title}")
            if (index < positionTypes.size - 1) {
                print(": ")
            } else println(", ")
        }
        val position = readln()
        val positionType = positionTypes[position.toInt()]

        println("Enter id: ")
        val id = readln().toInt()

        println("Enter name: ")
        val name = readln()

        println("Enter age: ")
        val age = readln().toInt()

        println("Enter salary: ")
        val salary = readln().toInt()

        val employee = when (positionType) {
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Accountant(id, name, age, salary)
            Position.ASSISTANT -> Assistant(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(employee)
    }

    private fun removeProductCard() {
        println("Enter name of card for removing: ")
        val name = readln()
        productCardsRepository.removeProductCard(name)
    }


    private fun showAllItems() {
        productCardsRepository.showAllItems()
    }

    private fun registerNewItem() {
        val productTypes = ProductType.entries
        println("Enter the product type: ")

        for ((index, i) in productTypes.withIndex()) {
            print("$index - ${i.title}")
            if (index < productTypes.size - 1) {
                print(": ")
            } else println(", ")
        }

        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]

        println("Enter the product name: ")
        val productName = readln()

        println("Enter the product brand: ")
        val productBrand = readln()


        println("Enter the product price: ")
        val productPrice = readln().toInt()


        val card = when (productType) {
            ProductType.FOOD -> {
                println("Enter the product cal: ")
                val cal = readln().toInt()
                FoodCard(
                    productName,
                    productBrand,
                    productPrice,
                    cal,
                )
            }

            ProductType.APPLIANCE -> {
                println("Enter the product cal: ")
                val wattage = readln().toInt()
                ApplianceCard(
                    productName,
                    productBrand,
                    productPrice,
                    wattage,
                )
            }

            ProductType.SHOE -> {
                println("Enter the product size: ")
                val size = readln().toInt()
                ShoeCard(
                    productName,
                    productBrand,
                    productPrice,
                    size,
                )
            }
        }
        productCardsRepository.saveProductCard(card)
    }

    override fun clean() {
        println("My position is Accountant. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is Accountant. I'm buying things...")
    }
}

