package com.example.trabalhodedispositivosmaveis01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalhodedispositivosmaveis01.databinding.FragmentFourthBinding;


public class FourthFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentFourthBinding binding;
    static String[] Medidas = {"Milimetros", "Centimetros", "Decimetros"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFourthBinding.inflate(inflater, container, false);

        ArrayAdapter values = new ArrayAdapter(binding.getRoot().getContext(), R.layout.support_simple_spinner_dropdown_item, Medidas);

        values.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        binding.spMedida.setAdapter(values);
        
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FourthFragment.this)
                        .navigate(R.id.action_FourthFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}