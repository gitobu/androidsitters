package com.gitobu.androidsitters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OwnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_owner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initPlaceHolderText();
        initSaveButton();
        initOwnerActivity();
        initPetActivity();
        initSitterActivity();
    }
    private void initPlaceHolderText(){
        EditText firstName = findViewById(R.id.editTextName);
        firstName.setHint("Enter your name");
        EditText phoneNumber = findViewById(R.id.editTextPhoneNumber);
        phoneNumber.setHint("Phone number");
        EditText emailAddress = findViewById(R.id.editTextEmail);
        emailAddress.setHint("Enter your best email address");
    }

    private void initSaveButton(){
        Button btnSave = findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(OwnerActivity.this, OwnerInformationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                EditText editTextName = findViewById(R.id.editTextName);
                String owner_name = editTextName.getText().toString();
                intent.putExtra("o_name", owner_name);
                EditText editTextEmail = findViewById(R.id.editTextEmail);
                String owner_email = editTextName.getText().toString();
                intent.putExtra("o_email", owner_email);
                EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
                String owner_phone_number = editTextName.getText().toString();
                intent.putExtra("o_phone_number", owner_phone_number);
            startActivity(intent);
            }
        });
    }
    private void initOwnerActivity(){
        ImageButton owner = findViewById(R.id.imageButtonOwner);
        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerActivity.this, OwnerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initPetActivity(){
        ImageButton owner = findViewById(R.id.imageButtonOwner);
        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerActivity.this, PetActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initSitterActivity(){
        ImageButton owner = findViewById(R.id.imageButtonOwner);
        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerActivity.this, SitterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}