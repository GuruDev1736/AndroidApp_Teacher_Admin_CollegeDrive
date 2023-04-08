package com.guruprasad.teacherattend.adapter;

import static com.guruprasad.teacherattend.Constants.error_toast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guruprasad.teacherattend.Attendance.ShowAttendance;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.attendance_combine_model;
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
            holder.status.setText("Status : "+model.getAttendance());
            holder.phone_no.setText("Phone No : "+model.getPhone_no());
            holder.date.setText("Date : "+model.getDate());

            if (model.getAttendance().equals("Present"))
            {
                holder.p_call.setVisibility(View.GONE);
                holder.s_call.setVisibility(View.GONE);
            }

        holder.p_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+model.getParent_no()));
                holder.itemView.getContext().startActivity(intent);
            }
        });

            holder.s_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+model.getPhone_no()));
                    holder.itemView.getContext().startActivity(intent);
                }
            });




    }

    @NonNull
                @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_layout,parent,false);
        return new AttendanceRecordAdapter.viewholder(view);
    }




    public class viewholder extends RecyclerView.ViewHolder {

        TextView name ,status , phone_no , date  ;

        Button p_call , s_call ;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Students");


        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.stud_name);
            status = itemView.findViewById(R.id.attendance_status);
            phone_no = itemView.findViewById(R.id.stud_no);
            date = itemView.findViewById(R.id.date_stud);
            p_call = itemView.findViewById(R.id.p_call);
            s_call = itemView.findViewById(R.id.s_call);


        }
    }
}
