package com.gevcorst.stanleygodfreycvapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.ProfessionalSummaryListBinding
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel

/**
 * A simple [Fragment] subclass.
 */
class ProfessionalSummary : Fragment() {
  private val viewModel: ResumeViewModel by lazy {
      ViewModelProviders.of(this).get( ResumeViewModel::class.java)
  }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:ProfessionalSummaryListBinding  = DataBindingUtil.inflate(inflater,
            R.layout.professional_summary_list,container,false)
        viewModel.Stanresume.observe(this, Observer {
            binding.pfList.layoutManager = LinearLayoutManager(this.requireContext())
            binding.pfList.adapter = ProfessionalSummaryAdapter(it.professionalSummary)
            binding.progressBarPf.visibility = View.GONE
            binding.pfList.visibility = View.VISIBLE
        })

        return binding.root
    }


}
