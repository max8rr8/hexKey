package io.maximmasterr.hexkey

import android.util.Log
import android.view.inputmethod.InputConnection

open class Keypad {

    open fun getKeys(): Array<String> {
        return arrayOf("NO KEY", "NO KEY", "NO KEY", "NO KEY", "NO KEY", "NO KEY")
    }

    open fun onKey(key: Int, inputConnection: InputConnection): Keypad {

        Log.d("Keypad", "NOT META KEYPAD")

        Log.d("Keypad", "Key pressed: $key")

        return Keypad()
    }
}