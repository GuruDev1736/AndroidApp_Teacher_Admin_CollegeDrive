package com.guruprasad.teacherattend.dashboard.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.guruprasad.teacherattend.Attendance.Civil;
import com.guruprasad.teacherattend.Attendance.Computer;
import com.guruprasad.teacherattend.Attendance.E_and_TC;
import com.guruprasad.teacherattend.Attendance.IT;
import com.guruprasad.teacherattend.Attendance.Mechanical;
import com.guruprasad.teacherattend.Attendance.Pharmacy;
import com.guruprasad.teacherattend.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.computerDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Computer.class));
            }
        });

        binding.mechanicalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Mechanical.class));
            }
        });

        binding.civilDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Civil.class));
            }
        });

        binding.eAndTcDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), E_and_TC.class));
            }
        });

        binding.ITDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), IT.class));
            }
        });

        binding.pharmacyDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Pharmacy.class));
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