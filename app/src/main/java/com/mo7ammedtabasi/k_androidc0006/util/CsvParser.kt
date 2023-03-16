package com.mo7ammedtabasi.k_androidc0006.util

import com.mo7ammedtabasi.k_androidc0006.data.domain.Match

class CsvParser {
    fun parse(line:String):Match{
        val tokens = line.split(",")
        return Match(
            year = Integer.parseInt(tokens[Constants.ColumnIndex.YEAR]),
            stadium = tokens[Constants.ColumnIndex.STADIUM],
            city = tokens[Constants.ColumnIndex.CITY],
            homeTeamName = tokens[Constants.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constants.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamGoals = tokens[Constants.ColumnIndex.HOME_TEAM_GOALS].toInt(),
            awayTeamGoals = tokens[Constants.ColumnIndex.AWAY_TEAM_GOALS].toInt(),
            refereeName = tokens[Constants.ColumnIndex.REFEREE_NAME]
        )
    }
}