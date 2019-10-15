package com.gevcorst.stanleygodfreycvapp.ui


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.FragmentHomeBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel



/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val viewModel: ResumeViewModel by lazy {
        ViewModelProviders.of(this).get( ResumeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding:FragmentHomeBinding =
           DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)
        binding.pf.setOnClickListener{
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProfessionalSummary())
        }
        binding.ws.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeToWorkExperienceFragment())
        }
        binding.ts.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeToTechnicalSkillsFragment())
        }
        binding.ed.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeToEducationFragment())
        }


        return binding.root
    }

}
