package mihai.anghel.enviaryrecibirinfo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mihai.anghel.enviaryrecibirinfo.modelos.Direccion;
import mihai.anghel.enviaryrecibirinfo.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnDesencriptar;
    private Button btnCrearDireccion;
    private final int DIRECCIONES = 123;
    private ActivityResultLauncher<Intent> launcherDirecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();
        inicializarLauncher();
        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = txtPassword.getText().toString();
                String email = txtEmail.getText().toString();
                Usuario usuario = new Usuario(email, password);

                Intent intent = new Intent(MainActivity.this, DesencriptarActivity.class);
                //ENVIAR INFORMACION A LA SIGUIENTE ACTIVIDAD
                Bundle bundle = new Bundle();
                //bundle.putString("PASS", password);
                bundle.putSerializable("USER", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnCrearDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearDireccionActivity.class);
                //startActivity(intent);
                //startActivityForResult(intent, DIRECCIONES);
                launcherDirecciones.launch(intent);
            }
        });
    }

    private void inicializarLauncher() {
        //registrar una actividad de retorno con dos partes
        //1- Como lanzao la aktibidad hija (equivalente al startActivityForResult)
        //2- Que hago cuando la hija termina (equivalente al onActivityResult)
        launcherDirecciones = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK){
                    if (result.getData() != null){
                        Bundle bundle = result.getData().getExtras();
                        Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                        Toast.makeText(MainActivity.this, direccion.toString(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "CANCELADA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*/**
     * Se activa al retornar StartActivityForResult
     * @param requestCode -> identificador de la ventana o actividad que se ha cerrado, "el tipo de dato que retorna"
     * @param resultCode -> el mod en que se ha cerrado
     * @param data -> Datos retornados (intent con el bundle dentro)
     */
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // averiguar que actividad se cerro
        if (requestCode == DIRECCIONES){
            //averiguar si se cerro con exito
            if (resultCode == RESULT_OK){
                //averiguar si vuelve con datos
                if (data != null){
                    Bundle bundle = data.getExtras();
                    Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                    Toast.makeText(this, direccion.toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "CANCELADA", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
        btnCrearDireccion = findViewById(R.id.btnCrearDireccionMain);
    }
}