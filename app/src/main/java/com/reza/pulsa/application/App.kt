package com.reza.pulsa.application

import android.app.Application
import com.reza.pulsa.application.di.InjectionModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(InjectionModules.getModules())
        }
    }
}