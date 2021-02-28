package com.task.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.hugl.peekme.Application
import com.hugl.peekme.utils.Network
import com.hugl.peekme.utils.NetworkConnectivity
import com.hugl.peekme.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivity(): NetworkConnectivity {
        return Network(Application.context)
    }
}
