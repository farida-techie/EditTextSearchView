package com.malkinfo.edittextsearchview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(var courseList:ArrayList<Course>,context:Context):
RecyclerView.Adapter<CourseAdapter.CourseViewHolder>()
{
   inner class CourseViewHolder(val v: View):RecyclerView.ViewHolder(v)
   {
       val courseNameTx = v.findViewById<TextView>(R.id.idTVCourseName)
       val courseDesripTx = v.findViewById<TextView>(R.id.idTVCourseDescription)

    }
    /*here we filter List*/
    fun filterList(filterlist:ArrayList<Course>){
        courseList = filterlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
       val v = LayoutInflater.from(parent.context)
           .inflate(R.layout.course_item,parent,false)
        return CourseViewHolder(v)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
      val newCourseList = courseList[position]
        holder.courseNameTx.text = newCourseList.courseName
        holder.courseDesripTx.text = newCourseList.courseDescription
    }

    override fun getItemCount(): Int = courseList.size
}