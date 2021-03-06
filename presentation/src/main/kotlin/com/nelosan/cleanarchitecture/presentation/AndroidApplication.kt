package com.nelosan.cleanarchitecture.presentation

import android.app.Application
import com.nelosan.cleanarchitecture.presentation.di.components.ApplicationComponent
import com.nelosan.cleanarchitecture.presentation.di.components.DaggerApplicationComponent
import com.nelosan.cleanarchitecture.presentation.di.modules.ApplicationModule
import com.nelosan.cleanarchitecture.presentation.navigation.Navigator
import javax.inject.Inject

/**
 * Created by nelo on 20/2/17.
 */

class AndroidApplication: Application() {

    @Inject lateinit var navigator: Navigator

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        //initializeLeakDetection()
    }

    /*private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }*/

}