package com.waigres

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.preference.PreferenceManager
import com.waigres.MainActivity.Companion.LIST_FUN_FACT
import kotlinx.android.synthetic.main.activity_warning.*

class WarningActivity : AppCompatActivity() {
    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warning)

        prefs = PreferenceManager.getDefaultSharedPreferences(application)
        val list = getFunFact()
        tv_fun_fact.text = "\"${list.get(getRandomIndex(list.size))}\""

        close_btn.setOnClickListener {
            finish()
        }
    }

    private fun getRandomIndex(length: Int) : Int {
        return (0 until length).random()
    }

    private fun getFunFact(): List<String> {
        val listString = prefs?.getString(LIST_FUN_FACT, "")

        return listString?.replace("[", "")?.replace("]", "")?.split(", ")?: arrayListOf()
    }
}