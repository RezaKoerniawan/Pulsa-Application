package com.reza.pulsa.application.base.arc

abstract class BaseMapper<in T, out R> {
    abstract fun map(value: T): R
}