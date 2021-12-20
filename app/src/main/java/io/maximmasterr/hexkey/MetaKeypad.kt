package io.maximmasterr.hexkey

import android.view.inputmethod.InputConnection


class MetaKeypad(private val keyboard: Keyboard): Keypad() {
    override fun getKeys(): Array<String> {
        val keys = super.getKeys()
        keys[5] = "⌘"
        for(i in (0..6)){
            val pos = i * 6
            if(pos < keyboard.length) {
                keys[i] = keyboard.getPart(pos, 6)
            }
        }
        return keys
    }

    override fun onKey(key: Int, inputConnection: InputConnection): Keypad {
        if(key == 5) return SpecialLetterKeypad(keyboard, key * 6)

        if(key * 6 > keyboard.length) return this

        return LetterKeypad(keyboard, key * 6)
    }
}