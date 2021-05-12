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
        String result = "";
        try{
            result = getArguments().getString("result");

            if (result.length() > 0)
                binding.textViewFirst.setText("O resultado final foi de "+result+".");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLinkSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText heightText = (EditText) getView().findViewById(R.id.textboxMainHeightPy);

                EditText baseText = (EditText) getView().findViewById(R.id.textboxMainBasePy);

                Bundle bundle = new Bundle();
                bundle.putString("height", heightText.getText().toString() );
                bundle.putString("base", baseText.getText().toString());

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
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