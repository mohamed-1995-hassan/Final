package com.example.noteapp.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.noteapp.FireBasePojo.FirePojo;
import com.example.noteapp.R;

public class FinalView extends AppCompatActivity implements TextWatcher {
EditText EditView;
ViewModelClass ViewModelObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_view);
        FirePojo firePojo= getIntent().getParcelableExtra("code");
        EditView=findViewById(R.id.d_fin);
        EditView.setText(firePojo.getDetails());
        ViewModelObject = ViewModelProviders.of(this).get(ViewModelClass.class);
        ViewModelObject.FinalView(firePojo.getId());
        ViewModelObject.LivePojo.observe(this, new Observer<FirePojo>() {
            @Override
            public void onChanged(FirePojo firePojo) {
                EditView.setText(firePojo.getDetails());
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        ViewModelObject.NodeRefrence().child(EditView.getText().toString())
                .setValue(new FirePojo(EditView.getText().toString(), s.toString()));
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
