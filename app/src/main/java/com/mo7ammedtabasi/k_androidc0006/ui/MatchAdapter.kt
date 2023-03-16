package com.mo7ammedtabasi.k_androidc0006.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mo7ammedtabasi.k_androidc0006.R
import com.mo7ammedtabasi.k_androidc0006.data.domain.Match
import com.mo7ammedtabasi.k_androidc0006.databinding.ItemMatchBinding
import com.mo7ammedtabasi.k_androidc0006.databinding.ItemMatchesHeaderBinding

class MatchAdapter(private var list: List<Match> ,private val listener:MatchInteractionListener) : RecyclerView.Adapter<MatchAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when(viewType){
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_matches_header, parent, false)
                return HeaderViewHolder(view)
            }
            VIEW_TYPE_MATCH -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
                return MatchViewHolder(view)
            }
        }
        return super.createViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentMatch = list[position]
        when(holder){
            is MatchViewHolder -> {
                holder.binding.apply {
                    textHomeName.text = currentMatch.homeTeamName
                    textAwayName.text = currentMatch.awayTeamName
                    textHomeGoals.text = currentMatch.homeTeamGoals.toString()
                    textAwayGoals.text = currentMatch.awayTeamGoals.toString()
                    textYear.text = currentMatch.year.toString()
                    textHomeName.setOnClickListener { listener.onClickITeamName(currentMatch.homeTeamName) }
                    textAwayName.setOnClickListener { listener.onClickITeamName(currentMatch.awayTeamName) }
                    root.setOnClickListener { listener.onClickItem(currentMatch) }
                    iconDelete.setOnClickListener { listener.deleteItemAt(position) }

                    if (currentMatch.homeTeamGoals > currentMatch.awayTeamGoals){
                        textHomeGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                        textAwayGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.red))
                    } else if (currentMatch.homeTeamGoals < currentMatch.awayTeamGoals){
                        textAwayGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                        textHomeGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.red))
                    } else {
                        textHomeGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_500))
                        textAwayGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_500))
                    }
                }
            }
            is HeaderViewHolder -> {

            }
        }

    }

    fun setData(newList:List<Match>){
        val diffResult = DiffUtil.calculateDiff(MatchDiffUtil(list, newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            VIEW_TYPE_HEADER
        } else {
            VIEW_TYPE_MATCH
        }
    }

    abstract inner class BaseViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem)

    inner class MatchViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchBinding.bind(viewItem)
    }

    inner class HeaderViewHolder(viewItem: View) : BaseViewHolder(viewItem){
        val binding = ItemMatchesHeaderBinding.bind(viewItem)
    }

    companion object{
        const val VIEW_TYPE_HEADER = 11
        const val VIEW_TYPE_MATCH = 12
    }
}

