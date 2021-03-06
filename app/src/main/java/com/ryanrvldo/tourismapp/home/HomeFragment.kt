package com.ryanrvldo.tourismapp.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryanrvldo.tourismapp.BaseApplication
import com.ryanrvldo.tourismapp.R
import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.core.ui.TourismAdapter
import com.ryanrvldo.tourismapp.core.ui.ViewModelFactory
import com.ryanrvldo.tourismapp.detail.DetailTourismActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val homeViewModel: HomeViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as BaseApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tourismAdapter = TourismAdapter()
        tourismAdapter.onItemClick = { selectedData ->
            val intent = Intent(requireActivity(), DetailTourismActivity::class.java)
            intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        homeViewModel.tourism.observe(viewLifecycleOwner, { tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        progress_bar.visibility = View.GONE
                        tourismAdapter.setData(tourism.data)
                    }
                    is Resource.Error -> {
                        progress_bar.visibility = View.GONE
                        view_error.visibility = View.VISIBLE
                        tv_error.text = tourism.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })

        with(rv_tourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

}
