package com.jasjotsingh.firebaseotp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
//    public static final String TAG = "MainActivity";
//    //Instance of Firebase Authentication
//    private FirebaseAuth mAuth;
//    // Write a message to the database
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
//    String phoneNumber;
//    private boolean mVerificationInProgress = false;
//
//    EditText editText;

    Button dataActivityButton;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editText = findViewById(R.id.phoneNumber);
        button = findViewById(R.id.getOtpButton);
        dataActivityButton = findViewById(R.id.dataActivityButton);
        textView = findViewById(R.id.textView);
        dataActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        phoneNumber = editText.getText().toString();
//        //Database
//        final DatabaseReference myRef = database.getReference("Phone Number");
//
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS, this, mCallbacks);
//
//        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//
//                Log.d(TAG, "onVerificationCompleted:" + phoneAuthCredential);
//
//                // [START_EXCLUDE silent]
//                mVerificationInProgress = false;
//                // [END_EXCLUDE]
//
//                signInWithPhoneAuthCredential(phoneAuthCredential);
//            }
//
//            @Override
//            public void onVerificationFailed(@NonNull FirebaseException e) {
//
//                Toast.makeText(MainActivity.this, "Invalid Phone or Quota Exceeded", Toast.LENGTH_SHORT).show();
//            }
//        };
//    }
//    // [START sign_in_with_phone]
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success");
//
//                            FirebaseUser user = task.getResult().getUser();
//
//
//                        } else {
//                            // Sign in failed, display a message and update the UI
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                // The verification code entered was invalid
//                                Toast.makeText(MainActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
//
//                            }
//                            // [START_EXCLUDE silent]
//
//                        }
//                    }
//                });
//    }
//    // [END sign_in_with_ph
}

    @Override
    protected void onStart() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            Intent dashIntent = new Intent(MainActivity.this,DashboardActivity.class);
            startActivity(dashIntent);
        }
        super.onStart();
    }
}
