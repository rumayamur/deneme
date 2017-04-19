package com.yagmur.paw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DonationActivity extends BaseActivity {
    private TextView temizmama, mamasepeti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
    }

    private void Init() {
        temizmama = (TextView) findViewById(R.id.temizmama);
        mamasepeti = (TextView) findViewById(R.id.mamasepeti);

        temizmama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("TextId", temizmama.getText().toString());
                startActivity(intent);
            }
        });

        mamasepeti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("TextId", mamasepeti.getText().toString());
                startActivity(intent);
            }
        });
    }
// TODO: 19.4.2017 her textview icin onClick eklemek yerine bunu ayri bir method da yap.
//    public void TextViewToWebOnClick(View view){
//        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
//        intent.putExtra("TextId", view.getId());
//        startActivity(intent);
//    }

    @Override
    protected int getMainLayoutID() {
        return R.layout.donation_activity_base;
    }

    @Override
    protected int getMenuTitleResource() {
        return R.string.donation_title;

    }

    @Override
    protected int getMenuLayoutID() {
        return 0;
    }

    @Override
    protected boolean isNavigationDrawerEnabled() {
        return true;
    }
}
