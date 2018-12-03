package com.sulistyo.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.sulistyo.footballclub.R.array.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<DataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        recyclerClub.layoutManager = LinearLayoutManager(this)
        recyclerClub.adapter = RecyclerViewAdapter(this, items) {
            itemKlik(it)
        }

    }

    private fun initData() {
        val name = resources.getStringArray(clubName)
        val image = resources.obtainTypedArray(clubImage)
        val deskrip = resources.getStringArray(clubDescription)
        items.clear()
        for (i in name.indices) {
            items.add(
                DataItem(
                    name[i],
                    image.getResourceId(i, 0),
                    deskrip[i]
                )
            )
        }
        image.recycle()
    }

    private fun itemKlik(item: DataItem) {
        startActivity<DetailClubActivity>(
            DetailClubActivity.TITLE to item.name,
            DetailClubActivity.IMAGE to item.image,
            DetailClubActivity.DESCRIPTION to item.description
        )

    }

}
