package com.reza.pulsa.application.base.exception

class ApiErrorException(override val message: String? = null, val httpCode: Int? = null) :
    Exception() {
}