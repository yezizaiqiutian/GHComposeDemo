package com.gh.ghcomposedemo

import android.app.Application
import android.content.Context

class MyApp:Application() {

    companion object{
        lateinit var CONTEXT:Context
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this
    }

}