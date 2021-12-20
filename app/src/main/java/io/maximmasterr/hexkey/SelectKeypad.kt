package io.maximmasterr.hexkey

import android.view.inputmethod.InputConnection


class SelectKeypad: Keypad() {
    override fun getKeys(): Array<String> {
        val keys = super.getKeys()
        for((i, keyboard) in Keyboards.values().withIndex()) {
            keys[i] = keyboard.name
        }
        return keys
    }

    override fun onKey(key: Int, inputConnection: InputConnection): Keypad {
        return MetaKeypad(Keyboards.values()[key].keyboard)
    }
}