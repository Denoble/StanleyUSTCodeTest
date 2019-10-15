package com.gevcorst.stanleygodfreycvapp.ui


import android.os.Bundle
import android.util.Log
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
import com.gevcorst.stanleygodfreycvapp.databinding.TechnicalSkillsListBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel

/**
 * A simple [Fragment] subclass.
 */
class TechnicalSkillsFragment : Fragment() {
    private val viewModel: ResumeViewModel by lazy {
        ViewModelProviders.of(this).get( ResumeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val binding:TechnicalSkillsListBinding = DataBindingUtil.inflate(
             inflater,R.layout.technical_skills_list,container,false)
            binding.setLifecycleOwner (this)

        viewModel.Stanresume.observe(this, Observer {
            binding.androidTech.text = it.technicalSkill.androidTechnologies
            binding.databases.text = it.technicalSkill.databases
            binding.deveTools.text =  it.technicalSkill.developmentTools
            binding.iosTech.text =  it.technicalSkill.iOSTechnologies
            binding.intTools.text = it.technicalSkill.integrationTools
            binding.languages.text =  it.technicalSkill.languages
            binding.dotnetTech.text = it.technicalSkill.nETTechnologies
            binding.operatingSystem.text = it.technicalSkill.operatingSystems
            binding.testingTools.text = it.technicalSkill.testingTools

        })

            return binding.root
        }



}
