package com.example.temphilt

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temphilt.di.ImageModule
import com.example.temphilt.di.Str1
import com.example.temphilt.di.UiPref
import com.example.temphilt.model.Car
import com.example.temphilt.model.ImageProvider
import com.example.temphilt.viewmodels.QuotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named
import androidx.core.content.edit
import com.example.temphilt.di.LoginPrefs

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //    @Inject lateinit var engine: Engine
//    @Str1
//    @Inject
//    lateinit var str1: String
//    @Named("str2")
//    @Inject
//    lateinit var str2: String
//    @Inject
//    lateinit var imageProvider: ImageProvider
    val viewModel: QuotesViewModel by viewModels()

    @UiPref @Inject lateinit var uiPrefs : SharedPreferences
    @LoginPrefs @Inject lateinit var loginPrefs : SharedPreferences

    //    @Inject lateinit var car : Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val engine = Engine()
//        val car = Car(engine)
//        car.drive()

//        viewModel.getQuotes()
//        viewModel.quotesLivedata.observe(this) {
//            println("Edrr" + it.toString())
//        }
//
//        println("Edrr " + str1)
//        println("Edrr " + str2)
//        imageProvider.showImage()

        uiPrefs.edit {
            putBoolean("dark", true)
        }
        println("Edrr" + uiPrefs.getBoolean("dark",false))

        loginPrefs.edit {
            putBoolean("login", true)
        }
        println("Edrr" + loginPrefs.getBoolean("login",false))
    }
}