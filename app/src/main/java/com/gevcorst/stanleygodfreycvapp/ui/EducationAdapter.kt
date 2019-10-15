package com.gevcorst.stanleygodfreycvapp.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gevcorst.stanleygodfreycvapp.R
import com.gevcorst.stanleygodfreycvapp.model.Education

class EducationAdapter(private val educationList: List<Education>): RecyclerView.Adapter<EducationAdapter.ViewHolder>(){
    lateinit private var eduList:List<Education>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.education_item, false)
        return ViewHolder(inflatedView)
    }
    init {
        eduList = educationList
    }
    override fun getItemCount(): Int {
        return eduList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(eduList[position])
    }


    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        private var view: View = v
        private val schoolName: TextView = view.findViewById(R.id.schoolName)
        private  val degreeAwarded : TextView = view.findViewById(R.id.degreeAwarded)
        private val startDate: TextView = view.findViewById(R.id.sdate)
        private  val endDate : TextView = view.findViewById(R.id.dateEnded)
        private val standing: TextView = view.findViewById(R.id.stands)
        fun bind(edu: Education) {
          schoolName.text = edu.schoolName
            degreeAwarded.text = edu.degreeAwarded
            startDate.text = edu.startDate
            endDate.text = edu.endDate
            standing.text = edu.standing

        }
    }
}