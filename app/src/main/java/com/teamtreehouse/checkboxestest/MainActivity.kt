package com.teamtreehouse.checkboxestest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    relativeLayout {
      val myLayoutManger = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
      myLayoutManger.isItemPrefetchEnabled = false
      recyclerView {
        adapter = MyAdapter()
        layoutManager = myLayoutManger
      }.lparams(width = matchParent)
    }
  }
}
