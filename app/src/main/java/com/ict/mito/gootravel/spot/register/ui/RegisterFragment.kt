package com.ict.mito.gootravel.spot.register.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterFragmentBinding
import kotlinx.android.synthetic.main.register_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException

class RegisterFragment : Fragment() {

    private val viewmodel: RegisterViewModel by viewModel()
    private var binding: RegisterFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.register_fragment,
            container,
            false
        )

        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        set_image_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, READ_REQUEST_CODE)
        }
    }

    val READ_REQUEST_CODE = 42

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        resultData: Intent?
    ) {
        if (
            requestCode == READ_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK
        ) {
            val uri: Uri?
            if (resultData != null) {
                uri = resultData.getData()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        context?.contentResolver,
                        uri
                    )
                    set_image_preview.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
