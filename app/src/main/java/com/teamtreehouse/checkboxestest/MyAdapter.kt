package com.teamtreehouse.checkboxestest

import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import org.jetbrains.anko.checkBox
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick


class MyAdapter  : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
  val checks = mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false, false)
  val nextChecks = mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false, false)

  override fun getItemCount() = checks.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = parent.checkBox {
      id = 1
    }
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.update(position)
  }

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val check = view.find<CheckBox>(1)

    fun update(index: Int) {
      check.isChecked = checks[index]

      // Use a Handler and post the update so it happens after this code runs and is seens as an
      // actual change (instead of just how the code started).
      Handler().post {
        checks[index] = nextChecks[index]
        check.isChecked = checks[index]
      }

      check.onClick {
        if (check.isChecked) {
          // Set all other nextChecks to false...
          (0..checks.lastIndex)
              .filter { it != index }
              .forEach { nextChecks[it] = false }
          // and set this one to true.
          nextChecks[index] = true
        } else {
          // Otherwise, just set this nextChecks to false
          nextChecks[index] = false
        }
        notifyDataSetChanged()
      }
    }
  }
}