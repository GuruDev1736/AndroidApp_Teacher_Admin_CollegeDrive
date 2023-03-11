package com.guruprasad.teacherattend.adapter;

import static com.guruprasad.teacherattend.Constants.error_toast;
import static com.guruprasad.teacherattend.Constants.success_toast;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.model.combine_model;
import com.guruprasad.teacherattend.model.student_model;
import com.guruprasad.teacherattend.model.workbook_model;
import com.guruprasad.teacherattend.submission.view_workbook;

import org.w3c.dom.Text;

public class workbook_adapter extends FirebaseRecyclerAdapter<combine_model,workbook_adapter.viewholder> {

    private String sub ;

    public workbook_adapter(@NonNull FirebaseRecyclerOptions<combine_model> options , String subject) {
        super(options);
        this.sub = subject;
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull combine_model model) {

        ProgressDialog pd = new ProgressDialog(holder.itemView.getContext());
        pd.setTitle("Marking As Submit");
        pd.setMessage("Please Wait...");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);


        holder.name.setText(model.getStud_name());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), view_workbook.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });




//
//        holder.a1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                pd.show();
//
//                workbook_model model1 = new workbook_model(model.getStud_name(),model.getDepartment(),model.getYear()
//                        ,model.getDivision(),"Completed",null,null,null,null,null);
//
//                holder.databaseReference.child(model.getDepartment()).child(model.getYear())
//                        .child(model.getDivision()).child(sub).
//                        child(holder.databaseReference.push().getKey()).setValue(model1)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                pd.dismiss();
//                                success_toast(holder.a1.getContext(), "Assignment Successfully Updated");
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                pd.dismiss();
//                                error_toast(holder.a1.getContext(), "Assignment Failed to Updated"+e.getMessage());
//
//                            }
//                        });
//            }
//        });


    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_submission,parent,false);
        return new workbook_adapter.viewholder(view);
    }




    public class viewholder extends RecyclerView.ViewHolder {

        TextView name , view ;

        DatabaseReference databaseReference ;
        FirebaseDatabase database;



        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            view = itemView.findViewById(R.id.view_workbook);
            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference("Submission");

        }
    }
}
