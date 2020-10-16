package com.gevcorst.stanleygodfreycvapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.EducationListBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel

/**
 * A simple [Fragment] subclass.
 */
class EducationFragment : Fragment() {
    private val viewModel: ResumeViewModel by lazy {
        ViewModelProviders.of(this).get( ResumeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = EducationListBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        viewModel.Stanresume.observe(this, Observer {
            binding.eduList.layoutManager = LinearLayoutManager(this.requireContext())
            binding.eduList.adapter =  EducationAdapter(it.education)
            binding.progressBarEd.visibility = View.GONE
            binding.eduList.visibility = View.VISIBLE
        })
        return binding.root
        }



}
