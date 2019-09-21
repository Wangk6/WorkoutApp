package com.example.workoutapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mTitle, mDesc;
    public WorkoutHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView = itemView.findViewById(R.id.cardImageView);
        this.mTitle = itemView.findViewById(R.id.cardTitle);
        this.mDesc = itemView.findViewById(R.id.cardDescription);
    }
}
