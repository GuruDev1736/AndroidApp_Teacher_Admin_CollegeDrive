package com.guruprasad.teacherattend.submission;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.success_toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
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
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.view_assignment_model;
import com.guruprasad.teacherattend.model.view_workbook_model;

import java.util.Objects;

public class view_assignment extends AppCompatActivity {
    TextView name , department , year , division  ;
    ImageButton done_1 , done_2 , done_3 , done_4 , done_5 , done_6 ;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Submission");

    TextView assignment_1_status , assignment_2_status , assignment_3_status ,assignment_4_status , assignment_5_status, assignment_6_status ;

    EditText marks_1_status , marks_2_status , marks_3_status ,marks_4_status ,marks_5_status ,marks_6_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignment);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Assignment Submission");
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
        assignment_1_status = findViewById(R.id.status_assignment_1);
        assignment_2_status = findViewById(R.id.status_assignment_2);
        assignment_3_status = findViewById(R.id.status_assignment_3);
        assignment_4_status = findViewById(R.id.status_assignment_4);
        assignment_5_status = findViewById(R.id.status_assignment_5);
        assignment_6_status = findViewById(R.id.status_assignment_6);
        marks_1_status = findViewById(R.id.marks_assign_1);
        marks_2_status = findViewById(R.id.marks_assign_2);
        marks_3_status = findViewById(R.id.marks_assign_3);
        marks_4_status = findViewById(R.id.marks_assign_4);
        marks_5_status = findViewById(R.id.marks_assign_5);
        marks_6_status = findViewById(R.id.marks_assign_6);


        Intent intent = getIntent();
        String Year = intent.getStringExtra("year");
        String div = intent.getStringExtra("div");
        String depart = intent.getStringExtra("depart");
        String stud_name = intent.getStringExtra("name");
        String sub = intent.getStringExtra("sub");
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

        reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                view_assignment_model model = snapshot.getValue(view_assignment_model.class);

                if(model != null)
                {
                    assignment_1_status.setText(model.getAssignment_1());
                    assignment_2_status.setText(model.getAssignment_2());
                    assignment_3_status.setText(model.getAssignment_3());
                    assignment_4_status.setText(model.getAssignment_4());
                    assignment_5_status.setText(model.getAssignment_5());
                    assignment_6_status.setText(model.getAssignment_6());
                    marks_1_status.setText(model.getMarks_1());
                    marks_2_status.setText(model.getMarks_2());
                    marks_3_status.setText(model.getMarks_3());
                    marks_4_status.setText(model.getMarks_4());
                    marks_5_status.setText(model.getMarks_5());
                    marks_6_status.setText(model.getMarks_6());

                    if (model.getAssignment_1()!=null && model.getAssignment_1().equals("Completed"))
                    {
                        done_1.setBackgroundTintList(colorStateList);
                        done_1.setImageResource(R.drawable.baseline_done_24);
                    }
                    if (model.getAssignment_2()!=null && model.getAssignment_2().equals("Completed"))
                    {
                        done_2.setBackgroundTintList(colorStateList);
                        done_2.setImageResource(R.drawable.baseline_done_24);

                    }
                    if (model.getAssignment_3()!=null && model.getAssignment_3().equals("Completed"))
                    {
                        done_3.setBackgroundTintList(colorStateList);
                        done_3.setImageResource(R.drawable.baseline_done_24);

                    }
                    if (model.getAssignment_4()!=null && model.getAssignment_4().equals("Completed"))
                    {
                        done_4.setBackgroundTintList(colorStateList);
                        done_4.setImageResource(R.drawable.baseline_done_24);

                    }
                    if (model.getAssignment_5()!=null && model.getAssignment_5().equals("Completed"))
                    {
                        done_5.setBackgroundTintList(colorStateList);
                        done_5.setImageResource(R.drawable.baseline_done_24);

                    }
                    if (model.getAssignment_6()!=null && model.getAssignment_6().equals("Completed"))
                    {
                        done_6.setBackgroundTintList(colorStateList);
                        done_6.setImageResource(R.drawable.baseline_done_24);

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



                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("assignment_1").setValue(submit)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_1").setValue(m1);


                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");
                                done_1.setVisibility(View.INVISIBLE);
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


                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("assignment_2").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_2").setValue(m2);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");
                                done_2.setVisibility(View.INVISIBLE);
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


                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("assignment_3").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_3").setValue(m3);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");
                                done_3.setVisibility(View.INVISIBLE);
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


                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("assignment_4").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_4").setValue(m4);

                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");
                                done_4.setVisibility(View.INVISIBLE);
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



                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("assignment_5").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_5").setValue(m5);


                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");
                                done_5.setVisibility(View.INVISIBLE);
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


                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("assignment_6").setValue("Completed")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child("Assignment").child(depart).child(Year).child(div).child(sub).child(stud_name).child("marks_6").setValue(m6);
                                pd.dismiss();
                                success_toast(view.getContext(),"Data Updated");
                                done_6.setVisibility(View.INVISIBLE);
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



    }
}