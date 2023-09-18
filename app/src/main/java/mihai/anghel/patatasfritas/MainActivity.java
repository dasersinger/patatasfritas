package mihai.anghel.patatasfritas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //VARIABLES DE LA VISTA O LA INTERFAZ
    private Button btnRegistrar;
    private EditText txtEmail;
    private EditText txtPassword;

    //VARIABLES PARA LA LOGICA
    ArrayList<Usuario> listaUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZO TO_DO
        inicializaVista();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //COGER LOS TEXTOS DE LAS CAJAS
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                //COMPROBAR QUE ESTAN RELLENADOS Y SINO ADVERTIRLO
                if (email.isEmpty() || password.isEmpty()){
                    //NO SE PUEDE GUARDAR
                    Toast.makeText(MainActivity.this, "FUCK NIGGERS", Toast.LENGTH_SHORT).show();
                }else{
                    //GUARDAMOS EN LISTA
                    Usuario miusuario = new Usuario(email, password);
                    listaUsuarios.add(miusuario);
                    Toast.makeText(MainActivity.this, "ALMACENADO EN LA LISTA DE NIGGERS: " + miusuario.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializaVista() {
        listaUsuarios = new ArrayList<>();
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrar = findViewById(R.id.btnRegistrarMain);
    }

}