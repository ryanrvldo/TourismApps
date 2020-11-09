package com.ryanrvldo.tourismapp.maps

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ryanrvldo.tourismapp.BaseApplication
import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.maps.di.DaggerMapsComponent
import kotlinx.android.synthetic.main.activity_maps.*
import javax.inject.Inject

class MapsActivity : AppCompatActivity() {

    @Inject
    lateinit var mapsViewModel: MapsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val coreComponent = (application as BaseApplication).coreComponent

        DaggerMapsComponent.factory()
            .create(coreComponent)
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        supportActionBar?.title = "Tourism Map"
        getTourismData()

    }

    private fun getTourismData() {
        mapsViewModel.tourism.observe(this) { tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        progress_bar.visibility = View.GONE
                        tv_maps.text = "This is map of ${tourism.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        progress_bar.visibility = View.GONE
                        tv_error.visibility = View.VISIBLE
                        tv_error.text = tourism.message
                    }
                }
            }
        }
    }
}
