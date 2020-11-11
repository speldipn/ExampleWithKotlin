package com.example.examplewithkotlin.model

class PhoneModel {
    var phone: String = ""
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int, phone: String) {
        this.name = name
        this.age = age
        this.phone = phone
    }
}