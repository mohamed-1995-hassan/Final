package com.example.noteapp.UserInterface;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.noteapp.FireBaseOperation.FireBaseClass;
import com.example.noteapp.FireBasePojo.FirePojo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ViewModelLogin extends ViewModel implements ValueEventListener {
    String CodeLogin;
    MutableLiveData<FirePojo> LivePojo=new MutableLiveData<>();

    public void Search(String CodeLogin)
    {
        this.CodeLogin=CodeLogin;

        NodeRefrence().addListenerForSingleValueEvent(this);
    }
    public DatabaseReference NodeRefrence()
    {
        return FireBaseClass.FireObject().FireBaseBind();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        SearchList(dataSnapshot);
    }

    private void SearchList(DataSnapshot dataSnapshot) {

        for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

            if (childDataSnapshot.getValue(FirePojo.class).getId().equals(CodeLogin))
            {
                LivePojo.setValue(childDataSnapshot.getValue(FirePojo.class));
                break;
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
