package com.shoykat.theshopping.Model

data class User(
    var userId :String?=null,
    val userName: String = "",
    val userImage:String = "",
    val userUid:String = "",
    val userEmail:String = "",
    val userAddress:String = "",
    val userPhone: String = "",
    var emailAddress:String?=null,
    var userCreationTimeStamp:Long?=null,
    var userLastSignInTimeStamp:Long?=null,
    var phone:String?=null,
    var address:String?=null,
    var image:String?=null,
    var lastUsesTimestamp:Long?=null,
    var online: Boolean = false,
)