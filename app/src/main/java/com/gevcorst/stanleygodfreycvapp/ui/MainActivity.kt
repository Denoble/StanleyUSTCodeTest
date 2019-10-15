package com.gevcorst.stanleygodfreycvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.ActivityMainBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: ResumeViewModel by lazy {
        ViewModelProviders.of(this).get( ResumeViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding = DataBindingUtil.setContentView(this,R.layout.activity_main) as
               ActivityMainBinding
        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        binding.mainModel = viewModel
       viewModel.Stanresume.observe(this, Observer {
           binding.name.text = it.name
          binding.email.text = it.email
           binding.phone.text = it.phone
           binding.androidPortfolio.text = it.androidPortfolio
           binding.linkedin.text = it.linkedIn

       })
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
