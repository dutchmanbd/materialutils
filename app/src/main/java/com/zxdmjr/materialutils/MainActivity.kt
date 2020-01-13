package com.zxdmjr.materialutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.zxdmjr.material_utils.SharedPref
import com.zxdmjr.material_utils.hide
import com.zxdmjr.material_utils.show
import com.zxdmjr.material_utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sharedPref by lazy {
        SharedPref(applicationContext)
    }

    companion object{
        private const val DATA_KEY = "data_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            toast("Hello Toast", position = Gravity.TOP)
        }

        btnWriteData.setOnClickListener {
            val data = etData.text.toString()

            if(data.isNullOrEmpty()){
                toast("Please enter data")
                return@setOnClickListener
            }
            etData.setText("")
            sharedPref.write(DATA_KEY, data)
            toast("Write successfully")

        }

        btnReadData.setOnClickListener {
            val data = sharedPref.read(DATA_KEY, "")

            if(data.isNullOrEmpty()){
                toast("No available data", position = Gravity.TOP)
                return@setOnClickListener
            }
            tvReadData.text = data
        }

        btnHideAll.setOnClickListener {
            btnShowToast.hide()
            btnWriteData.hide()
            etData.hide()
            btnReadData.hide()
            tvReadData.hide()
        }

        btnShowAll.setOnClickListener {
            btnShowToast.show()
            btnWriteData.show()
            etData.show()
            btnReadData.show()
            tvReadData.show()
        }

    }
}
