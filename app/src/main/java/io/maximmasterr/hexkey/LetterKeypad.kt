package io.maximmasterr.hexkey

import android.view.inputmethod.InputConnection

open class LetterKeypad(private val keyboard: Keyboard, private val pos: Int): Keypad() {
    override fun getKeys(): Array<String> {
        val keys = super.getKeys();
        for((i, letter) in keyboard.getPart(pos, 6).withIndex()) {
            keys[i] = letter.toString()
        }
        return keys
    }

    override fun onKey(key: Int, inputConnection: InputConnection): Keypad {
        if(pos + key < keyboard.length)
            keyboard.write(inputConnection, keyboard.getChar(pos + key))

        return MetaKeypad(keyboard)
    }
}