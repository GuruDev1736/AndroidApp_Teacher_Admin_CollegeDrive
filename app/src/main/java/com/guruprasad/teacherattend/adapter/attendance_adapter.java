package com.guruprasad.teacherattend.adapter;


import static android.content.Intent.getIntent;
import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.success_toast;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.attendance_student;
import com.guruprasad.teacherattend.model.attendance_model;
import com.guruprasad.teacherattend.model.student_model;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class attendance_adapter extends FirebaseRecyclerAdapter<student_model,attendance_adapter.onviewholder> {
    private String myValue;
    private String sub_no;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Students");
    public attendance_adapter(@NonNull FirebaseRecyclerOptions<student_model> options , String value , String subject_no ) {
        super(options);
        this.myValue = value;
        this.sub_no = subject_no;
    }



    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull onviewholder holder, int position, @NonNull student_model model) {

        holder.name.setText("Name: "+model.getStud_name());
        holder.department.setText("Department : "+model.getDepartment());
        holder.year.setText("Year : "+model.getYear());
        holder.Phone.setText("Phone No : "+model.getStud_no());
        String key = holder.databaseReference.push().getKey();



        holder.present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.imageView.setBackgroundColor(Color.GREEN);
                String attendance = "Present";


                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setTitle("Marking Attendance");
                pd.setMessage("Please Wait...");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);
                pd.show();

                String date = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                }


                attendance_model attendance_model = new attendance_model(model.getStud_name(),model.getDepartment(),model.getStud_no(),model.getDivision()
                ,model.getYear(),attendance,date,key);

                holder.databaseReference.child(date).child(model.getDepartment()).child(model.getYear()).child(model.getDivision()).child(myValue)
                        .child("Lecture No : "+sub_no)
                        .child(key)
                        .setValue(attendance_model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                success_toast(view.getContext(), model.getStud_name()+" Present");
                                pd.dismiss();
                                holder.absent.setVisibility(View.INVISIBLE);
                                holder.present.setVisibility(View.INVISIBLE);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                error_toast(view.getContext(),"Failed to mark attendance : "+e.getMessage());
                                pd.dismiss();
                            }
                        });


            }
        });

        holder.absent.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                holder.imageView.setBackgroundColor(Color.RED);
                String attendance = "Absent";

                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setTitle("Marking Attendance");
                pd.setMessage("Please Wait...");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);
                pd.show();

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(Calendar.getInstance().getTime());

                String date = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                }


                Dexter.withContext(view.getContext()).withPermission(Manifest.permission.SEND_SMS).withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        String phoneNumber ="8830861403";
                        String message = "Dear Parents , Kindly take a note that your child is absent for today's lecture ";

                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNumber, null, message, null, null);

                        success_toast(view.getContext(),"SMS sent");

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                            error_toast(view.getContext(),"Permission Denied...");
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();
                    }
                }).check();




                attendance_model attendance_model = new attendance_model(model.getStud_name(),model.getDepartment(),model.getStud_no(),model.getDivision()
                        ,model.getYear(),attendance,date,key);

                holder.databaseReference.child(date).child(model.getDepartment()).child(model.getYear()).child(model.getDivision()).child(myValue)
                        .child("Lecture No : "+sub_no) .child(key)
                        .setValue(attendance_model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                error_toast(view.getContext(), model.getStud_name()+" Absent");
                                pd.dismiss();
                                holder.present.setVisibility(View.INVISIBLE);
                                holder.absent.setVisibility(View.INVISIBLE);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                error_toast(view.getContext(),"Failed to mark attendance : "+e.getMessage());
                                pd.dismiss();
                            }
                        });


            }
        });


        holder.modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(view.getContext(), R.style.AttendanceTheme)
                        .setTitle("Update Attendance")
                        .setMessage("Updating the Attendance of "+model.getStud_name())
                        .setIcon(R.drawable.update)
                        .setPositiveButton("Present", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                holder.imageView.setBackgroundColor(Color.GREEN);


                                String date = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                                }

                                String attendance = "Present" ;

                                HashMap<String , Object> obj = new HashMap<>();
                                obj.put("attendance",attendance);

                                ProgressDialog pd = new ProgressDialog(view.getContext());
                                pd.setTitle("Updating Attendance ");
                                pd.setMessage("Updating Please Wait...... ");
                                pd.setCancelable(false);
                                pd.setCanceledOnTouchOutside(false);

                                pd.show();
                                holder.database.getReference().child("Attendance").child(date).child(model.getDepartment()).child(model.getYear()).child(model.getDivision())
                                        .child(myValue).child("Lecture No : "+sub_no).child(key)
                                        .updateChildren(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        success_toast(view.getContext(),"Attendance has been updated");
                                        pd.dismiss();
                                    }
                                });


                            }
                        })
                        .setNeutralButton("Absent", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                holder.imageView.setBackgroundColor(Color.RED);

                                String date = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                                }

                                String attendance = "Absent" ;
                                HashMap<String , Object> obj = new HashMap<>();
                                obj.put("attendance",attendance);

                                ProgressDialog pd = new ProgressDialog(view.getContext());
                                pd.setTitle("Updating Attendance ");
                                pd.setMessage("Updating Please Wait...... ");
                                pd.setCancelable(false);
                                pd.setCanceledOnTouchOutside(false);

                                pd.show();
                                holder.database.getReference().child("Attendance").child(date).child(model.getDepartment()).child(model.getYear())
                                        .child(model.getDivision()).child(myValue).child("Lecture No : "+sub_no).child(key)
                                        .updateChildren(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                success_toast(view.getContext(),"Attendance has been updated");
                                                pd.dismiss();
                                            }});
                            }
                        })
                        .show();
            }
        });






    }

    @NonNull
    @Override
    public onviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_attend,parent,false);
        return new attendance_adapter.onviewholder(view);
    }

    public class onviewholder extends RecyclerView.ViewHolder {

        TextView name , department , year  , Phone ;
        CardView cardView ;
        Button present , absent ;
        ImageButton modify , face  ;
        DatabaseReference databaseReference ;
        FirebaseDatabase database;
        ImageView imageView ;


        public onviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.stud_name);
            department = itemView.findViewById(R.id.stud_department);
            year = itemView.findViewById(R.id.stud_year);
            Phone = itemView.findViewById(R.id.stud_phone);
            cardView = itemView.findViewById(R.id.cardview);
            present = itemView.findViewById(R.id.present);
            absent = itemView.findViewById(R.id.absent);
            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference("Attendance");
            modify = itemView.findViewById(R.id.modify);
            imageView = itemView.findViewById(R.id.img1);

        }


}
}
