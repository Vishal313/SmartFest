package com.comp.smartfest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class complain extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextComplain;
    private Spinner spinnerDept;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        db = FirebaseFirestore.getInstance();

        editTextComplain = findViewById(R.id.complain);
        spinnerDept = findViewById(R.id.spinnerDept);

        findViewById(R.id.compbtn).setOnClickListener(this);
    }

    private boolean validateInputs(String complains) {
        if (complains.isEmpty()) {
            editTextComplain.setError("Complain required");
            editTextComplain.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        String complains = editTextComplain.getText().toString().trim();
        String dept = spinnerDept.getSelectedItem().toString().trim();

        if (!validateInputs(complains)) {

            CollectionReference dbComplains = db.collection("complains");

            Department department = new Department(complains, dept);

            dbComplains.add(department)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(complain.this, "Complain Added", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(complain.this,dashboard.class);
                            startActivity(intent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(complain.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }

    }
}