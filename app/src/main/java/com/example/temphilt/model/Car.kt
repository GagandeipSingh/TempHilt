package com.example.temphilt.model

import javax.inject.Inject

class Car @Inject constructor(val engine: Engine) {
    fun drive(){
        engine.start()
        println("Edr Driving")
    }
}