package com.reza.pulsa.application.base.arc

import com.reza.pulsa.application.base.wrapper.ViewResource


interface BaseContract {
    interface BaseView {
        fun observeData()
        fun showContent(isContentVisible: Boolean)
        fun showEmptyData(isEmpty: Boolean)
        fun showLoading(isShowLoading: Boolean)
        fun showError(isErrorEnabled: Boolean, exception: Exception? = null)
        fun <T : ViewResource<*>> handleData(viewResource: T)
        fun <T> showData(data: T)
    }

    interface BaseRepository {
        fun logResponse(msg: String?)
    }
}