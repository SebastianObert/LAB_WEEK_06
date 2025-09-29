package com.example.lab_week_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatViewHolder.OnClickListener {
                override fun onItemClick(cat: CatModel) {
                    showSelectionDialog(cat)
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        val catsData = listOf(
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Fred",
                "Silent and deadly",
                "https://cdn2.thecatapi.com/images/7dj.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Wilma",
                "Cuddly assassin",
                "https://cdn2.thecatapi.com/images/egv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Curious George",
                "Award winning investigator",
                "https://cdn2.thecatapi.com/images/bar.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Luna",
                "Loves tuna and naps",
                "https://cdn2.thecatapi.com/images/5kl.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Simba",
                "King of the living room",
                "https://cdn2.thecatapi.com/images/d55.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Oreo",
                "Master of hiding",
                "https://cdn2.thecatapi.com/images/47s.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Bella",
                "Very vocal and playful",
                "https://cdn2.thecatapi.com/images/b6d.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Max",
                "A true gentleman",
                "https://cdn2.thecatapi.com/images/ebv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.BalineseJavanese,
                "Mochi",
                "Sweet and fluffy",
                "https://cdn2.thecatapi.com/images/9us.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Lucy",
                "Loves chasing laser pointers",
                "https://cdn2.thecatapi.com/images/a2b.jpg"
            )
        )

        catAdapter.setData(catsData)
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}