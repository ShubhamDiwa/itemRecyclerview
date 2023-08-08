package com.vasyerp.itemrecyclerview

data class PriceDto(
    val productName: String?,
    var price: Double,
    var quantity: Int,
    var net: Double? = price * quantity
)


