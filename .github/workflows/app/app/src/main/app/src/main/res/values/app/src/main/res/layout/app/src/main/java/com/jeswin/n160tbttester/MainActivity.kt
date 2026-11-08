package com.jeswin.n160tbttester

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.UUID

class MainActivity : AppCompatActivity() {

    companion object {
        // N160/Bajaj TBT service
        private val BAJAJ_SERVICE_UUID =
            UUID.fromString("0010676e-6972-6565-6e69-676e4543544f")

        // TBT information characteristic ONLY.
        // CONTROL is intentionally not included anywhere in this app.
        private val TBT_INFO_UUID =
            UUID.fromString("00000110-0000-1000-8000-00805f9b34fb")

        private const val SCAN_TIME = 10_000L
    }

    private lateinit var status: TextView
    private lateinit var scanButton: Button
    private lateinit var stopButton: Button
    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var uturnButton: Button
    private lateinit var straightButton: Button
    private lateinit var deviceList: ListView

    private val devices = mutableListOf<B
