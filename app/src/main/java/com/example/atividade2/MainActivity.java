package com.example.atividade2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade2.R;
import com.example.atividade2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private @NonNull ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.lblDados.setVisibility(View.INVISIBLE);
        binding.btnExibir.setOnClickListener(this);
        binding.btnLimpar.setOnClickListener(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLimpar){
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.rdbMasculino.setChecked(false);
            binding.rdbFeminino.setChecked(false);
            binding.chkMusica.setChecked(false);
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastronimia.setChecked(false);
            binding.txtNome.setText("");
            binding.txtEmail.setText("");
            binding.txtTelefone.setText("");
            binding.txtPref.setText("");
            binding.lblDados.setVisibility(View.INVISIBLE);
            binding.swtNotif.setChecked(false);
        }
        else if(view.getId() == R.id.btnExibir){
            binding.lblDados.setVisibility(View.VISIBLE);

            String nome = binding.edtNome.getText().toString().trim();
            String email = binding.edtEmail.getText().toString().trim();
            String telefone = binding.edtTelefone.getText().toString().trim();

            if (!nome.isEmpty()) {
                binding.txtNome.setText("Nome: " + nome);
            } else {
                binding.txtNome.setText("");
            }

            if (!email.isEmpty()) {
                binding.txtEmail.setText("Email: " + email);
            } else {
                binding.txtEmail.setText("");
            }

            if (!telefone.isEmpty()) {
                binding.txtTelefone.setText("Telefone: " + telefone);
            } else {
                binding.txtTelefone.setText("");
            }


            int idRDBSelecionado = binding.rdgSexo.getCheckedRadioButtonId();
            if(idRDBSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idRDBSelecionado);
                binding.txtPeriodo.setText("Sexo: " + rdbSelecionado.getText().toString());
            }
            else {
                binding.txtPeriodo.setText("");
            }

            String pref = "";
            if(binding.chkMusica.isChecked())
                pref += binding.chkMusica.getText().toString() + ", ";
            if(binding.chkCinema.isChecked())
                pref += binding.chkCinema.getText().toString() + ", ";
            if(binding.chkEsporte.isChecked())
                pref += binding.chkEsporte.getText().toString() + ", ";
            if(binding.chkGastronimia.isChecked())
                pref += binding.chkGastronimia.getText().toString() + ", ";

            if (!pref.isEmpty()) {
                pref = pref.substring(0, pref.length() - 2);
                binding.txtPref.setText("Preferências: " + pref);
            } else {
                binding.txtPref.setText("");
            }
        }
    }
}