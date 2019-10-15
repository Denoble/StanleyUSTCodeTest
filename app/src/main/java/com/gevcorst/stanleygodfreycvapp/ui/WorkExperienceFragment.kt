package com.gevcorst.stanleygodfreycvapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.WorkExperienceListBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel

/**
 * A simple [Fragment] subclass.
 */
class WorkExperienceFragment : Fragment() {
    private val viewModel: ResumeViewModel by lazy {
        ViewModelProviders.of(this).get( ResumeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding:WorkExperienceListBinding = DataBindingUtil.inflate(inflater,
           R.layout.work_experience_list,container,false)
        binding.setLifecycleOwner (this)
        binding.weModel = viewModel
        viewModel.Stanresume.observe(this, Observer {
            binding.wsList.layoutManager = LinearLayoutManager(this.requireContext())
            binding.wsList.adapter = WorkExperienceAdapter(it.workExperience)
        })


        return binding.root
    }


}
