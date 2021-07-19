package com.dagger.sample.di.module

import com.dagger.sample.utils.SharedPrefUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class SharedPrefModule {

    @Singleton
    @Provides
    fun provideSharedPrefUtil(): SharedPrefUtil {
        return SharedPrefUtil()
    }

}