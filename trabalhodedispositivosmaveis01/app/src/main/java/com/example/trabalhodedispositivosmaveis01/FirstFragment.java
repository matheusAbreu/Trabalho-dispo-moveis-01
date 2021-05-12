package com.example.trabalhodedispositivosmaveis01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalhodedispositivosmaveis01.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLinkSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText heightText = (EditText) getView().findViewById(R.id.textboxMainHeightPy);
                int valueHeight = Integer.parseInt(heightText.getText().toString());

                EditText baseText = (EditText) getView().findViewById(R.id.textboxMainBasePy);
                int valueBase = Integer.parseInt(baseText.getText().toString());

                //ConfirmationAction action = SecoundFragmentDirections.confirmationAction();

                //action.setHeight(valueHeight);
                //action.setBase(valueBase);

                //NavHostFragment.findNavController(FirstFragment.this).navigate(action);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.buttonLinkThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
            }
        });
        binding.buttonLinkFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_FourthFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}