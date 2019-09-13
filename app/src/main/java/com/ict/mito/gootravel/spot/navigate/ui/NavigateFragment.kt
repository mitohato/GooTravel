package com.ict.mito.gootravel.spot.navigate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.NavigateFragmentBinding
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.util.rotateImage
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigateFragment : Fragment() {

    private val viewModel: NavigateViewModel by viewModel()
    private var binding: NavigateFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.bottom_appbar?.replaceMenu(R.menu.empty_menu)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.navigate_fragment,
            container,
            false

        )

        val viewmodelObserver = Observer<Double> {
            binding?.let {
                val image = rotateImage(
                    resources,
                    viewModel.direction.value?.toDouble() ?: 0.0
                )
                it.arrowImage?.setImageBitmap(image)
                it.notifyChange()
            }
        }

        viewModel.also {
            it.direction.observe(
                this,
                viewmodelObserver
            )
            it.distance.observe(
                this,
                viewmodelObserver
            )
            it.orientationLiveData.observe(
                this,
                Observer { orientation ->
                    it.azimuth.postValue(orientation.azimuth.toDouble())
                }
            )
            it.locationLiveData.observe(
                this,
                Observer { location ->
                    it.latitude.postValue(location.latitude)
                    it.longitude.postValue(location.longitude)
                }
            )
            it.spotData = SpotData(
                "Dummy",
                0.0,
                0.0,
                0,
                ""
            )
        }

        binding?.let {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
