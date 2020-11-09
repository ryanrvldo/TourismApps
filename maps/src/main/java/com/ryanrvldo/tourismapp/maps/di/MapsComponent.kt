package com.ryanrvldo.tourismapp.maps.di

import com.ryanrvldo.tourismapp.core.di.CoreComponent
import com.ryanrvldo.tourismapp.core.di.UseCaseModule
import com.ryanrvldo.tourismapp.maps.MapsActivity
import dagger.Component

@MapsScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [UseCaseModule::class]
)
interface MapsComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: CoreComponent): MapsComponent
    }

    fun inject(mapsActivity: MapsActivity)

}
