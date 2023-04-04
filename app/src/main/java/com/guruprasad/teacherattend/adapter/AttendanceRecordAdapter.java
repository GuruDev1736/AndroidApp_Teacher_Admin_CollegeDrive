package com.guruprasad.teacherattend.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.Attendance.ShowAttendance;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.attendance_model;
import com.guruprasad.teacherattend.model.combine_model;
import com.guruprasad.teacherattend.submission.view_lab_manual;
import com.guruprasad.teacherattend.submission.view_workbook;

public class AttendanceRecordAdapter extends FirebaseRecyclerAdapter<attendance_model,AttendanceRecordAdapter.viewholder> {



    public AttendanceRecordAdapter(@NonNull FirebaseRecyclerOptions<attendance_model> options) {
        super(options);

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull attendance_model model) {


            holder.name.setText("Name : "+model.getName());
            holder.status.setText(model.getAttendance());
            holder.phone_no.setText(model.getPhone_no());
            holder.date.setText(model.getDate());

    }

    @NonNull
                @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout,parent,false);
        return new AttendanceRecordAdapter.viewholder(view);
    }




    public class viewholder extends RecyclerView.ViewHolder {

        TextView name ,status , phone_no , date  ;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.stud_name);
            status = itemView.findViewById(R.id.stud_department);
            phone_no = itemView.findViewById(R.id.stud_year);
            date = itemView.findViewById(R.id.stud_phone);


        }
    }
}
