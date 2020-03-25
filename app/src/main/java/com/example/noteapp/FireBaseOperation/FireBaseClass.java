package com.example.noteapp.FireBaseOperation;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.noteapp.FireBasePojo.FirePojo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FireBaseClass {

    public static FireBaseClass FireObject()
    {
        return new FireBaseClass();
    }

    public DatabaseReference FireBaseBind()
    {
        return FirebaseDatabase.getInstance().getReference("Note");
    }



}
