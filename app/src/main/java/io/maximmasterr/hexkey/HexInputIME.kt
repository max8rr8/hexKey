package io.maximmasterr.hexkey

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.TextView

class HexInputIME : InputMethodService() {
    private lateinit var  mKeyboardView: View
    private lateinit var currentKeypad: Keypad

    private val buttons = arrayOfNulls<TextView>(6)


    override fun onCreateInputView(): View {
        mKeyboardView = layoutInflater.inflate(R.layout.keyboard, null)

        val ids = arrayOf(R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6)
        for((i, id) in ids.withIndex()) {
            val btn = mKeyboardView.findViewById<TextView>(id)
            buttons[i] = btn
            btn.setOnClickListener {
                keyPressed(i)
            }
        }

        currentKeypad = SelectKeypad()

        render()
        return mKeyboardView
    }

    private fun render() {
        val keys = currentKeypad.getKeys()
        for((key, btn) in keys.zip(buttons)) {
            btn?.text = key
        }
    }

    private fun keyPressed(i: Int) {
        currentKeypad = currentKeypad.onKey(i, currentInputConnection)
        render()
    }

    override fun onEvaluateFullscreenMode(): Boolean {
        return true
    }
}