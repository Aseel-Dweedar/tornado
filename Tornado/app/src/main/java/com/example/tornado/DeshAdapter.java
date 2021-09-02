package com.example.tornado;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DeshAdapter extends RecyclerView.Adapter<DeshAdapter.DeshViewHolder> {

    // a list to bind data
    List<Desh> DeshesList = new ArrayList<Desh>();

    public DeshAdapter(List<Desh> DeshesList) {
        this.DeshesList = DeshesList;
    }

    // DeshViewHolder to Wraps the view
    public static class DeshViewHolder extends RecyclerView.ViewHolder {
        public Desh desh;
        View itemView;

        public DeshViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            // add on click listener on the views to send the clicked data to details page and redirect to the page
            itemView.setOnClickListener((view -> {
                Intent goToDetails = new Intent(view.getContext(), DeshDetails.class);
                goToDetails.putExtra("dishName", desh.dishName);
                goToDetails.putExtra("price", desh.price);
                goToDetails.putExtra("ingredients", desh.ingredients);
                view.getContext().startActivity(goToDetails);
            }));
        }
    }

    @NonNull
    @NotNull
    @Override
    public DeshViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_desh, parent, false);
        DeshViewHolder deshViewHolder = new DeshViewHolder(view);
        return deshViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DeshViewHolder holder, int position) {
        holder.desh = DeshesList.get(position);
        TextView dishName = holder.itemView.findViewById(R.id.nameInFrag);
        TextView price = holder.itemView.findViewById(R.id.priceInFrag);
        dishName.setText(holder.desh.dishName);
        price.setText(holder.desh.price);
    }

    @Override
    public int getItemCount() {
        return DeshesList.size();
    }


}
