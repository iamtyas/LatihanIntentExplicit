package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BroadcastWhatsAppActivity extends AppCompatActivity {

    private EditText editNama, editNomor;
    private Button btnBCWA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_whats_app);

        editNama = findViewById(R.id.edit_nama_bc);
        editNomor = findViewById(R.id.edit_nomor_bc);
        btnBCWA = findViewById(R.id.btn_bc_wa);

        btnBCWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editNama.getText().toString();
                String nomor = editNomor.getText().toString();
                String pesan = "Hallo Kak " + nama + "\n\n" + "Thanks and Best Regards\nTyas";
                Intent sendWA = new Intent(Intent.ACTION_SEND);
                sendWA.setType("text/plain");
                sendWA.putExtra(Intent.EXTRA_TEXT, pesan);
                sendWA.putExtra("jid", "62" + nomor + "@s.whatsapp.net");
                sendWA.setPackage("com.whatsapp");
                startActivity(sendWA);
            }
        });
    }

}
