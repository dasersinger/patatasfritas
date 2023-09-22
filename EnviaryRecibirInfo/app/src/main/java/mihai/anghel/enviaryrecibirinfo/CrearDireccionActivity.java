package mihai.anghel.enviaryrecibirinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CrearDireccionActivity extends AppCompatActivity {
    private Button btnCrear;
    private EditText txtCalle;
    private EditText txtNumero;
    private EditText txtCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_direccion);
    }
}