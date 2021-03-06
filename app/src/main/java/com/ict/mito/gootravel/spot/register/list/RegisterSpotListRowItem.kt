package com.ict.mito.gootravel.spot.register.list

import androidx.navigation.NavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterSpotListRowBinding
import com.ict.mito.gootravel.spot.model.RegisterPointData
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by mitohato14 on 2019-10-05.
 */
class RegisterSpotListRowItem(
    private val registerSpotData: RegisterPointData,
    private val navController: NavController,
    private val distance: Long
) : BindableItem<RegisterSpotListRowBinding>() {
    override fun getLayout(): Int = R.layout.register_spot_list_row

    override fun bind(
        viewBinding: RegisterSpotListRowBinding,
        position: Int
    ) {
        viewBinding.also {
            it.registerPoint = registerSpotData
            it.distance = "$distance"
            it.root.setOnClickListener {
                val action =
                    RegisterSpotListFragmentDirections.actionRegisterSpotListFragmentToRadarFragment(
                        registerSpotData.id.toLong(),
                        distance
                    )
                navController.navigate(action)
            }
        }
    }
}
