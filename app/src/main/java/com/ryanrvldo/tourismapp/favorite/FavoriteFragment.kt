package com.ryanrvldo.tourismapp.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryanrvldo.tourismapp.R
import com.ryanrvldo.tourismapp.core.ui.TourismAdapter
import com.ryanrvldo.tourismapp.detail.DetailTourismActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.rv_tourism

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tourismAdapter = TourismAdapter()
        tourismAdapter.onItemClick = { selectedData ->
            val intent = Intent(requireActivity(), DetailTourismActivity::class.java)
            intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTourism.observe(viewLifecycleOwner, { dataTourism ->
            tourismAdapter.setData(dataTourism)
            view_empty.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(rv_tourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

}
