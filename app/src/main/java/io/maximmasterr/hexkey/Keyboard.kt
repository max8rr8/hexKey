package io.maximmasterr.hexkey

import android.view.inputmethod.InputConnection
import java.lang.Integer.min

class Keyboard(private val pureAlphabet: String) {
    private var shift = false


    val alphabet: String
        get() {
            return if(shift)
                pureAlphabet.uppercase()
            else
                pureAlphabet
        }

    val length: Int
        get(): Int {
            return alphabet.length
        }


    fun getPart(pos: Int, len: Int): String {
        if(pos >= alphabet.length) return ""
        return alphabet.substring(pos, min(pos + len, alphabet.length))
    }

    fun getChar(pos: Int): String {
        return alphabet[pos].toString()
    }

    fun write(inputConnection: InputConnection, char: String) {
        inputConnection.commitText(char, 1)
        shift = false
    }

    fun delete(inputConnection: InputConnection) {
        inputConnection.deleteSurroundingText(1, 0)
        shift = false
    }

    fun shift() {
        shift = !shift
    }



}