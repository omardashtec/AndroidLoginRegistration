package com.learn2crack.loginregistration

import android.app.Fragment
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var pref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getPreferences(0)
        initFragment()
    }

    private fun initFragment() {
        val fragment: Fragment
        fragment = if (pref!!.getBoolean(Constants.IS_LOGGED_IN, false)) {
            ProfileFragment()
        } else {
            LoginFragment()
        }
        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.fragment_frame, fragment)
        ft.commit()
    }

    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        supportFragmentManager.fragments.forEach {
            it?.onActivityResult(requestCode, resultCode, data)
        }
    }
}