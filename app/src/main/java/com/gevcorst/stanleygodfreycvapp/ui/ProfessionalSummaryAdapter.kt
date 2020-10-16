package com.gevcorst.stanleygodfreycvapp.ui

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.databinding.ProfessionalSummaryItemBinding
import com.gevcorst.stanleygodfreycvapp.model.Resume
import com.gevcorst.stanleygodfreycvapp.viewModel.ResumeViewModel
import java.io.File

class ProfessionalSummaryAdapter(private val summaries: List<String>):RecyclerView.Adapter<ProfessionalSummaryAdapter.PSViewHolder>(){
  private lateinit var pSummaries:List<String>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PSViewHolder {
        val inflatedView = parent.inflate(R.layout.professional_summary_item, false)
        return PSViewHolder(inflatedView)
    }
 init {
     pSummaries = summaries
 }
    override fun getItemCount(): Int {
       return pSummaries.size
    }

    override fun onBindViewHolder(holder: PSViewHolder, position: Int) {
        holder.bind(pSummaries[position])
    }

    class PSViewHolder(v:View):RecyclerView.ViewHolder(v) {
        private var view: View = v
     private val textView:TextView = view.findViewById(R.id.pf_item)
        fun bind(string: String) {
          textView.text = string
        }
    }

}