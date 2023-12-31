package com.guruprasad.teacherattend.submission;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.success_toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.collection.LLRBNode;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.student_model;
import com.guruprasad.teacherattend.model.view_workbook_model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class view_workbook extends AppCompatActivity {

    TextView name , department , year , division  ;
    ImageButton done_1 , done_2 , done_3 , done_4 , done_5 , done_6 ;
    ImageButton message_1 , message_2 ,message_3 ,message_4 ,message_5 , message_6 ;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Submission");

    TextView workbook_1_status , workbook_2_status , workbook_3_status ,workbook_4_status , workbook_5_status, workbook_6_status ;
    EditText marks_1_status , marks_2_status , marks_3_status ,marks_4_status ,marks_5_status ,marks_6_status  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workbook);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Workbook Submission");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.name_student);
        department = findViewById(R.id.department_student);
        year = findViewById(R.id.year_student);
        division = findViewById(R.id.division_student);
        done_1 = findViewById(R.id.done_1);
        done_2 = findViewById(R.id.done_2);
        done_3 = findViewById(R.id.done_3);
        done_4 = findViewById(R.id.done_4);
        done_5 = findViewById(R.id.done_5);
        done_6 = findViewById(R.id.done_6);
        workbook_1_status = findViewById(R.id.status_workbook_1);
        workbook_2_status = findViewById(R.id.status_workbook_2);
        workbook_3_status = findViewById(R.id.status_workbook_3);
        workbook_4_status = findViewById(R.id.status_workbook_4);
        workbook_5_status = findViewById(R.id.status_workbook_5);
        workbook_6_status = findViewById(R.id.status_workbook_6);
        marks_1_status = findViewById(R.id.marks_wb_1);
        marks_2_status = findViewById(R.id.marks_wb_2);
        marks_3_status = findViewById(R.id.marks_wb_3);
        marks_4_status = findViewById(R.id.marks_wb_4);
        marks_5_status = findViewById(R.id.marks_wb_5);
        marks_6_status = findViewById(R.id.marks_wb_6);

        message_1 = findViewById(R.id.message_1);
        message_2 = findViewById(R.id.message_2);
        message_3 = findViewById(R.id.message_3);
        message_4 = findViewById(R.id.message_4);
        message_5 = findViewById(R.id.message_5);
        message_6 = findViewById(R.id.message_6);




        Intent intent = getIntent();
        String Year = intent.getStringExtra("year");
        String div = intent.getStringExtra("div");
        String depart = intent.getStringExtra("depart");
        String stud_name = intent.getStringExtra("name");
        String sub = intent.getStringExtra("sub");
        String student_no = intent.getStringExtra("stud_no");
        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.green));


        name.setText(stud_name);
        department.setText(depart);
        year.setText(Year);
        division.setText(div);

        String submit = "Completed" ;

        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Submission");
        pd.setMessage("Please Wait Submitting Data .....");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);


        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Retriving Data");
        progressDialog.setMessage("Please Wait ....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.show();



        reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                view_workbook_model model = snapshot.getValue(view_workbook_model.class);

               if(model != null)
               {

                   workbook_1_status.setText(model.getWorkbook_1());
                   workbook_2_status.setText(model.getWorkbook_2());
                   workbook_3_status.setText(model.getWorkbook_3());
                   workbook_4_status.setText(model.getWorkbook_4());
                   workbook_5_status.setText(model.getWorkbook_5());
                   workbook_6_status.setText(model.getWorkbook_6());
                   marks_1_status.setText(model.getMarks_1());
                   marks_2_status.setText(model.getMarks_2());
                   marks_3_status.setText(model.getMarks_3());
                   marks_4_status.setText(model.getMarks_4());
                   marks_5_status.setText(model.getMarks_5());
                   marks_6_status.setText(model.getMarks_6());

                   if (model.getWorkbook_1()!=null && model.getWorkbook_1().equals("Completed"))
                   {
                       done_1.setBackgroundTintList(colorStateList);
                       done_1.setImageResource(R.drawable.baseline_done_24);
                       message_1.setVisibility(View.GONE);
                   }
                   else
                   {
                       workbook_1_status.setText("Incomplete");
                   }

                   if (model.getWorkbook_2()!=null && model.getWorkbook_2().equals("Completed"))
                   {
                       done_2.setBackgroundTintList(colorStateList);
                       done_2.setImageResource(R.drawable.baseline_done_24);
                       message_2.setVisibility(View.GONE);

                   }
                   else
                   {
                       workbook_2_status.setText("Incomplete");
                   }
                   if (model.getWorkbook_3()!=null && model.getWorkbook_3().equals("Completed"))
                   {
                       done_3.setBackgroundTintList(colorStateList);
                       done_3.setImageResource(R.drawable.baseline_done_24);
                       message_3.setVisibility(View.GONE);

                   }
                   else
                   {
                       workbook_3_status.setText("Incomplete");
                   }
                   if (model.getWorkbook_4()!=null && model.getWorkbook_4().equals("Completed"))
                   {
                       done_4.setBackgroundTintList(colorStateList);
                       done_4.setImageResource(R.drawable.baseline_done_24);
                       message_4.setVisibility(View.GONE);

                   }
                   else
                   {
                       workbook_4_status.setText("Incomplete");
                   }
                   if (model.getWorkbook_5()!=null && model.getWorkbook_5().equals("Completed"))
                   {
                       done_5.setBackgroundTintList(colorStateList);
                       done_5.setImageResource(R.drawable.baseline_done_24);
                       message_5.setVisibility(View.GONE);

                   }
                   else
                   {
                       workbook_5_status.setText("Incomplete");
                   }
                   if (model.getWorkbook_6()!=null && model.getWorkbook_6().equals("Completed"))
                   {
                       done_6.setBackgroundTintList(colorStateList);
                       done_6.setImageResource(R.drawable.baseline_done_24);
                       message_6.setVisibility(View.GONE);

                   }
                   else
                   {
                       workbook_6_status.setText("Incomplete");
                   }



               }

               progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                    error_toast(getApplicationContext(),"Error : "+error.getMessage());
                    progressDialog.dismiss();
            }
        });

        done_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m1 = marks_1_status.getText().toString();

                if (TextUtils.isEmpty(m1))
                {
                    marks_1_status.setError("Marks Required");
                    return;
                }

                pd.show();
                done_1.setBackgroundTintList(colorStateList);
                done_1.setImageResource(R.drawable.baseline_done_24);

                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("workbook_1").setValue(submit)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_1").setValue(m1);
                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(view.getContext(),"Error : "+e.getMessage());
                            }
                        });


            }
        });

        done_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m2 = marks_2_status.getText().toString();

                if (TextUtils.isEmpty(m2))
                {
                    marks_2_status.setError("Marks Required");
                    return;
                }


                pd.show();

                done_2.setBackgroundTintList(colorStateList);
                done_2.setImageResource(R.drawable.baseline_done_24);


              reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("workbook_2").setValue("Completed")
              .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_2").setValue(m2);
                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(view.getContext(),"Error : "+e.getMessage());
                            }
                        });
            }
        });

        done_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m3 = marks_3_status.getText().toString();

                if (TextUtils.isEmpty(m3))
                {
                    marks_3_status.setError("Marks Required");
                    return;
                }

                pd.show();

                done_3.setBackgroundTintList(colorStateList);
                done_3.setImageResource(R.drawable.baseline_done_24);


                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("workbook_3").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_3").setValue(m3);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(view.getContext(),"Error : "+e.getMessage());
                            }
                        });

            }
        });

        done_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m4 = marks_4_status.getText().toString();

                if (TextUtils.isEmpty(m4))
                {
                    marks_4_status.setError("Marks Required");
                    return;
                }

                pd.show();

                done_4.setBackgroundTintList(colorStateList);
                done_4.setImageResource(R.drawable.baseline_done_24);


                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("workbook_4").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_4").setValue(m4);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(view.getContext(),"Error : "+e.getMessage());
                            }
                        });

            }
        });

        done_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m5 = marks_5_status.getText().toString();

                if (TextUtils.isEmpty(m5))
                {
                    marks_5_status.setError("Marks Required");
                    return;
                }

                pd.show();

                done_5.setBackgroundTintList(colorStateList);
                done_5.setImageResource(R.drawable.baseline_done_24);


                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("workbook_5").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_5").setValue(m5);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(view.getContext(),"Error : "+e.getMessage());
                            }
                        });

            }
        });


        done_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m6 = marks_6_status.getText().toString();

                if (TextUtils.isEmpty(m6))
                {
                    marks_6_status.setError("Marks Required");
                    return;
                }

                pd.show();

                done_6.setBackgroundTintList(colorStateList);
                done_6.setImageResource(R.drawable.baseline_done_24);

                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("workbook_6").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Workbook").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_6").setValue(m6);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(view.getContext(),"Error : "+e.getMessage());
                            }
                        });
            }
        });


        message_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Workbook 1 submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");

            }
        });

        message_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Workbook 2 submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");
            }
        });

        message_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Workbook 3 submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");

            }
        });

        message_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Workbook 4 submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");

            }
        });

        message_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Workbook 5 submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");

            }
        });

        message_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Hello, "+stud_name+" your "+sub+" Subject Workbook 6 submission is remaining. Please submit as soon as possible .";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(student_no, null, message, null, null);
                success_toast(view.getContext(),"SMS sent");

            }
        });

    }
}