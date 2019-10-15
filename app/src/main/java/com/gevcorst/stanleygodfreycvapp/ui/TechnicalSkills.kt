package com.gevcorst.stanleygodfreycvapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.TechnicalSkillsListBinding

/**
 * A simple [Fragment] subclass.
 */
class TechnicalSkills : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val binding:TechnicalSkillsListBinding =
                DataBindingUtil.inflate(inflater,R.layout.technical_skills_list,container,false)
        return binding.root
        }



}
