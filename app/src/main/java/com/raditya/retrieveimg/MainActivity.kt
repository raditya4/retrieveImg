package com.raditya.retrieveimg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.raditya.retrieveimg.model.InfoPlantData
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mDB : DatabaseReference
    private lateinit var plantList : ArrayList<InfoPlantData>
    private lateinit var mAdapter: infoPlantAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plantList = ArrayList()
        mAdapter = infoPlantAdapter(this,plantList)
        recyclerPlant.layoutManager = LinearLayoutManager(this)
        recyclerPlant.setHasFixedSize(true)
        getPlantData()
    }

    private fun getPlantData() {
        mDB = FirebaseDatabase.getInstance().getReference("Deskripsi")
        mDB.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (plantSnapshot in snapshot.children){
                        val plant = plantSnapshot.getValue(InfoPlantData::class.java)
                        plantList.add(plant!!)
                    }
                    recyclerPlant.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,
                    error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}