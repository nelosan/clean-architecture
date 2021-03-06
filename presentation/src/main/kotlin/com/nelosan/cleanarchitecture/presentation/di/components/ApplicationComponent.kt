package com.nelosan.cleanarchitecture.presentation.di.components

import android.app.Application
import dagger.Component
import com.nelosan.cleanarchitecture.presentation.AndroidApplication
import com.nelosan.cleanarchitecture.presentation.di.modules.ApplicationModule
import io.reactivex.Scheduler

import javax.inject.Named

import javax.inject.Singleton

/**
 * Created by nelo on 20/2/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @Named("ui_thread") fun uiThread(): Scheduler
    @Named("executor_thread") fun executorThread(): Scheduler

    fun inject(application: AndroidApplication)

    fun application(): Application

}