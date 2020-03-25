package com.example.noteapp.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noteapp.FireBasePojo.FirePojo;
import com.example.noteapp.R;

import java.util.Random;

public class AddNote extends AppCompatActivity implements TextWatcher {

    EditText EditeAdd;
    TextView IDText;
    ViewModelClass ViewModelObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        EditeAdd=findViewById(R.id.did);
        IDText =findViewById(R.id.ttv);
        RandomValue();
        ViewModelObject = ViewModelProviders.of(this).get(ViewModelClass.class);
        if(!EditeAdd.getText().toString().equals("")) {
            ViewModelObject.Select(IDText.getText().toString());
            ViewModelObject.LivePojo.observe(this, new Observer<FirePojo>() {
                @Override
                public void onChanged(FirePojo firePojo) {
                    EditeAdd.setText(firePojo.getDetails());
                }
            });
        }
        EditeAdd.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

            ViewModelObject.NodeRefrence().child(IDText.getText().toString())
                    .setValue(new FirePojo(IDText.getText().toString(), s.toString()));

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void RandomValue()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        IDText.setText( String.format("%06d", number));
    }

}
