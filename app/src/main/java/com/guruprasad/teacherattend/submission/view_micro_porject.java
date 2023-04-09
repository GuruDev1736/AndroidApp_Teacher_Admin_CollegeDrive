package com.guruprasad.teacherattend.submission;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.success_toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.view_micro_project_model;

import org.w3c.dom.Text;

import java.security.ProtectionDomain;
import java.util.Objects;

public class view_micro_porject extends AppCompatActivity {

    TextView name , department , year , division  ;
    EditText micro_name , micro_marks ;
    TextView status ;
    Button submit ;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Submission");

    FloatingActionButton button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_micro_porject);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Micro-Project Submission ");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.name_student);
        department = findViewById(R.id.department_student);
        year = findViewById(R.id.year_student);
        division = findViewById(R.id.division_student);
        micro_marks = findViewById(R.id.micro_project_marks);
        micro_name = findViewById(R.id.micro_project_name);
        status = findViewById(R.id.status);
        submit = findViewById(R.id.submit_micro_project);
        button = findViewById(R.id.message_micro_project);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Retriving Data");
        progressDialog.setMessage("Please Wait ....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        Intent intent = getIntent();
        String Year = intent.getStringExtra("year");
        String div = intent.getStringExtra("div");
        String depart = intent.getStringExtra("depart");
        String stud_name = intent.getStringExtra("name");
        String sub = intent.getStringExtra("sub");
        String student_no = intent.getStringExtra("stud_no");

        name.setText(stud_name);
        department.setText(depart);
        year.setText(Year);
        division.setText(div);

        reference.child("Micro_Project").child(depart).child(Year).child(div).child(sub).child(stud_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                view_micro_project_model model = snapshot.getValue(view_micro_project_model.class);

                if(model != null )
                {
                    micro_name.setText(model.getMicro_project_name());
                    micro_marks.setText(model.getMicro_project_marks());
                    status.setText(model.getStatus());

                }

                if (model != null && model.getStatus().equals("Completed"))
                {
                    button.setVisibility(View.GONE);
                }

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss();
                error_toast(getApplicationContext(),"Error: "+error.getMessage());
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setTitle("Submission");
                pd.setMessage("Please Wait Submitting Data .....");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);

                String name = micro_name.getText().toString();
                String marks = micro_marks.getText().toString();

                if (TextUtils.isEmpty(name))
                {
                    micro_name.setError("Name Required");
                    return;
                }
                if (TextUtils.isEmpty(marks))
                {
                    micro_marks.setError("Marks Required");
                    return;
                }

                pd.show();

                view_micro_project_model model = new view_micro_project_model(name,marks,"Completed");
                reference.child("Micro_Project").child(depart).child(Year).child(div).child(sub).child(stud_name)
                        .setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                pd.dismiss();
                                success_toast(getApplicationContext(),"Data Submitted Successfully");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(getApplicationContext(),"Error : "+e.getMessage());
                            }
                        });



            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Micro-Project submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");

            }
        });






    }
}