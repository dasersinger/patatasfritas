package mihai.anghel.enviaryrecibirinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DesencriptarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        //SACAR LA INFO QUE LLEGA
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            String password = bundle.getString("PASS");
            Toast.makeText(this, password, Toast.LENGTH_SHORT).show();
        }
    }
}