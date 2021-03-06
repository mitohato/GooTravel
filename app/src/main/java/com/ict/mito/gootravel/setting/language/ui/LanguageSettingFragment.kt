package com.ict.mito.gootravel.setting.language.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R
import java.util.Collections.list


class LanguageSettingFragment : Fragment() {

    private lateinit var viewmodel: LanguageSettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.language_setting_fragment,
            container,
            false
        )
        val recyclerView = view.findViewById(R.id.recyclerView_language) as RecyclerView

        val languages = listOf(

            Language(getString(R.string.japanese)),
            Language(getString(R.string.english)),
            Language(getString(R.string.traditional_chinese)),
            Language(getString(R.string.simplified_chinese)),
            Language(getString(R.string.korean))
        )
        val adapter = LanguageSettingAdapter(languages)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
}
