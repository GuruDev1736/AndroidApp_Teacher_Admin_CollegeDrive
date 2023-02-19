package com.guruprasad.teacherattend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.student_model;

public class attendance_adapter extends FirebaseRecyclerAdapter<student_model,attendance_adapter.onviewholder> {


    public attendance_adapter(@NonNull FirebaseRecyclerOptions<student_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull onviewholder holder, int position, @NonNull student_model model) {

        holder.name.setText("Name: "+model.getStud_name());
        holder.department.setText("Department : "+model.getDepartment());
        holder.year.setText("Year : "+model.getYear());
        holder.Phone.setText("Phone No : "+model.getStud_no());

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


        public onviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.stud_name);
            department = itemView.findViewById(R.id.stud_department);
            year = itemView.findViewById(R.id.stud_year);
            Phone = itemView.findViewById(R.id.stud_phone);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
