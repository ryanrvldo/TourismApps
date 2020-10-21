package com.ryanrvldo.tourismapp.di

import com.ryanrvldo.tourismapp.core.di.CoreComponent
import com.ryanrvldo.tourismapp.detail.DetailTourismActivity
import com.ryanrvldo.tourismapp.favorite.FavoriteFragment
import com.ryanrvldo.tourismapp.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)

    fun inject(fragment: FavoriteFragment)

    fun inject(activity: DetailTourismActivity)

}