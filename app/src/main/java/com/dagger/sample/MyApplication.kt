package com.dagger.sample

import android.app.Application
import com.dagger.sample.di.component.ApplicationComponent
import com.dagger.sample.di.component.DaggerApplicationComponent

class MyApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()

}