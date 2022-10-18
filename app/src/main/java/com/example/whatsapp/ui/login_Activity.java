package com.example.whatsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.whatsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login_Activity extends AppCompatActivity {

    ImageView loginImage;
    EditText phoneNumber,code;
    Button sendCodeBtn,verifyBtn;
    FirebaseAuth auth;
    String verificationID;
    ProgressBar bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        sendCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPhoneNumber();
            }
        });
        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(code.getText().toString())) {
                    Toast.makeText(login_Activity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                else
                    verifyCode(code.getText().toString());
            }
        });

    }



    public void initUI() {
        loginImage=findViewById(R.id.login_image);
        phoneNumber=findViewById(R.id.phone_number);
        code=findViewById(R.id.code);
        sendCodeBtn=findViewById(R.id.send_code_btn);
        verifyBtn = findViewById(R.id.verify_btn);
        auth = FirebaseAuth.getInstance();
        bar=findViewById(R.id.progress_bar);
    }

    private void checkPhoneNumber(){
        if(TextUtils.isEmpty(phoneNumber.getText().toString())){
            Toast.makeText(this, "Enter Phone Number ", Toast.LENGTH_SHORT).show();
            // Intent intent=new Intent(this, MainActivity.class);
            //startActivity(intent);
            // finish();

        }
        else
        {
            String number =  phoneNumber.getText().toString();
            bar.setVisibility(View.VISIBLE);
            sendVerificationCode(number);
        }
    }


    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(Callbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            Callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        //did that if verification is completed
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
            final String code=credential.getSmsCode();
            if (code!=null)
            {
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(login_Activity.this, "verification Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                               @NonNull PhoneAuthProvider.ForceResendingToken token)
        {
            super.onCodeSent(s,token);
            verificationID=s;
            Toast.makeText(login_Activity.this, "code sent", Toast.LENGTH_SHORT).show();
            verifyBtn.setEnabled(true);
            bar.setVisibility(View.INVISIBLE);
        }
    };

    private void verifyCode(String Code)
    {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationID,Code);
        signinbyCredentials(credential);
    }

    private void signinbyCredentials(PhoneAuthCredential credential)
    {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(login_Activity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login_Activity.this, MainActivity.class));
                        }
                    }
                });

    }



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null)
        {
            startActivity(new Intent(login_Activity.this,MainActivity.class));
            finish();
        }
    }
}
