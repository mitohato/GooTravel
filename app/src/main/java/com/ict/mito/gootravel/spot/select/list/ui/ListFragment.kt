package com.ict.mito.gootravel.spot.select.list.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.ListFragmentBinding
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.setting.activity.SettingActivity
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()
    private var binding: ListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.list_bottomappbar_menu)
            it.setOnMenuItemClickListener { menu ->
                when (menu.itemId) {
                    R.id.appbar_radar -> {
                        findNavController().navigate(R.id.action_listFragment_to_radarFragment)
                    }
                    R.id.appbar_search -> {
                        findNavController().navigate(R.id.action_listFragment_to_searchFragment)
                    }
                    R.id.app_bar_manual -> {
                        startActivity(
                            Intent(
                                context,
                                ManualActivity::class.java
                            )
                        )
                    }
                    R.id.app_bar_language -> {
                        startActivity(
                            Intent(
                                context,
                                SettingActivity::class.java
                            )
                        )
                    }
                    R.id.app_bar_register -> {
                        findNavController().navigate(
                            R.id.action_listFragment_to_registerSpotListFragment
                        )
                    }
                }
                true
            }
        }

//        val view = inflater.inflate(
//            R.layout.list_fragment,
//            container,
//            false
//        )

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_fragment,
            container,
            false
        )

        // val listFragmentBinding = DataBindingUtil.setContentView<ListFragmentBinding>(, R.layout.list_fragment)

        // val recyclerView: RecyclerView = view.findViewById(R.id.spot_list_view)
        val recyclerView
        val adapter = ListViewAdapter(createDataList())

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        return view
    }

    private fun createDataList(): List<ListRowItem> {

        val dataList = mutableListOf<ListRowItem>()
        for (i in 0..49) {
            val data: ListRowItem = ListRowItem("${i}番目の場所", "${i}m", "")
            dataList.add(data)
        }
        return dataList
    }

    override fun onResume() {
        super.onResume()
        activity?.bottom_appbar?.replaceMenu(R.menu.list_bottomappbar_menu)

        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.supportActionBar?.let {
            it.title = getString(R.string.wifi_spot)
            it.setDisplayHomeAsUpEnabled(false)
            it.setHomeButtonEnabled(false)
        }
    }
}
