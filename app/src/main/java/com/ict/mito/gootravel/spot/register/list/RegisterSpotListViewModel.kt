package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.db.DataBaseConverter
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.RegisterPointData
import io.reactivex.rxkotlin.subscribeBy

class RegisterSpotListViewModel(private val repository: Repository) : ViewModel() {
    var registerSpotList: MutableLiveData<List<RegisterPointData>> = MutableLiveData()
    var adapter: RegisterSpotListAdapter =
        RegisterSpotListAdapter(registerSpotList.value ?: listOf())

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            adapter.navController = value
        }

    init {
        repository.getAllRegisterLocation().subscribeBy(
            onSuccess = {
                registerSpotList.postValue(DataBaseConverter().convert2RegisterPointDataList(it))
            }
        )
    }
}
