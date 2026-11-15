package com.ansolm.kotlinsymbolprocessor

import com.google.devtools.ksp.symbol.KSName

/**
 * @author ansolm
 * @since 2024/8/19
 * @desc this is KSPPackage
 */
val KSName.asKspPackage: KSPPackage
    get() {
        return KSPPackage(this)
    }

class KSPPackage(@Transient val ksp: KSName) {
    val name by lazy { ksp.asString() }
}