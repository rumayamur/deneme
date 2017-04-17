package com.yagmur.paw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.ViewAnimator;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutUsActivity extends BaseActivity implements OnMapReadyCallback {
    private EditText phone;
    private GoogleMap map;
    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        phone = (EditText) findViewById(R.id.phone);

//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        ((PawMaps) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);

        scrollView = (NestedScrollView) findViewById(R.id.content_base);

        ((PawMaps) getSupportFragmentManager().findFragmentById(R.id.map)).setListener(new PawMaps.OnTouchListener() {
            @Override
            public void onTouch() {
                scrollView.requestDisallowInterceptTouchEvent(true);
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        this.map = map;
        LatLng shelter = new LatLng(38.853335, 27.036634);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(shelter, 15));

        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("Çaltıdere Köyü, Aliağa/İzmir")
                .position(shelter));
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
