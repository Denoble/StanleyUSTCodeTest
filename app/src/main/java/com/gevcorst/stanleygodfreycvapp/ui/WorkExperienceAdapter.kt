package com.gevcorst.stanleygodfreycvapp.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.model.WorkExperience
import java.lang.StringBuilder

class WorkExperienceAdapter(private val workexperience: List<WorkExperience>):RecyclerView.Adapter<WorkExperienceAdapter.ViewHolder>(){
    lateinit private var wkExperiences:List<WorkExperience>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.work_experience_item, false)
        return ViewHolder(inflatedView)
    }
    init {
        wkExperiences = workexperience
    }
    override fun getItemCount(): Int {
        return wkExperiences.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wkExperiences[position])
    }


    class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        private var view: View = v
        private val companyName: TextView = view.findViewById(R.id.companyName)
        private  val position : TextView = view.findViewById(R.id.position)
        private val startDate: TextView = view.findViewById(R.id.deveTools)
        private  val endDate : TextView = view.findViewById(R.id.iosTech)
        private val duties: TextView = view.findViewById(R.id.Duties)
        private  val technicalEnvironment : TextView = view.findViewById(R.id.technicalEnvironment)
        private val github: TextView = view.findViewById(R.id.github)

        fun bind(workexperience:WorkExperience) {
            companyName.text = workexperience.companyName
            position.text = workexperience.position
            startDate.text =workexperience.startDate
            endDate.text = workexperience.endDate
            var sb:StringBuilder = StringBuilder()
            for(str in workexperience.duties){
                sb.append(str)
                sb.append("\n")
            }
            duties.text = sb.toString()
            technicalEnvironment.text = workexperience.technicalEnvironment
            github.text = workexperience.gitHub

        }
    }
}