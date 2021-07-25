package com.example.footballeur;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Footballeur> footballeurList;
    Context context;

    public RecyclerViewAdapter(List<Footballeur> footballeurList, Context context) {
        this.footballeurList = footballeurList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_footballeur, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tv_footName.setText(footballeurList.get(position).getNom());
        holder.tv_footDatenaissance.setText(String.valueOf(footballeurList.get(position).getDateNaissance()));
        Glide.with(this.context).load(footballeurList.get(position).getImageURl()).into(holder.iv_footPicture);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send the control to the EditOneitem activity
                Intent intent = new Intent(context, AddEditOne.class);
                intent.putExtra("id", footballeurList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return footballeurList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_footPicture;
        TextView tv_footName;
        TextView tv_footDatenaissance;
        ConstraintLayout parentLayout;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            iv_footPicture = itemView.findViewById(R.id.iv_footballeurpicture);
            tv_footDatenaissance = itemView.findViewById(R.id.tv_dateNaissance);
            tv_footName = itemView.findViewById(R.id.tv_footName);
            parentLayout = itemView.findViewById(R.id.oneLineFootballeurLayout);
        }
    }
}

