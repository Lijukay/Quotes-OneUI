package com.lijukay.quotes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ToolbarLayout toolbarLayoutAbout = findViewById(R.id.toolbar_about);

        toolbarLayoutAbout.setNavigationButtonAsBack();

        //Create a String with the current name of the App-Version
        String versionName = BuildConfig.VERSION_NAME;
        toolbarLayoutAbout.setExpandedSubtitle(versionName);

        ImageView telegram = findViewById(R.id.telegram_logo);
        telegram.setOnClickListener(view -> {
            Uri uriT = Uri.parse("https://t.me/Lijukay");
            Intent intentT = new Intent(Intent.ACTION_VIEW, uriT);
            startActivity(intentT);
        });
        ImageView github = findViewById(R.id.github_logo);
        github.setOnClickListener(view -> {
            Uri uriG = Uri.parse("https://github.com/Lijukay");
            Intent intentG = new Intent(Intent.ACTION_VIEW, uriG);
            startActivity(intentG);
        });
    }
}