package com.mydemo.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by khangpv
 * FinOs
 */
const val TAG = "PROGRESSBAR_DIALOG"

class LoadingDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressBarDialog.dialog?.setCancelable(false)
        progressBarDialog.dialog?.setCanceledOnTouchOutside(false)

        return inflater.inflate(R.layout.loading_dialog, container)
    }

    companion object {
        val progressBarDialog: LoadingDialog = LoadingDialog()
    }
}

fun showProgressBar(activity: FragmentActivity) {
    val instance = LoadingDialog.progressBarDialog
    if (!instance.isAdded) {
        if (instance.dialog?.isShowing != true)
            instance.show(activity.supportFragmentManager, TAG)
        activity.supportFragmentManager.executePendingTransactions()
    }
}

fun hideProgressBar() {
    val instance = LoadingDialog.progressBarDialog
    if (instance.dialog?.isShowing == true) LoadingDialog.progressBarDialog.dismiss()
}