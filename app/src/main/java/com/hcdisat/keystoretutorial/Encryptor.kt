package com.hcdisat.keystoretutorial

import javax.crypto.Cipher

class Encryptor {

    private val secretKey by lazy {
        KeyGeneratorService.keyGenerator.generateKey()
    }

    // Initialization Vector is a fixed-size input to a cryptographic primitive.
    // It is typically required to be random or pseudorandom.
    // The point of an IV is to tolerate the use of the same key to encrypt several distinct messages.

    private val iv by lazy {
        KeyGeneratorService.cipher.iv
    }

    val encryption = KeyGeneratorService.cipher.doFinal()

    fun initializeEncryptionCipher() {
        KeyGeneratorService.cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    }


}