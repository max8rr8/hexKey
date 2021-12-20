package io.maximmasterr.hexkey

enum class Keyboards(val keyboard: Keyboard) {
    RU(Keyboard("абвгдежзийклмнопрстуфхцчшщъыьэюя")),
    EN(Keyboard("abcdefghijklmnopqrstuvwxyz")),
    NUM(Keyboard("0123456789.,!?():;/\"'-+*=_"))
}