package com.example.trabalhodedispositivosmaveis01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalhodedispositivosmaveis01.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    String medidaValue;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        medidaValue = "";
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        binding.textboxHeightPy.setText(getArguments().getString("height"));
        binding.textboxBasePy.setText(getArguments().getString("base"));

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int height;
                int base;
                int result;
                Bundle bundle = new Bundle();

                try{
                    height = Integer.parseInt(binding.textboxHeightPy.getText().toString());
                    base = Integer.parseInt(binding.textboxBasePy.getText().toString());

                    result = (height * base)/3;
                    if(binding.radioMm.isChecked())
                        medidaValue = " mm³";

                    if(binding.radioCm.isChecked())
                        medidaValue = " cm³";

                    if(binding.radioDm.isChecked())
                        medidaValue = " dm³";


                    bundle.putString("result", result + medidaValue);
                }catch (Exception e){
                    bundle.putString("result", "Erro ao calcular");
                    System.out.println(e.toString());
                }
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment, bundle);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}