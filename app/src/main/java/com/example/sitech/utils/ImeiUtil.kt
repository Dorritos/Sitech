package com.example.sitech.utils

import android.hardware.usb.UsbDevice.getDeviceId

object ImeiUtil {
    val imei = android.telephony.TelephonyManager.getDeviceId()
}