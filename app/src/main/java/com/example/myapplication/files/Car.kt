package com.example.myapplication.files

class Car(
    val make: String,
    val model: String,
    val year: Int,
    val vin: String,
    val color: String,
)

fun serialize(car: Car): String {
    return "${car.make}%${car.model}%${car.year}%${car.vin}%${car.color}"
}

fun deserialize(carAsString: String): Car {
    val props = carAsString.split("%")
    return Car(
        make = props[0],
        model = props[1],
        year = props[2].toInt(),
        vin = props[3],
        color = props[4]
    )
}