package com.guruprasad.teacherattend.adapter;

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
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.combine_model;
import com.guruprasad.teacherattend.submission.view_lab_manual;
import com.guruprasad.teacherattend.submission.view_workbook;

public class lab_manual_adapter extends FirebaseRecyclerAdapter<combine_model,lab_manual_adapter.viewholder> {

    private String sub ;

    public lab_manual_adapter(@NonNull FirebaseRecyclerOptions<combine_model> options , String subject) {
        super(options);
        this.sub = subject;
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull combine_model model) {

        holder.name.setText(model.getStud_name());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), view_lab_manual.class);
                intent.putExtra("name",model.getStud_name());
                intent.putExtra("depart",model.getDepartment());
                intent.putExtra("year",model.getYear());
                intent.putExtra("div",model.getDivision());
                intent.putExtra("sub",sub);
                intent.putExtra("stud_no",model.getStud_no());
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_submission,parent,false);
        return new lab_manual_adapter.viewholder(view);
    }




    public class viewholder extends RecyclerView.ViewHolder {

        TextView name , view ;




        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            view = itemView.findViewById(R.id.view_workbook);


        }
    }
}
