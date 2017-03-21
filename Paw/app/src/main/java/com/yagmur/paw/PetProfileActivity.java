package com.yagmur.paw;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yagmur.paw.Adapter.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Yagmur on 26.2.2017.''
 */

public class PetProfileActivity extends AppCompatActivity {
    FloatingActionButton likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petprofile);
        Init();
    }

    private void Init() {
        likeButton = (FloatingActionButton) findViewById(R.id.likeButton);
        ViewPager viewpager = (ViewPager) findViewById(R.id.petPhotoVP);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(new ViewPagerAdapter(this));
        indicator.setViewPager(viewpager);
    }

    //TODO: like butonu çalışmıyor. Localde favorilere alınan köpeklerin listesi tutulmalı böylece kontrol etmesi daha kolay bir hale gelir. SQLite kullanabiliriz bunun için.
    public void LikeFabClick(View view){
        likeButton.setBackground(getResources().getDrawable(R.drawable.christmas_star_filled));
    }
}
