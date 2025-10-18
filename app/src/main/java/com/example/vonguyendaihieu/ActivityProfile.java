package com.example.vonguyendaihieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;

public class ActivityProfile extends AppCompatActivity {
    TextView back_2217;
    Button btnEdit_2217;
    EditText name_2217, msv_2217;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back_2217 = findViewById(R.id.back_2217);
        name_2217 = findViewById(R.id.editName_2217);
        msv_2217 = findViewById(R.id.editMsv_2217);
        btnEdit_2217 = findViewById(R.id.btnEdit_2217);

        name_2217.setText(getIntent().getStringExtra("name_2217"));
        msv_2217.setText(getIntent().getStringExtra("msv_2217"));

        btnEdit_2217.setOnClickListener(v -> {
            sendDataBackToMain();
        });

        back_2217.setOnClickListener(v -> {
            sendDataBackToMain();
        });
    }

    private void sendDataBackToMain() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("updated_name_2217", name_2217.getText().toString());
        resultIntent.putExtra("updated_msv_2217", msv_2217.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}

