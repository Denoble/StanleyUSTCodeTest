package com.gevcorst.stanleygodfreycvapp.ui

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.ActivityMainBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel

class MainActivity : AppCompatActivity() {
    enum class ConnectivityMode {
        NONE,
        WIFI,
        MOBILE,
        OTHER,
        MAYBE
    }
    var connectivityMode = ConnectivityMode.NONE
    private val viewModel: ResumeViewModel by lazy {
        ViewModelProviders.of(this).get( ResumeViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val binding = DataBindingUtil.setContentView(this,R.layout.activity_main) as
               ActivityMainBinding
        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        connectivityMode = checkConnectivity(this.applicationContext)
        if(!(connectivityMode == ConnectivityMode.MOBILE
            || connectivityMode == ConnectivityMode.WIFI)){
            showNoInternetAlertDialog()
        }
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


    private fun checkConnectivity(context: Context): MainActivity.ConnectivityMode {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        cm?.run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getNetworkCapabilities(activeNetwork)?.run {
                    return when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> MainActivity.ConnectivityMode.WIFI
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> ConnectivityMode.MOBILE
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> ConnectivityMode.OTHER
                        hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> ConnectivityMode.MAYBE
                        else -> ConnectivityMode.NONE
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                activeNetworkInfo?.run {
                    return when (type) {
                        ConnectivityManager.TYPE_WIFI -> ConnectivityMode.WIFI
                        ConnectivityManager.TYPE_MOBILE -> ConnectivityMode.MOBILE
                        ConnectivityManager.TYPE_ETHERNET -> ConnectivityMode.OTHER
                        ConnectivityManager.TYPE_BLUETOOTH -> ConnectivityMode.MAYBE
                        else -> ConnectivityMode.NONE
                    }
                }
            }
        }
        return ConnectivityMode.NONE
    }
    fun showNoInternetAlertDialog(){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("You are not connected to the Internet !")
            .setCancelable(false)
            .setPositiveButton("Close App", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Internet Connection")
        alert.show()
        alert.window?.setBackgroundDrawableResource(R.color.colorPrimary)
    }
}
