package com.yagmur.paw;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ViewAnimator;

public class AboutUsActivity extends BaseActivity {
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phone = (EditText) findViewById(R.id.phone);
    }

    public void phoneOnClick(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+" + phone.getText().toString().trim()));
        startActivity(callIntent);
    }

    @Override
    protected int getMainLayoutID() {
        return R.layout.aboutus_activity_base;
    }

    @Override
    protected int getMenuTitleResource() {
        return R.string.aboutUs_title;
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
