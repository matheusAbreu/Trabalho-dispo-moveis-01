package com.example.trabalhodedispositivosmaveis01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalhodedispositivosmaveis01.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    String medida;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);

        /*Android Studio que me obrigou a fazer isso,
            por mim o componente poderia ter funcionado
            normal desdo inicio. Então desculpa pela gamiarra...*/
        binding.checkBoxMm.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {onCheckboxClicked(view);}
        });
        binding.checkBoxCm.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {onCheckboxClicked(view);}
        });
        binding.checkBoxDm.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {onCheckboxClicked(view);}
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double radius;
                Double result;

                try{
                    radius = Double.parseDouble(binding.textboxRadius.getText().toString());

                    result = 4 * Math.PI * (Math.pow(radius, 3)/3);
                    if(medida.isEmpty())
                        throw new Exception("Medida não selecionada");

                    binding.textViewThird.setText("O volume é de " + result+ " " + medida);
                }catch (Exception e){
                    System.out.println(e.toString());
                    binding.textViewThird.setText("Houve um erro ao calcular, por favor tente novamente");
                }
                //NavHostFragment.findNavController(ThirdFragment.this)
                       // .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });
    }

    public void onCheckboxClicked(@NonNull View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxMm:
                if (checked)
                {
                    binding.checkBoxCm.setChecked(false);
                    binding.checkBoxDm.setChecked(false);
                    medida = "mm³";
                }
                break;
            case R.id.checkBoxCm:
                if (checked)
                {
                    binding.checkBoxMm.setChecked(false);
                    binding.checkBoxDm.setChecked(false);
                    medida = "cm³";
                }
                break;
            case R.id.checkBoxDm:
                if (checked)
                {
                    binding.checkBoxCm.setChecked(false);
                    binding.checkBoxMm.setChecked(false);
                    medida = "dm³";
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}