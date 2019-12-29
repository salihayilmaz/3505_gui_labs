package gui_labs.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnArrayAdapter, btnCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnArrayAdapter = findViewById(R.id.btnArrayAdapter);
        btnCustomAdapter = findViewById(R.id.btnCustomAdapter);
        AdapterButtonListener listener = new AdapterButtonListener();
        btnArrayAdapter.setOnClickListener(listener);

//      View.OnClickListener listener2 = new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              Log.d("AdapterButtonListener", "Clicked");
//              Intent intent = new Intent(MainActivity.this, ArrayAdapterActivity.class);
//              startActivity(intent);
//          }
//      };

        btnCustomAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CustomButtonListener", "Clicked");
                Intent intent = new Intent(MainActivity.this, CustomAdapterActivity.class);
                startActivity(intent);
            }
        });
    }

    private class AdapterButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.d("AdapterButtonListener", "Clicked");
            Intent intent = new Intent(MainActivity.this, ArrayAdapterActivity.class);
            startActivity(intent);
        }

    }
}
