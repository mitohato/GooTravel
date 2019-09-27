package com.ict.mito.gootravel.setting.language.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.gootravel.R
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import android.app.Activity
import androidx.databinding.DataBindingUtil.setContentView


class LanguageSettingFragment : Fragment() {

    private lateinit var viewModel: LanguageSettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            com.ict.mito.gootravel.R.layout.language_setting_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LanguageSettingViewModel::class.java)
        // TODO: Use the ViewModel
        class LanguageSettingFragment : Fragment() {
            public override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

                setContentView(com.ict.mito.gootravel.R.layout.language_setting_fragment)
            }

            private fun setContentView(languageSettingFragment: Int) {


            }
        }
    }
}