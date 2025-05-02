package com.example.temphilt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.temphilt.model.Car
import com.example.temphilt.viewmodels.QuotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    @Inject lateinit var engine: Engine
    val viewModel: QuotesViewModel by viewModels()
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

        viewModel.getQuotes()
        viewModel.quotesLivedata.observe(this) {
            println("Edrr" + it.toString())
        }
    }
}