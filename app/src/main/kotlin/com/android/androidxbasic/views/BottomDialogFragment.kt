package com.android.androidxbasic.views

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.android.androidxbasic.R
import com.android.androidxbasic.databinding.LayoutBottomDialogBinding

class BottomDialogFragment : DialogFragment() {

    private lateinit var binding: LayoutBottomDialogBinding

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setGravity(Gravity.BOTTOM)
            dialog.window!!.setWindowAnimations(R.style.Animation_Bottom_Rising)
            // 取消弹框默认边距，底色灰色透明
            dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCanceledOnTouchOutside(false)
            // 返回取消关闭弹框
            getDialog()!!.setOnKeyListener { _, keyCode, _ ->
                keyCode == KeyEvent.KEYCODE_BACK
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_bottom_dialog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCancel.setOnClickListener {
            dialog?.dismiss()
        }
    }
}