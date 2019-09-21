package com.example.workoutapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<WorkoutHolder> {

    Context c;
    ArrayList<WorkoutModel> models;

    public MyAdapter(Context c, ArrayList<WorkoutModel> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public WorkoutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new WorkoutHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutHolder holder, int i) {
        holder.mTitle.setText(models.get(i).getTitle());
        holder.mTitle.setText(models.get(i).getDescription());
        holder.mImageView.setImageResource(models.get(i).getImg());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
