package com.example.jetchatappcompose.data.database

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.jetchatappcompose.data.model.AppUser
import com.example.jetchatappcompose.data.model.Room
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot

fun getUserCollection() : CollectionReference{
    val db = Firebase.firestore
    return  db.collection(AppUser.COLLECTION_NAME)
}

fun getRoomCollection() : CollectionReference{
    val db = Firebase.firestore
    return  db.collection(Room.COLLECTION_NAME)
}

fun addUserToFireStoreDB(
    appUser: AppUser,
    onSuccessListener: OnSuccessListener<Void>,
    onFailureListener: OnFailureListener
) {
    getUserCollection().document(appUser.id!!)
        .set(appUser)
        .addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)
}

fun getUserFromFireStoreDB(
    uid: String,
    onSuccessListener: OnSuccessListener<DocumentSnapshot>,
    onFailureListener: OnFailureListener
) {
    getUserCollection().document(uid)
        .get()
        .addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)

}


fun addRoomToFireStore(room : Room , onCompleteListener: OnCompleteListener<Void>){
  getRoomCollection().document().set(room)
      .addOnCompleteListener(onCompleteListener)
}

fun getRoomFromFireStore(onCompleteListener: OnCompleteListener<QuerySnapshot>){
    getRoomCollection().get().addOnCompleteListener(onCompleteListener)
}