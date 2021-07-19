package com.dagger.sample.di.component

import com.dagger.sample.view.MainActivity
import com.dagger.sample.di.module.NetworkModule
import com.dagger.sample.di.module.SharedPrefModule
import com.dagger.sample.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPrefModule::class, NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}