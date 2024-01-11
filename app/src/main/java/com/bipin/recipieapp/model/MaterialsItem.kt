package com.bipin.recipieapp.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import com.bipin.recipieapp.adapter.AbstractModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MaterialsItem(

    var name: String? = null,
    var quantity: String? = null,
    var img: @RawValue Drawable?

) : AbstractModel(), Parcelable
