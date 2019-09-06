package objects

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

object Util {

    fun isDeviceConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

    fun showMessage(context: Context, msg: String?) {

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}