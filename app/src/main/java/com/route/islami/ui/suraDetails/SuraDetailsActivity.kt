package com.route.islami.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Constants
import com.route.islami.R

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);   //show back button
        titleTextView = findViewById(R.id.title_text_view)
        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

        val suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME);
        val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POS, -1)
        titleTextView.setText(suraName)
        readSuraContent("${suraPos + 1}.txt")

    }

    fun readSuraContent(fileName: String) {
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() };
        val lines: List<String> = fileContent.split("\n")
        adapter.changeData(lines)

    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}