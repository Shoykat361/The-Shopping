package com.shoykat.theshopping.Repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.google.firebase.firestore.FirebaseFirestore
import com.shoykat.theshopping.Model.UserofEcom
import com.shoykat.theshopping.Utlis.collectionUser

class UserRepository {
    val db = FirebaseFirestore.getInstance()

    fun insertNewUser(ecomUser: UserofEcom) {
        db.collection(collectionUser).document(ecomUser.userId!!)
            .set(ecomUser)
            .addOnSuccessListener {

            }.addOnFailureListener {

            }
    }
    fun getUser(userId: String):LiveData<UserofEcom>{
        val userLD= MutableLiveData<UserofEcom>()
        db.collection(collectionUser)
            .document(userId)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    return@addSnapshotListener
                }

                userLD.value = value!!.toObject(UserofEcom::class.java)

            }
        return userLD

    }
    fun updateUser(ecom: UserofEcom) {
        db.collection(collectionUser).document(ecom.userId!!)
            .set(ecom)

            .addOnSuccessListener {

            }.addOnFailureListener {

            }
    }



    fun updateLastSignInTimeAndOnlineStatus(userId: String, time: Long) {
        db.collection(collectionUser).document(userId)
            .update(mapOf("userLastSignInTimeStamp" to time, "online" to true))
            .addOnSuccessListener {

            }.addOnFailureListener {

            }
    }

    fun updateLastAppExitTimeAndOnlineStatus(time: Long, userId: String, status: Boolean, callback: (() -> Unit)? = null) {
        db.collection(collectionUser).document(userId)
            .update(mapOf("lastUsageTimestamp" to time, "online" to status))
            .addOnSuccessListener {
                callback?.invoke()
            }.addOnFailureListener {

            }
    }

    fun updateOnlineStatus(userId: String, status: Boolean, callback: (() -> Unit)? = null) {
        db.collection(collectionUser).document(userId)
            .update("online", status)
            .addOnSuccessListener {
                callback?.let { it1 -> it1() }
            }.addOnFailureListener {

            }
    }
}