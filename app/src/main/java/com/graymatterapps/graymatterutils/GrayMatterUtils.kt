package com.graymatterapps.graymatterutils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import com.graymatterapps.dualitylauncher.mainContext

object GrayMatterUtils {
    fun getVersionCode(con: Context): Int {
        try {
            val pm = con.packageManager
            val pkgInfo = pm.getPackageInfo(con.packageName, 0)
            return pkgInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return 0
    }

    fun getVersionName(con: Context): String {
        try {
            val pm = con.packageManager
            val pkgInfo = pm.getPackageInfo(con.packageName, 0)
            return pkgInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return "Unknown"
    }

    fun colorPrefToColor(color: String?): Int {
        when (color) {
            "Black" -> return Color.BLACK
            "White" -> return Color.WHITE
            "Green" -> return Color.GREEN
            "Blue" -> return Color.BLUE
            "Cyan" -> return Color.CYAN
            "Dark Gray" -> return Color.DKGRAY
            "Gray" -> return Color.GRAY
            "Light Gray" -> return Color.LTGRAY
            "Magenta" -> return Color.MAGENTA
            "Red" -> return Color.RED
            "Yellow" -> return Color.YELLOW
            else -> return Color.TRANSPARENT
        }
    }

    fun vibrate(con: Context, millis: Long) {
        val vibe = con.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibe.vibrate(VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    fun showOkCancelDialog(
        con: Context,
        message: String,
        okListener: DialogInterface.OnClickListener,
        cancelListener: DialogInterface.OnClickListener? = null
    ) {
        AlertDialog.Builder(con)
            .setMessage(message)
            .setPositiveButton("Ok", okListener)
            .setNegativeButton("Cancel", cancelListener)
            .create()
            .show()
    }

    fun showOkDialog(
        con: Context,
        message: String,
        okListener: DialogInterface.OnClickListener? = null
    ) {
        AlertDialog.Builder(con)
            .setMessage(message)
            .setPositiveButton("Ok", okListener)
            .create()
            .show()
    }

    fun longToast(con: Context, message: String) {
        Toast.makeText(con, message, Toast.LENGTH_LONG).show()
    }

    fun shortToast(con: Context, message: String) {
        Toast.makeText(con, message, Toast.LENGTH_SHORT).show()
    }
}