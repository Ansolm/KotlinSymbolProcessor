package com.ansolm.kotlinsymbolprocessor

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ksp.toClassName

/**
 * @author ansolm
 * @since 2024/8/21
 * @desc this is PoetClass
 */

fun KSPClass.asTypeName(): ClassName = ksp.toClassName()
