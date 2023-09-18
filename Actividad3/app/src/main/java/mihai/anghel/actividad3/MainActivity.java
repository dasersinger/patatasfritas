package mihai.anghel.actividad3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ESTADOS", "6- Estoy en el metodo Destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ESTADOS", "5- Estoy en el metodo Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ESTADOS", "4- Estoy en el metodo Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ESTADOS", "3- Estoy en el metodo Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ESTADOS", "2- Estoy en el metodo Start");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("ESTADOS", "1- Estoy en el metodo Create");
    }
}