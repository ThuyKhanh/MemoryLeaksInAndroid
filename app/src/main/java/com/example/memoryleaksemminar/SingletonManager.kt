package com.example.memoryleaksemminar

import android.content.Context
import com.example.memoryleaksemminar.SingletonManager
import kotlin.jvm.Synchronized

/**
 * Project: MemoryLeakSemminar
 * Created by ThuyHV5 on 8/16/2022.
 * Used to
 */
class SingletonManager private constructor(private var context: Context) {
    companion object {
        private var singleton: SingletonManager? = null
        @Synchronized
        fun getInstance(context: Context): SingletonManager? {
            if (singleton == null) {
                singleton = SingletonManager(context.applicationContext)
            }
            return singleton
        }
    }
}