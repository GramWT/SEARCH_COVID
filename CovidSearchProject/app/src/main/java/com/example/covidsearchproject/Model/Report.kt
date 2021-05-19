package com.example.covidsearchproject.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Report(
    var date:String?,
    var confirmed:String? ,
    var deaths:String?,
    var recovered:String? ,
    var confirmed_diff:String?,
    var deaths_diff:String?,
    var recovered_diff:String?,
    var last_update:String?,
    var active:String?,
    var active_diff:String?,
    var fatality_rate:String?,
    var region: Region?
):Parcelable


@Parcelize
data class Region(
    var iso:String?,
    var name:String?,
    var province:String?,
    var lat:String?,
    var long:String
):Parcelable