package com.yagmur.paw.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.yagmur.paw.Model.Dog;
import com.yagmur.paw.R;

import java.util.List;

/**
 * Created by Yagmur on 5.2.2017. ""
 */

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.MyViewHolder> {
    private List<Dog> dogList;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView petID;
        ImageButton likeButton;

        MyViewHolder(View itemView) {
            super(itemView);
            petID = (TextView) itemView.findViewById(R.id.petId);
            likeButton = (ImageButton) itemView.findViewById(R.id.petLikeButton);
        }
    }

    public PetListAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public PetListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.petlist_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PetListAdapter.MyViewHolder holder, int position) {
        Dog dog = dogList.get(position);
        holder.petID.setText(dog.getDogID());
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }
}
