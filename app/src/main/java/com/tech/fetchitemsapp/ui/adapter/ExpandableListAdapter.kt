package com.tech.fetchitemsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech.fetchitemsapp.R


class ExpandableListAdapter(private val groupedItems: Map<String, List<String>>) :
    RecyclerView.Adapter<ExpandableListAdapter.GroupViewHolder>() {

    private val expandedGroups = mutableSetOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expandable_group, parent, false)
        return GroupViewHolder(view)
    }



    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val groupKey = groupedItems.keys.elementAt(position)
        holder.bind(groupKey, groupedItems[groupKey] ?: emptyList())
    }

    override fun getItemCount(): Int = groupedItems.size

    inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.text1) // Update this line
        private val childContainer: ViewGroup = itemView.findViewById(R.id.child_container) // Ensure this ID is correct

        fun bind(groupKey: String, items: List<String>) {
            textView.text = groupKey
            textView.setOnClickListener {
                if (expandedGroups.contains(groupKey)) {
                    expandedGroups.remove(groupKey)
                } else {
                    expandedGroups.add(groupKey)
                }
                notifyDataSetChanged() // Refresh the list
            }

            // Show or hide child items based on the group's expansion state
            if (expandedGroups.contains(groupKey)) {
                childContainer.visibility = View.VISIBLE
                childContainer.removeAllViews() // Clear previous views

                // Add child views
                items.forEach { item ->
                    val childView = LayoutInflater.from(itemView.context)
                        .inflate(android.R.layout.simple_list_item_1, childContainer, false) as TextView
                    childView.text = item
                    childContainer.addView(childView)
                }
            } else {
                childContainer.visibility = View.GONE
            }
        }
    }


}

