package com.user.fadhlanhadaina.moviecataloguesubmission.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val GLOBAL_RESOURCE = "GLOBAL"
    private val idlingRes = CountingIdlingResource(GLOBAL_RESOURCE)

    fun increment() {
        idlingRes.increment()
    }

    fun decrement() {
        idlingRes.decrement()
    }

    fun getIdlingResource(): IdlingResource {
        return idlingRes
    }
}