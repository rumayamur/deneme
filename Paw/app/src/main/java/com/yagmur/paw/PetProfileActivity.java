package com.yagmur.paw;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yagmur.paw.Adapter.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Yagmur on 26.2.2017.''
 */

public class PetProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petprofile);
        Init();
    }

    private void Init() {

    }
}
