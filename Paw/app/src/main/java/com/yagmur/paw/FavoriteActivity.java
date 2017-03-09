package com.yagmur.paw;

import android.os.Bundle;

public class FavoriteActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getMainLayoutID() {
        return R.layout.favoritelist_activity_base;
    }

    @Override
    protected int getMenuTitleResource() {
        return R.string.fave_list_title;

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
