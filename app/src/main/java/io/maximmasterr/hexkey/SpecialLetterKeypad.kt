package io.maximmasterr.hexkey

import android.view.inputmethod.InputConnection

class SpecialLetterKeypad(private val keyboard: Keyboard, pos: Int): LetterKeypad(keyboard, pos) {
    override fun getKeys(): Array<String> {
        val keys =  super.getKeys()

        keys[5] = "⌫"
        keys[4] = "⇧"
        keys[3] = "␣"
        keys[2] = "⌘"

        return keys
    }

    override fun onKey(key: Int, inputConnection: InputConnection): Keypad {
        if(key == 5) {
            keyboard.delete(inputConnection)
            return MetaKeypad(keyboard)
        }

        if(key == 4) {
            keyboard.shift()
            return MetaKeypad(keyboard)
        }

        if(key == 3) {
            keyboard.write(inputConnection, " ")
            return MetaKeypad(keyboard)
        }

        if(key == 2) {
            return SelectKeypad()
        }


        return super.onKey(key, inputConnection)
    }
}
