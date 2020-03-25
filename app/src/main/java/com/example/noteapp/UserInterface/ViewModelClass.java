package com.example.noteapp.UserInterface;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.noteapp.FireBaseOperation.FireBaseClass;
import com.example.noteapp.FireBasePojo.FirePojo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ViewModelClass extends ViewModel implements ValueEventListener {

    MutableLiveData<FirePojo>LivePojo=new MutableLiveData<>();

    public DatabaseReference NodeRefrence()
    {
        return FireBaseClass.FireObject().FireBaseBind();
    }

    public void Select(String ViewId)
    {
        NodeRefrence().child(ViewId).addListenerForSingleValueEvent(this);
    }

    public void FinalView(String ViewId)
    {
        NodeRefrence().child(ViewId).addValueEventListener(this);
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        FirePojo firePojo = dataSnapshot.getValue(FirePojo.class);
        LivePojo.setValue(firePojo);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
