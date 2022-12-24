package com.sidra.multimoduleapparch

import android.app.Application
import com.sidra.multimoduleapparch.container.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)

            androidContext(this@BaseApplication)
        }
    }
}