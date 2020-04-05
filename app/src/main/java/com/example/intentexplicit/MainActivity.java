package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String phoneNumber = "+6281215505247";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithData = findViewById(R.id.btn_move_activity_data);
        btnMoveWithData.setOnClickListener(this);

        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        Button btnChatWA = findViewById(R.id.btn_chat_wa);
        btnChatWA.setOnClickListener(this);

        Button btnBcWA = findViewById(R.id.btn_bc_wa);
        btnBcWA.setOnClickListener(this);

        Button btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(this);

    }
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_move_activity:
                        Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                        startActivity(moveIntent);
                        break;
                    case R.id.btn_move_activity_data:
                        Intent moveWithDataIntent = new Intent(MainActivity.this, MoveDataActivity.class);
                        moveWithDataIntent.putExtra(MoveDataActivity.EXTRA_NAME, "Tyas");
                        moveWithDataIntent.putExtra(MoveDataActivity.EXTRA_AGE, 21);
                        startActivity(moveWithDataIntent);
                        break;
                    case R.id.btn_dial_number:
                        Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNumber));
                        startActivity(dialPhoneIntent);
                        break;
                    case R.id.btn_chat_wa:
                        String url = "https://api.whatsapp.com/send?phone=" + phoneNumber;
                        Intent chatWA = new Intent(Intent.ACTION_VIEW);
                        chatWA.setData(Uri.parse(url));
                        startActivity(chatWA);
                        break;
                    case R.id.btn_bc_wa:
                        Intent bcWa = new Intent(MainActivity.this, BroadcastWhatsAppActivity.class);
                        startActivity(bcWa);
                        break;
                    case R.id.btn_map:
                        Uri location = Uri.parse("geo:-7.1107786,110.264985");
                        // Or map point based on latitude/longitude
                        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
                        Intent map = new Intent(Intent.ACTION_VIEW, location);
                        startActivity(map);
                        break;
                }
            }

}
