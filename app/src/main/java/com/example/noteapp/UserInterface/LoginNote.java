package com.example.noteapp.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noteapp.FireBasePojo.FirePojo;
import com.example.noteapp.R;

public class LoginNote extends AppCompatActivity {

    ViewModelLogin viewModelLogin;
    EditText EditeSearchId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_note);
        EditeSearchId=findViewById(R.id.log_edt);
        viewModelLogin = ViewModelProviders.of(this).get(ViewModelLogin.class);
    }

    public void log(View view) {

            viewModelLogin.Search(EditeSearchId.getText().toString());
            viewModelLogin.LivePojo.observe(this, new Observer<FirePojo>() {
                @Override
                public void onChanged(FirePojo firePojo) {
                   if (!firePojo.equals(null)) {
                       Toast.makeText(LoginNote.this, firePojo.getDetails(), Toast.LENGTH_SHORT).show();
                       Intent intent=new Intent(LoginNote.this,FinalView.class);
                       intent.putExtra("code",firePojo);
                       startActivity(intent);

                   } else {
                      Toast.makeText(LoginNote.this, "enter a right code", Toast.LENGTH_LONG).show();
                   }
                }
            });
        }

    }

