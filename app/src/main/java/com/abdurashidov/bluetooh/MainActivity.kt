package com.abdurashidov.bluetooh

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.IntentFilter
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.abdurashidov.bluetooh.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){
    lateinit var bluetoothReceiver: BluetoothReceiver
    lateinit var binding: ActivityMainBinding
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bluetoothReceiver = BluetoothReceiver()
        val intentFilter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(bluetoothReceiver, intentFilter)

        val bAdapter=BluetoothAdapter.getDefaultAdapter()

        binding.switch1.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            @SuppressLint("MissingPermission")
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked){
                    bAdapter.enable()
                }else{
                    bAdapter.disable()
                }
            }
        })

    }
}