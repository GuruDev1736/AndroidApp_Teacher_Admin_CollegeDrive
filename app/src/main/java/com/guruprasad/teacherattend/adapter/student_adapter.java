package com.guruprasad.teacherattend.adapter;


import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.guruprasad.teacherattend.student_profile;

public class student_adapter extends FirebaseRecyclerAdapter<student_model,student_adapter.onviewholder> {

    public student_adapter(@NonNull FirebaseRecyclerOptions<student_model> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull onviewholder holder, int position, @NonNull student_model model) {

        holder.name.setText("Name: "+model.getStud_name());
        holder.department.setText("Department : "+model.getDepartment());
        holder.year.setText("Year : "+model.getYear());
        holder.Phone.setText("Phone No : "+model.getStud_no());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), student_profile.class);
                intent.putExtra("name",model.getStud_name());
                intent.putExtra("department",model.getDepartment());
                intent.putExtra("year",model.getYear());
                intent.putExtra("stud_no",model.getStud_no());
                intent.putExtra("email",model.getStud_email());
                intent.putExtra("parent_no",model.getParent_no());
                intent.putExtra("div",model.getDivision());
                view.getContext().startActivity(intent);


            }
        });




    }

    @NonNull
    @Override
    public onviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout,parent,false);
        return new onviewholder(view);
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

