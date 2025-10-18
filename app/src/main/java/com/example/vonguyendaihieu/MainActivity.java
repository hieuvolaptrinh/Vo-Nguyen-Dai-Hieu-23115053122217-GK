package com.example.vonguyendaihieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button btnAdd_2217;
    EditText name_2217, msv_2217;
    ActivityResultLauncher<Intent> profileActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        profileActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Intent data = result.getData();
                            String updatedName = data.getStringExtra("updated_name_2217");
                            String updatedMsv = data.getStringExtra("updated_msv_2217");

                            if (updatedName != null) {
                                name_2217.setText(updatedName);
                            }
                            if (updatedMsv != null) {
                                msv_2217.setText(updatedMsv);
                            }
                        }
                    }
                });

        btnAdd_2217 = findViewById(R.id.btnAdd_2217);
        name_2217 = findViewById(R.id.name_2217);
        msv_2217 = findViewById(R.id.msv_2217);
        btnAdd_2217.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityProfile.class);
            intent.putExtra("name_2217", name_2217.getText().toString());
            intent.putExtra("msv_2217", msv_2217.getText().toString());
            profileActivityLauncher.launch(intent);
        });
    }
}
