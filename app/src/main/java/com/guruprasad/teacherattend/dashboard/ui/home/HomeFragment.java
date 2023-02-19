package com.guruprasad.teacherattend.dashboard.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.guruprasad.teacherattend.Department.IT;
import com.guruprasad.teacherattend.Department.civil;
import com.guruprasad.teacherattend.Department.computer;
import com.guruprasad.teacherattend.Department.e_and_tc;
import com.guruprasad.teacherattend.Department.mechanical;
import com.guruprasad.teacherattend.Department.pharmacy;
import com.guruprasad.teacherattend.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.computerDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), computer.class));
            }
        });

        binding.mechanicalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), mechanical.class));
            }
        });

        binding.civilDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), civil.class));
            }
        });

        binding.eAndTcDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), e_and_tc.class));
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
                startActivity(new Intent(view.getContext(), pharmacy.class));
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