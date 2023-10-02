package mihai.anghel.enviarrecibir2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mihai.anghel.enviarrecibir2.R;
import mihai.anghel.enviarrecibir2.modelos.Moto;

public class CrearMotoActivity extends AppCompatActivity {
    //VARIABLES DE VISTA
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCilindrada;
    private Button btnCancelar;
    private Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);

        inicializarVista();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SACAR LA INFORMACION DE LA VISTA PARA CREAR UNA MOTO
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String cilindrada = txtCilindrada.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()){
                    Toast.makeText(CrearMotoActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    Moto moto = new Moto(marca, modelo, cilindrada);
                    //ENVIAR EL COCHE A LA ACTIVIDAD ANTERIOR
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);

                    //DEVOLVER UN RESULTADO DE OK
                    setResult(RESULT_OK, intent);

                    //TERMINAR
                    finish();
                }

            }
        });
    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaCrearCoche);
        txtModelo = findViewById(R.id.txtModeloCrearMoto);
        txtCilindrada = findViewById(R.id.txtCilindradaCrearMoto);

        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearCrearMoto);
    }
}