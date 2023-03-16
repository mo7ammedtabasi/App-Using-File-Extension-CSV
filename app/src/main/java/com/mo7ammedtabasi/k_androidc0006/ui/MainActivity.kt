package com.mo7ammedtabasi.k_androidc0006.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mo7ammedtabasi.k_androidc0006.R
import com.mo7ammedtabasi.k_androidc0006.data.DataManger
import com.mo7ammedtabasi.k_androidc0006.data.domain.Match
import com.mo7ammedtabasi.k_androidc0006.databinding.ActivityMainBinding
import com.mo7ammedtabasi.k_androidc0006.util.Constants
import com.mo7ammedtabasi.k_androidc0006.util.CsvParser
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() , MatchInteractionListener{
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    private lateinit var adapter: MatchAdapter
    override fun setup() {
       parseFile()
        adapter = MatchAdapter(DataManger.matches,this)
        binding?.recycleMatch?.adapter = adapter
    }

    override fun addCallBack() {
        binding?.apply {
//            iconNext.setOnClickListener {
//                bindMatch(DataManger.getNextMatch())
//            }
//            iconPrevious.setOnClickListener {
//                bindMatch(DataManger.getPreviuosMatch())
//            }

            fab.setOnClickListener { 
                addFinalMatch()
            }
        }
    }

    private fun addFinalMatch() {
        val finalMatch = Match(
            homeTeamName = "France",
            awayTeamName = "Croatia",
            year = 2018,
            homeTeamGoals = 4,
            awayTeamGoals = 2,
            city = "Moscow",
            stadium = "Luzhniki Stadium",
            refereeName = "Ali"
        )

//        DataManger.addMatchAtIndex(finalMatch,0)
        DataManger.addMatchAtIndex(finalMatch,1)
        adapter.setData(DataManger.matches)
    }

    private  fun parseFile(){
        val inputStream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currentMatch = parser.parse(it)
            DataManger.addMatch(currentMatch)
        }
        bindMatch(DataManger.getCurrentMatch())
    }

    private fun bindMatch(match: Match){
        binding?.apply {
//            textYear.text = match.year.toString()
//            textStadium.text = match.stadium
//            textHomeName.text = match.homeTeamName
//            textAwayName.text = match.awayTeamName
//            textHomeGoals.text = match.homeTeamGoals.toString()
//            textAwayGoals.text = match.awayTeamGoals.toString()


        }
    }

    override fun onClickItem(match: Match) {
        val intent = Intent(applicationContext,DetailsActivity::class.java)
        intent.putExtra(Constants.key.MATCH,match)
        startActivity(intent)
    }

    override fun onClickITeamName(name: String) {
        Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
    }

    override fun deleteItemAt(index: Int) {
        DataManger.deleteMatch(index)
        adapter.setData(DataManger.matches)
    }

}