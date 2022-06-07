package com.example.bottomsheetdialog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheetdialog.databinding.ActivityBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetActivity : AppCompatActivity() {

    var binding: ActivityBottomSheetBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val bottomSheet = binding?.icludeBottomSheet?.root

        binding?.buttonBottomSheetModal?.setOnClickListener {
            val bottomSheetBehaviour = BottomSheetBehavior.from(bottomSheet!!)
            if (bottomSheetBehaviour.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                bottomSheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        customDialog()
    }

    private fun customDialog() {
        val view: View = layoutInflater.inflate(R.layout.custom_dialog_modal, null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setView(view)

        val alert = builder.create()

        view.findViewById<Button>(R.id.buttonOk).setOnClickListener {
            alert.dismiss()
        }
        view.findViewById<Button>(R.id.buttonCancel).setOnClickListener {
            Intent(this, HomeActivity::class.java)
        }
        alert.show()
    }


}