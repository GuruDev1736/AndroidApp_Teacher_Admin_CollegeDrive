package com.guruprasad.teacherattend.dashboard.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.guruprasad.teacherattend.Attendance.Civil;
import com.guruprasad.teacherattend.Attendance.Computer;
import com.guruprasad.teacherattend.Attendance.E_and_TC;
import com.guruprasad.teacherattend.Attendance.IT;
import com.guruprasad.teacherattend.Attendance.Mechanical;
import com.guruprasad.teacherattend.Attendance.Pharmacy;
import com.guruprasad.teacherattend.Department.civil;
import com.guruprasad.teacherattend.Department.computer;
import com.guruprasad.teacherattend.Department.e_and_tc;
import com.guruprasad.teacherattend.Department.mechanical;
import com.guruprasad.teacherattend.Department.pharmacy;
import com.guruprasad.teacherattend.databinding.FragmentDashboardBinding;
import com.guruprasad.teacherattend.select_attendance_option;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.computerDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), select_attendance_option.class));
            }
        });

        binding.mechanicalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), select_attendance_option.class));
            }
        });

        binding.civilDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), select_attendance_option.class));
            }
        });

        binding.eAndTcDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), select_attendance_option.class));
            }
        });

        binding.ITDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), select_attendance_option.class));
            }
        });

        binding.pharmacyDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), select_attendance_option.class));
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}