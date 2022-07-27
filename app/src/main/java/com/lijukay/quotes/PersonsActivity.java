package com.lijukay.quotes;


import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;


import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class PersonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persons_activity);

        ToolbarLayout toolbarLayout = findViewById(R.id.toolbar_persons);
        toolbarLayout.setNavigationButtonAsBack();
        toolbarLayout.getAppBarLayout().addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            final int totalScrollRange = appBarLayout.getTotalScrollRange();
            FrameLayout content = findViewById(dev.oneuiproject.oneui.R.id.main_content);
            if (content != null) {
                content.setTranslationY(((float) (Math.abs(verticalOffset) - totalScrollRange)) / 2.0f);
            }
        });
    }
}
