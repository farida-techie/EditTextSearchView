package com.malkinfo.edittextsearchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var courseModelArrayList:ArrayList<Course>
    private lateinit var courseAdapter:CourseAdapter
    private lateinit var recCourse:RecyclerView
    private lateinit var searchCourse:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchCourse = findViewById(R.id.searchCourse)
        courseModelArrayList = ArrayList()
        recCourse = findViewById(R.id.recCourse)
        courseAdapter = CourseAdapter(courseModelArrayList,this)
        val layoutManager = LinearLayoutManager(this)
        recCourse.layoutManager = layoutManager
        recCourse.adapter = courseAdapter
        /**ok now run it*/

          /** set List */
        setCourseList()
        searchData()

    }

    private fun searchData() {
       searchCourse.addTextChangedListener(object : TextWatcher {
           override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

           }

           override fun onTextChanged(s: CharSequence?,start: Int, before: Int, count: Int) {
               /*here we add filter*/
               filter(s.toString())
           }

           override fun afterTextChanged(s: Editable?) {

           }
       })
    }

    private fun setCourseList() {
        courseModelArrayList.add(Course("Introduction to Computer Science", "This course covers the basics of computer science, including programming concepts, data structures, and algorithms."))
        courseModelArrayList.add(Course("Mobile App Development", "Learn how to develop mobile apps for Android and iOS using popular programming languages and frameworks."))
        courseModelArrayList.add(Course("Data Science Fundamentals", "This course covers the fundamentals of data science, including statistics, data visualization, and machine learning."))
        courseModelArrayList.add(Course("Web Development Bootcamp", "In this intensive bootcamp, you'll learn how to build web applications using modern front-end and back-end technologies."))
        courseModelArrayList.add(Course("Artificial Intelligence and Machine Learning", "Learn about the latest advances in artificial intelligence and machine learning, including deep learning and natural language processing."))
        courseModelArrayList.add(Course("Game Development with Unity", "In this course, you'll learn how to develop 2D and 3D games using Unity, one of the most popular game engines in the industry."))
        courseModelArrayList.add( Course("Cybersecurity Fundamentals", "Learn about the basics of cybersecurity, including encryption, network security, and ethical hacking."))
        courseModelArrayList.add(Course("Cloud Computing and DevOps", "This course covers cloud computing and DevOps principles and technologies, including cloud providers like AWS and Azure and tools like Docker and Kubernetes."))
        courseModelArrayList.add(Course("Blockchain and Cryptocurrencies", "Discover the world of blockchain and cryptocurrencies, including how they work, their use cases, and their potential impact on the financial industry."))
        courseModelArrayList.add(Course("DSA", "DSA Self Paced Course"))
        courseModelArrayList.add(Course("JAVA", "JAVA Self Paced Course"))
        courseModelArrayList.add(Course("C++", "C++ Self Paced Course"))
        courseModelArrayList.add(Course("Python", "Python Self Paced Course"))
        courseModelArrayList.add(Course("Fork CPP", "Fork CPP Self Paced Course"))
    }

    private fun filter(text:String){
        //here we can filter list
        val filteredList = ArrayList<Course>()
        for (item in courseModelArrayList){
            if (item.courseName.lowercase().contains(text.lowercase())){
                filteredList.add(item)
            }
        }
        courseAdapter.filterList(filteredList)
        if (filteredList.isEmpty()){
            Toast.makeText(this,"No dData Found",Toast.LENGTH_SHORT).show()
        }


    }
}