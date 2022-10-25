package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import com.udacity.shoestore.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
class Shoe : Parcelable, BaseObservable()
{
    @get:Bindable
    var name:String?=null
        set(value)
        {
            field=value
        }
    @get:Bindable
    var company: String? = null
        set(value) {
            field = value
        }
    @get:Bindable
    var description: String? = null
        set(value) {
            field = value
        }
    var size: Double? = 0.0

    fun setSize(value: String?) {
        this.size = if (value.isNullOrEmpty()){
            0.0
        }else {
            value.toDouble()
        }
    }
    @get:Bindable
    var images: List<String> = mutableListOf()
        set(value) {
            field = value
        }
}
