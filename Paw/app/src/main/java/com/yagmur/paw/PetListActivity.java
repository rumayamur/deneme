package com.yagmur.paw;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yagmur.paw.Adapter.PetListAdapter;
import com.yagmur.paw.Model.Dog;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends BaseActivity {
    private Dog dog;
    private List<Dog> dogList = new ArrayList<>();
    private RecyclerView petListRV;
    private PetListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
    }

    private void Init() {
        petListRV = (RecyclerView) findViewById(R.id.petListRecyclerV);
        myAdapter = new PetListAdapter(dogList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        petListRV.setLayoutManager(mLayoutManager);
        petListRV.setItemAnimator(new DefaultItemAnimator());
        petListRV.setAdapter(myAdapter);

        prepareDogData();

    }

    public void fabSearch(View v) {
        Snackbar.make(v, "Search Dialog is going to be here", Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }

    // TODO: OnItemClickListener yapilacak :: PetProfile Activitysi olusturulacak.
//    private void PetListOnItemClick(){
//        petListRV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), PetProfileActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }

    private void prepareDogData() {
        dog = new Dog("1000", 2);
        dogList.add(dog);

        dog = new Dog("1002", 1);
        dogList.add(dog);

        dog = new Dog("1003", 4);
        dogList.add(dog);

        dog = new Dog("1004", 6);
        dogList.add(dog);

        myAdapter.notifyDataSetChanged();
    }

//    Toolbar menu click kontrol:
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected int getMainLayoutID() {
        return R.layout.petlist_activity_base;
    }

    @Override
    protected int getMenuTitleResource() {
        return R.string.pet_list_title;
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
