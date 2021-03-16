package com.zxdmjr.materialutils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.zxdmjr.material_utils.extensions.*
import com.zxdmjr.material_utils.network.NetworkConnection
import com.zxdmjr.material_utils.store.DataStorePref
import com.zxdmjr.material_utils.store.SharedPref
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
            toast("Navigate to auth",
                position = Gravity.TOP)
            navigateToAuthActivity()
        }

        btnWriteData.setOnClickListener {
            val data = etData.text.toString()

            if(data.isNullOrEmpty()){
                toast("Please enter data")
                return@setOnClickListener
            }
            etData.setText("")
            lifecycleScope.launch {
                dataStorePref.write("pref_latitude", 1.0f)
                dataStorePref.write(DATA_KEY, data)
            }
            toast("Write successfully")

        }

        btnClear.setOnClickListener {
            lifecycleScope.launch {
                dataStorePref.clear()
            }
        }


        dataStorePref.read(DATA_KEY, "").asLiveData().observe(this, Observer { data->
            if(data.isNullOrEmpty()){
                return@Observer
            }
            Log.d("MainActivity", "DATA_KEY: $data")
            tvReadData.text = data
        })

        btnReadData.setOnClickListener {
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

        netConnection = NetworkConnection(applicationContext)
        netConnection?.observe(this, Observer { hasConnected ->
            if(hasConnected){
                toast("connected")
            } else {
                toast("disconnected")
            }
        })

    }

    private var netConnection: NetworkConnection? = null

    private fun navigateToAuthActivity(){
        startAndFinish(Intent(this, AuthActivity::class.java))
    }
}
