package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    EditText userName;
    EditText userEmail;
    EditText userPassword;
    EditText userConfirmPassword;
    Button signUp;


    FirebaseAuth auth;
    DatabaseReference reference;
    String userNameText,userEmailText,userPasswordText,userConfirmPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getSupportActionBar().setTitle("Register");

        userName = findViewById(R.id.User_Full_Name);
        userEmail = findViewById(R.id.User_Email);
        userPassword = findViewById(R.id.User_Password);
        userConfirmPassword = findViewById(R.id.User_Confirm_Password);
        signUp = findViewById(R.id.sign_up_button);




        auth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameText = userName.getText().toString();
                userEmailText = userEmail.getText().toString();
                userPasswordText = userPassword.getText().toString();
                userConfirmPasswordText = userConfirmPassword.getText().toString();


                if (TextUtils.isEmpty(userNameText)||TextUtils.isEmpty(userEmailText)|| TextUtils.isEmpty(userPasswordText) ||
                        TextUtils.isEmpty(userConfirmPasswordText)){
                    Toast.makeText(RegisterActivity.this, "enter the whole data correctly", Toast.LENGTH_SHORT).show();
                }else {
                    signUp(userEmailText,userPasswordText);
                }




            }
        });


    }

    private void signUp(String email,String password){

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success");
                    FirebaseUser user = auth.getCurrentUser();

                    String userId = user.getUid();

                    reference  = FirebaseDatabase.getInstance().getReference("Users");


                    reference.child(userId).child("id").setValue(userId);
                    reference.child(userId).child("userName").setValue(userNameText);
                    reference.child(userId).child("userEmail").setValue(userEmailText);
                    reference.child(userId).child("userPassword").setValue(userPasswordText);
                    reference.child(userId).child("Status").setValue("offline");
                    reference.child(userId).child("search").setValue(userNameText.toLowerCase());
                    Toast.makeText(RegisterActivity.this, "Register Sucsseful ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();


                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("TAG", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });


    }



}
