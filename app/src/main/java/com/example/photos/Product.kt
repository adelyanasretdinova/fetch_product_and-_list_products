package com.example.photos

class Product (
    var id:Int,
    var title: String,
    var description: String,
    var price: Int,
    var discountPercentage:Double,
    var rating:Double,
    var stock: Int,
    var brand: String,
    var category:String,
    var thumbnail: String,
    var images:List<String>
)

class AllProducts (
    var products:List<Product>
)