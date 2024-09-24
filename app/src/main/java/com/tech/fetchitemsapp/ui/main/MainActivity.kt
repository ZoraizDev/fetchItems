package com.tech.fetchitemsapp.ui.main


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech.fetchitemsapp.R
import com.tech.fetchitemsapp.data.repositry.ItemsRepository
import com.tech.fetchitemsapp.domain.repositry.ItemRepository
import com.tech.fetchitemsapp.domain.repositry.ItemRepositoryImpl
import com.tech.fetchitemsapp.ui.adapter.ExpandableListAdapter
import com.tech.fetchitemsapp.ui.viewmodel.ItemsViewModel
import com.tech.fetchitemsapp.ui.viewmodel.ItemsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val itemsViewModel: ItemsViewModel by viewModels {
        ItemsViewModelFactory(ItemsRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemsViewModel.groupedItems.observe(this, Observer { groupedItems ->
            recyclerView.adapter = ExpandableListAdapter(groupedItems)
        })

        // Fetch items
        itemsViewModel.fetchItems()
    }
}
