package com.ict.mito.gootravel.spot.select.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.list_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        // TODO: Use the ViewModel
        button_to_radar.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_radarFragment)
        }
        button_to_search.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_searchFragment)
        }
        button_to_navigate.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_navigateFragment)
        }
        button_to_register.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_registerFragment)
        }
    }
}
