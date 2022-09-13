package com.example.memoryleaksemminar.mvvm_leak

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Project: MemoryLeakSemminar
 * Created by ThuyHV5 on 9/8/2022.
 * Used to
 */
class Repository {
    suspend fun performRequest(url:String,callback: ((String)->Unit)?)
    = withContext(Dispatchers.IO){
        try {
            var input: InputStream? = null
            var output: OutputStream? = null
            var connection: HttpURLConnection? = null
            try {
                val url = URL(url)
                connection = url.openConnection() as HttpURLConnection
                connection.connect()
                if (connection.responseCode !== HttpURLConnection.HTTP_OK) {
                    callback?.invoke("Server returned HTTP " + connection.getResponseCode()
                        .toString() + " " + connection.getResponseMessage())
                }
                // download the file
                input = connection.getInputStream()
                output = FileOutputStream("/sdcard/file_name.extension")
                val data = ByteArray(4096)
                var total: Long = 0
                var count: Int
                while ((input.read(data).also { count = it } != -1) && isActive) {
                    total += count.toLong()
                    Log.d("THUY_DEBUG","download $total")
                    output.write(data, 0, count)
                }
            } catch (e: java.lang.Exception) {
                callback?.invoke(e.message ?: "null")
            } finally {
                try {
                    output?.close()
                    input?.close()
                } catch (ignored: IOException) {
                }
                connection?.disconnect()
            }
            callback?.invoke("DONE")
        }catch (e: Exception){
            Log.d("THUY_DEBUG","CancellationException")
        }
    }
}