package com.example.shoppinglist.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()
        viewModel.shopList.observe(this) {
            shopListAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView(){
        val rvShopList = findViewById<RecyclerView>(R.id.rvShopList)
        shopListAdapter = ShopListAdapter()
        rvShopList.adapter = shopListAdapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLE ,ShopListAdapter.MAX_RECYCLED_VIEW_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLE, ShopListAdapter.MAX_RECYCLED_VIEW_POOL_SIZE)
        setupClickListeners()
        setupItemTouchHelper(rvShopList)
    }

    private fun setupItemTouchHelper(rvShopList: RecyclerView?) {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.removeShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun setupClickListeners() {
        shopListAdapter.onShopItemClickListener = {
            //TODO: new Intent
        }
        shopListAdapter.onShopItemLongClickListener = {
            viewModel.editShopItem(it)
        }
    }

}