package com.yagmur.paw;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yagmur.paw.Adapter.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Yagmur on 26.2.2017.''
 */

public class PetProfileActivity extends AppCompatActivity {
    private FloatingActionButton likeButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petprofile);
        Init();
    }

    private void Init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle(getIntent().getExtras().getString("urun", "Ürün"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //statusbar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        //Image View Pager:
        likeButton = (FloatingActionButton) findViewById(R.id.likeButton);
        ViewPager viewpager = (ViewPager) findViewById(R.id.petPhotoVP);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(new ViewPagerAdapter(this));
        indicator.setViewPager(viewpager);
    }

    //TODO: like butonu çalışmıyor. Localde favorilere alınan köpeklerin listesi tutulmalı böylece kontrol etmesi daha kolay bir hale gelir. SQLite kullanabiliriz bunun için.
    public void LikeFabClick(View view) {
        likeButton.setBackground(getResources().getDrawable(R.drawable.christmas_star_filled));
    }
}
