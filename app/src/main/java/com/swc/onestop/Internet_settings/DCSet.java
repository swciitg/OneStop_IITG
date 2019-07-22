package com.swc.onestop.Internet_settings;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.swc.onestop.Activities.Internet_settings;
import com.swc.onestop.Activities.Main2Activity;
import com.swc.onestop.R;

public class DCSet extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dcset);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(DCSet.this, Internet_settings.class));
                finish();


            }
        });
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("DC Settings");
    }
}
