package com.mo7ammedtabasi.k_androidc0006.ui

import com.mo7ammedtabasi.k_androidc0006.data.domain.Match

interface MatchInteractionListener {
    fun onClickItem(match: Match)
    fun onClickITeamName(name:String)
    fun deleteItemAt(index:Int)
}