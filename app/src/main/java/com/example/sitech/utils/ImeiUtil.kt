package com.example.sitech.utils

import androidx.core.telephony.TelephonyManagerCompat.getImei


object ImeiUtil {
    val imei = android.telephony.TelephonyManager.EXTRA_SUBSCRIPTION_ID
}