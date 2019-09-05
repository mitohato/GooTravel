package com.ict.mito.gootravel.spot.select.radar.ui.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.model.SpotData

/**
 * Created by mitohato14 on 2019-09-05.
 */
class SelectSpotBottomSheetViewModel : ViewModel() {
    private val _spotData: MutableLiveData<SpotData> = MutableLiveData()
    val spotData: LiveData<SpotData>
        get() = _spotData

    val distance: String = "0m"

    fun setId(id: Int) {
        _spotData.postValue(_spotData.value?.copy(id = id))
    }
}