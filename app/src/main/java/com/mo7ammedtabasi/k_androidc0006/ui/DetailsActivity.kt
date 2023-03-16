package com.mo7ammedtabasi.k_androidc0006.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.mo7ammedtabasi.k_androidc0006.R
import com.mo7ammedtabasi.k_androidc0006.data.domain.Match
import com.mo7ammedtabasi.k_androidc0006.databinding.ActivityDetailsBinding
import com.mo7ammedtabasi.k_androidc0006.util.Constants

class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {
    override val LOG_TAG: String  = "Details_Activity"
    override val bindingInflater: (LayoutInflater) -> ActivityDetailsBinding = ActivityDetailsBinding:: inflate

    override fun setup() {
        val match: Match? = intent.getSerializableExtra(Constants.key.MATCH) as Match?
        match?.let { bindMatch(it)}
    }

    private fun bindMatch(match: Match) {
        binding?.apply {
            textHomeName.text = match.homeTeamName
            textAwayName.text = match.awayTeamName
            textHomeGoals.text = match.homeTeamGoals.toString()
            textAwayGoals.text = match.awayTeamGoals.toString()
            textYaer.text = match.year.toString()
        }
    }

    override fun addCallBack() {

    }

}