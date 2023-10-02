package mihai.anghel.enviarrecibir2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mihai.anghel.enviarrecibir2.R;
import mihai.anghel.enviarrecibir2.modelos.Bici;
import mihai.anghel.enviarrecibir2.modelos.Moto;

public class CrearBiciActivity extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

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
                //SACAR LA INFORMACION DE LA VISTA PARA CREAR UNA BICI
                String marca = txtMarca.getText().toString();
                String pulgadas = txtPulgadas.getText().toString();

                if (marca.isEmpty() || pulgadas.isEmpty()){
                    Toast.makeText(CrearBiciActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    Bici bici = new Bici (marca, pulgadas);
                    //ENVIAR EL COCHE A LA ACTIVIDAD ANTERIOR
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);
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
        txtPulgadas = findViewById(R.id.txtPulgadasCrearBici);

        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearCrearMoto);
    }
}