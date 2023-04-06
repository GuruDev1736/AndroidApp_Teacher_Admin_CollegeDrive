package com.guruprasad.teacherattend;

import static com.guruprasad.teacherattend.Constants.error_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Objects;

public class student_profile extends AppCompatActivity {
    TextView name , department , email ,password , phone ,year , div ;
    FloatingActionButton call ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Student Profile");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.t_name);
        department = findViewById(R.id.t_department);
        email = findViewById(R.id.t_email);
        password = findViewById(R.id.t_password);
        phone = findViewById(R.id.t_phone);
        year = findViewById(R.id.t_year);
        div = findViewById(R.id.t_div);
        call = findViewById(R.id.call);

        Intent intent = getIntent();
        String t_name  = intent.getStringExtra("name");
        String t_department  = intent.getStringExtra("department");
        String t_year  = intent.getStringExtra("year");
        String t_phone  = intent.getStringExtra("stud_no");
        String t_email  = intent.getStringExtra("email");
        String t_password  = intent.getStringExtra("parent_no");
        String t_div  = intent.getStringExtra("div");

        name.setText(t_name);
        department.setText(t_department);
        email.setText(t_email);
        password.setText(t_password);
        phone.setText(t_phone);
        year.setText(t_year);
        div.setText(t_div);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withContext(view.getContext())
                        .withPermission(Manifest.permission.CALL_PHONE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                    Intent intent1 = new Intent(Intent.ACTION_CALL);
                                    intent1.setData(Uri.parse("tel:"+t_phone));
                                    startActivity(intent1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                                error_toast(getApplicationContext(),"Permission Needed");
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

    }
}