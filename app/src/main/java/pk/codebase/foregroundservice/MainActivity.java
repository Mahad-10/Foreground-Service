package pk.codebase.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput = findViewById(R.id.edit_text_input);
        Button btnStart = findViewById(R.id.btn_start_service);
        Button btnStop = findViewById(R.id.btn_stop_service);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editTextInput.getText().toString();
                Intent serviceIntent = new Intent(MainActivity.this,ExampleService.class);
                serviceIntent.putExtra("inputExtra",input);
                startService(serviceIntent);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(MainActivity.this,ExampleService.class);
                stopService(serviceIntent);
            }
        });


    }
}