package com.mo7ammedtabasi.k_androidc0006.data

import com.mo7ammedtabasi.k_androidc0006.data.domain.Match

object DataManger {
    private val matchesList = mutableListOf<Match>()
    val matches: List<Match>
        get() = matchesList.toList()
    private var matchIndex = 0

    fun getCurrentMatch():Match = matchesList[matchIndex]
    fun addMatch(match: Match){
        matchesList.add(match)
    }

    fun deleteMatch(index: Int){
        matchesList.removeAt(index)
    }

//    fun matches() = matchesList

    fun addMatchAtIndex(match: Match,index:Int) {
        matchesList.add(index,match)
    }

    fun getNextMatch():Match{
        matchIndex++
        if (matchIndex == matchesList.size){
            matchIndex = 0
        }
        return matchesList[matchIndex]
    }

    fun getPreviuosMatch():Match{
        matchIndex--
        if (matchIndex == -1){
            matchIndex = matchesList.size-1
        }
        return matchesList[matchIndex]
    }


}