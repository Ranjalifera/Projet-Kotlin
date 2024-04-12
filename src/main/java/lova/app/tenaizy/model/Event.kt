package lova.app.tenaizy.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
