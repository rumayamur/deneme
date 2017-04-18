package com.yagmur.paw.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yagmur.paw.Model.Dog;
import com.yagmur.paw.PetProfileActivity;
import com.yagmur.paw.R;

import java.util.List;

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.MyViewHolder> {
    private List<Dog> dogList;

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView petID;
        Context context;
        ImageButton likeButton;

        MyViewHolder(View itemView, Context c) {
            super(itemView);
            context = c;
            petID = (TextView) itemView.findViewById(R.id.petId);
            likeButton = (ImageButton) itemView.findViewById(R.id.petLikeButton);
            itemView.setOnClickListener(this);
            likeButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO: like buton görevini ekle!
            switch(v.getId()){
                case R.id.petLikeButton:
                    Toast.makeText(v.getContext(), "item: " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Intent intent = new Intent(context, PetProfileActivity.class);
                    intent.putExtra("DogId", petID.getText());
                    context.startActivity(intent);
            }
        }
    }

    public PetListAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public PetListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.petlist_item, parent, false);
        return new MyViewHolder(itemView, parent.getContext());
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
