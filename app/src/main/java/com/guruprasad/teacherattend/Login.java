package com.guruprasad.teacherattend;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.success_toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.guruprasad.teacherattend.dashboard.MainDashBoard;

public class Login extends AppCompatActivity {
        EditText email , password ;
        Button login ;
        FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.teacher_login_email);
        password = findViewById(R.id.teacher_login_password);
        login = findViewById(R.id.teacher_login_btn);
        auth = FirebaseAuth.getInstance();

        FirebaseUser user = auth.getCurrentUser();
        if (user!=null)
        {
            startActivity(new Intent(getApplicationContext(), MainDashBoard.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ProgressDialog pd = new ProgressDialog(Login.this);
                pd.setTitle("Logging In");
                pd.setMessage("Please Wait....");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);


                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(mail))
                {
                    email.setError("Email is Invalid");
                    return;
                }
                if (TextUtils.isEmpty(pass))
                {
                    password.setError("Password Invalid");
                    return;
                }
                pd.show();
                auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            success_toast(getApplicationContext(),"Login Successful");
                            startActivity(new Intent(getApplicationContext(),MainDashBoard.class));
                            finish();
                            pd.dismiss();
                        }
                        else
                        {
                            error_toast(getApplicationContext(),"Login Failed : "+task.getException());
                            pd.dismiss();
                        }
                    }
                });




            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}