package com.ryanrvldo.tourismapp.di

import com.ryanrvldo.tourismapp.core.di.AppScope
import com.ryanrvldo.tourismapp.core.di.CoreComponent
import com.ryanrvldo.tourismapp.core.di.UseCaseModule
import com.ryanrvldo.tourismapp.detail.DetailTourismActivity
import com.ryanrvldo.tourismapp.favorite.FavoriteFragment
import com.ryanrvldo.tourismapp.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [UseCaseModule::class, ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)

    fun inject(fragment: FavoriteFragment)

    fun inject(detailTourismActivity: DetailTourismActivity)

}
