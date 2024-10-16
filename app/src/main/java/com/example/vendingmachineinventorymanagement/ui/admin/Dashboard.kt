package com.example.vendingmachineinventorymanagement.ui.admin

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.vendingmachineinventorymanagement.R
import com.example.vendingmachineinventorymanagement.databinding.ActivityDashboardBinding
import com.example.vendingmachineinventorymanagement.extensionfunctions.createSingleInstanceIntent
import com.example.vendingmachineinventorymanagement.testvm.MainActivity
import com.example.vendingmachineinventorymanagement.ui.customer.WellComeActivity
import com.example.vendingmachineinventorymanagement.utils.singleClickListener

class Dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnExit.singleClickListener {
            //exit all the activities
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }
        binding.btnGoToShopping.singleClickListener {
            val intent = createSingleInstanceIntent<WellComeActivity>()
            startActivity(intent)
        }
        binding.apply {
            itemViewProducts.setOnClickListener {
                onModuleClick(itemViewProducts)
            }
            itemAddProducts.setOnClickListener {
                onModuleClick(itemAddProducts)
            }
            itemViewStandardVM.setOnClickListener {
                onModuleClick(itemViewStandardVM)
            }

        }
    }
    private fun onModuleClick(itemView: ConstraintLayout) {
        when (itemView.id) {
            R.id.itemAddProducts -> {
                val intent = createSingleInstanceIntent<AddProductsActivity>()
                startActivity(intent)
            }

            R.id.itemViewProducts -> {
                val intent = createSingleInstanceIntent<ViewProductsActivity>()
                startActivity(intent)
            }
            R.id.itemViewStandardVM -> {
                val intent = createSingleInstanceIntent<MainActivity>()
                startActivity(intent)
            }
            else -> {
                null
            }
        }

    }
}