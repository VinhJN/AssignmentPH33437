package com.vinhbqph33437.assignment.data

import com.vinhbqph33437.assignment.R

data class Product(val name: String, val price: String, val imageRes: Int)

val products = listOf(
    Product("Black Simple Lamp", "$12.00", R.drawable.simple_lamp),
    Product("Minimal Stand", "$25.00", R.drawable.stand),
    Product("Coffee Chair", "$20.00", R.drawable.chair),
    Product("Simple Desk", "$50.00", R.drawable.desk)
)