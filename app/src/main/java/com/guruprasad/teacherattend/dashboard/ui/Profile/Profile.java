package com.guruprasad.teacherattend.dashboard.ui.Profile;

import static com.guruprasad.teacherattend.Constants.error_toast;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guruprasad.teacherattend.Login;
import com.guruprasad.teacherattend.R;
import com.guruprasad.teacherattend.databinding.FragmentNotificationsBinding;
import com.guruprasad.teacherattend.databinding.FragmentProfileBinding;
import com.guruprasad.teacherattend.model.teacher_model;


public class Profile extends Fragment {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Teachers");



    private FragmentProfileBinding binding ;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait.....");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();


        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        try {
            reference.child("Profile").child(currentuser).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    teacher_model model = snapshot.getValue(teacher_model.class);

                  binding.teacherName.setText(model.getTeacher_name());
                  binding.teacherDepartment.setText(model.getDepartment());
                  binding.teacherYear.setText(model.getYear());
                  binding.teacherMail.setText(model.getEmail());
                  binding.teacherPhone.setText(model.getPhone());
                  binding.teacherQualification.setText(model.getTeacher_qualification());

                    progressDialog.dismiss();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    error_toast(getContext(),"Error : "+error.getMessage());
                    progressDialog.dismiss();

                }
            });

        }
        catch (Exception e)
        {
            error_toast(getContext(),"Error : "+e.getMessage());
            progressDialog.dismiss();

        }


        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), Login.class));
                getActivity().finish();
            }
        });

        return root ;

    }



}