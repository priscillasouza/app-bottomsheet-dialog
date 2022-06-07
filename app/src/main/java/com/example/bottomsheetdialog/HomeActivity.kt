package com.example.bottomsheetdialog

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheetdialog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        simpleDialog()

        binding?.buttonHome?.setOnClickListener {
            val intent = Intent(this, BottomSheetActivity::class.java)
            startActivity(intent)
        }
    }

    private fun simpleDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Tudo sobre tecnologia")
        builder.setMessage("Gostaria de acessar informações sobre tecnologia?")
        builder.setPositiveButton("Sim", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@HomeActivity, "Clicou em Sim", Toast.LENGTH_LONG).show()
            }
        })
        builder.setNegativeButton("Não", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@HomeActivity, "Clicou em Não", Toast.LENGTH_LONG).show()
            }
        })
        builder.setNeutralButton("Cancelar", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@HomeActivity, "Clicou em Cancelar", Toast.LENGTH_LONG).show()
            }
        })
        builder.create().show()
    }
}