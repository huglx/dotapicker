package com.task.di

import com.hugl.peekme.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ActivityModuleBuilder::class,
            ViewModelModule::class,
            AndroidInjectionModule::class,
            AppModule::class,
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: Application)
}
