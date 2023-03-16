package com.mo7ammedtabasi.k_androidc0006.ui

import androidx.recyclerview.widget.DiffUtil
import com.mo7ammedtabasi.k_androidc0006.data.domain.Match

class MatchDiffUtil(val mOldList:List<Match>,val mNewList:List<Match>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = mOldList.size

    override fun getNewListSize(): Int = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                mOldList[oldItemPosition].homeTeamName == mNewList[newItemPosition].homeTeamName &&
                mOldList[oldItemPosition].awayTeamName == mNewList[newItemPosition].awayTeamName
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}