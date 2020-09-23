package com.zxdmjr.materialutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.zxdmjr.material_utils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val sharedPref by lazy {
        SharedPref(applicationContext)
    }

    private val dataStorePref by lazy {
        DataStorePref(applicationContext)
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
//            sharedPref.write(DATA_KEY, data)
            lifecycleScope.launch {
                dataStorePref.write(DATA_KEY, data)
            }
            toast("Write successfully")

        }

        dataStorePref.read(DATA_KEY, "").asLiveData().observe(this, Observer { data->
            if(data.isNullOrEmpty()){
                //toast("No available data", position = Gravity.TOP)
                return@Observer
            }
            tvReadData.text = data
        })

        btnReadData.setOnClickListener {
//            val data = sharedPref.read(DATA_KEY, "")
            dataStorePref.read(DATA_KEY, "").asLiveData().observe(this, Observer { data->
                if(data.isNullOrEmpty()){
                    toast("No available data", position = Gravity.TOP)
                    return@Observer
                }
                tvReadData.text = data
            })


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
