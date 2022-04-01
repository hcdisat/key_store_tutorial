package com.hcdisat.keystoretutorial

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import javax.crypto.Cipher
import javax.crypto.KeyGenerator

object KeyGeneratorService {

    val keyGenerator = KeyGenerator
        .getInstance(KeyProperties.KEY_ALGORITHM_AES, KEY_ALIAS)

    private val keyGeneratorParameterSpec by lazy {
        KeyGenParameterSpec.Builder(
            KEY_ALIAS, KeyProperties.PURPOSE_DECRYPT or KeyProperties.PURPOSE_ENCRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .build()
    }

    fun initializeKey() {
        keyGenerator.init(keyGeneratorParameterSpec)
    }

    val cipher by lazy {
        Cipher.getInstance(TRANSFORMATION_ALGORITHM)
    }


}

private const val KEY_ALIAS = "AndroidCAT22"
private const val TRANSFORMATION_ALGORITHM = "AES/GCM/NoPadding"