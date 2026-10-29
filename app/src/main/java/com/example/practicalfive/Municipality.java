package com.example.practicalfive;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Municipality extends AppCompatActivity {

    private String currentMunicipality = "";
    private String websiteUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        TextView tvName = findViewById(R.id.tvMunicipalityName);
        TextView tvInfo = findViewById(R.id.tvMunicipalityInfo);
        ImageView ivPic = findViewById(R.id.ivMunicipalityPic);
        Button btnVisit = findViewById(R.id.btnVisitSite);

        currentMunicipality = getIntent().getStringExtra("MUNICIPALITY_NAME");

        if (currentMunicipality == null) {
            finish();
            return;
        }

        String[] infoArray = getResources().getStringArray(R.array.municipalities_array);

        switch (currentMunicipality) {
            case "Beijing":
                tvName.setText("Beijing");
                tvName.setBackgroundColor(getResources().getColor(R.color.municipality_Beijing, null));
                tvInfo.setTextColor(getResources().getColor(R.color.municipality_Beijing, null));
                ivPic.setImageResource(R.drawable.beijing);
                tvInfo.setText(infoArray[0]);
                btnVisit.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.municipality_Beijing, null)));
                websiteUrl = "https://english.beijing.gov.cn/";
                break;
            case "Shanghai":
                tvName.setText("Shanghai");
                tvName.setBackgroundColor(getResources().getColor(R.color.municipality_shanghai, null));
                tvInfo.setTextColor(getResources().getColor(R.color.municipality_shanghai, null));
                ivPic.setImageResource(R.drawable.shanghai);
                tvInfo.setText(infoArray[1]);
                btnVisit.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.municipality_shanghai, null)));
                websiteUrl = "https://english.shanghai.gov.cn/";
                break;
            case "Chongqing":
                tvName.setText("Chongqing");
                tvName.setBackgroundColor(getResources().getColor(R.color.municipality_chongqing, null));
                tvInfo.setTextColor(getResources().getColor(R.color.municipality_chongqing, null));
                ivPic.setImageResource(R.drawable.chongqing);
                tvInfo.setText(infoArray[2]);
                btnVisit.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.municipality_chongqing, null)));
                websiteUrl = "https://english.cq.gov.cn/";
                break;
            case "Tianjin":
                tvName.setText("Tianjin");
                tvName.setBackgroundColor(getResources().getColor(R.color.municipality_tianjin, null));
                tvInfo.setTextColor(getResources().getColor(R.color.municipality_tianjin, null));
                ivPic.setImageResource(R.drawable.tianjin);
                tvInfo.setText(infoArray[3]);
                btnVisit.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.municipality_tianjin, null)));
                websiteUrl = "https://en.tj.gov.cn/";
                break;
        }

        btnVisit.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            try {
                startActivity(webIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(Municipality.this, "No browser found!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}