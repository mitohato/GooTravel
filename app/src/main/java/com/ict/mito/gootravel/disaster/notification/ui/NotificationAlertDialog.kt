package com.ict.mito.gootravel.disaster.notification.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.ict.mito.gootravel.R

class NotificationAlertDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Earthquake")
            .setMessage("massage")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton(getString(R.string.refuge)) { _, _ -> }
            .setNegativeButton(getString(R.string.manual)) { _, _ -> }
        return builder.create()
    }
}
