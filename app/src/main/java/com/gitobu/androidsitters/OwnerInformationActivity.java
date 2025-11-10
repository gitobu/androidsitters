package com.gitobu.androidsitters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OwnerInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_owner_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initOwnerActivity();
        initPetActivity();
        initSitterActivity();
        getOwnerValues();
    }
    private void getOwnerValues(){
        Intent intent = getIntent();

        String owner_name = intent.getStringExtra("o_name");
        TextView textViewOwnerName = findViewById(R.id.textViewName);
        textViewOwnerName.setText("Owner Name: " + owner_name);

        String owner_email = intent.getStringExtra("o_email");
        TextView textViewOwnerEmail = findViewById(R.id.textViewEmail);
        textViewOwnerEmail.setText("Owner Email: +" + owner_email);

        String owner_phone_number = intent.getStringExtra("o_phone_number");
        TextView textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewPhoneNumber.setText("Owner Phone #: " + owner_phone_number);
    }
    private void initOwnerActivity(){
        ImageButton owner = findViewById(R.id.imageButtonOwner);
        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerInformationActivity.this, OwnerActivity.class);
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
                Intent intent = new Intent(OwnerInformationActivity.this, PetActivity.class);
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
                Intent intent = new Intent(OwnerInformationActivity.this, SitterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}