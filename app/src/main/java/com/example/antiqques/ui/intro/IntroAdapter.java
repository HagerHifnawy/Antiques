package com.example.antiqques.ui.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antiqques.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {
    private List<IntroScreenItem> introscreenitems;

    public IntroAdapter(List<IntroScreenItem> introscreenitems) {
        this.introscreenitems = introscreenitems;
    }

    @NonNull
    @Override
    public IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IntroViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_intro_screen, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull IntroViewHolder holder, int position) {
        holder.setIntroData(introscreenitems.get(position));
    }

    @Override
    public int getItemCount() {
        return introscreenitems.size();
    }

    class IntroViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private ImageView imageintro;

        public IntroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageintro = itemView.findViewById(R.id.intro1_img);
            title = itemView.findViewById(R.id.intro1_title_tv);
            description = itemView.findViewById(R.id.intro1_desc_tv);


        }

        void setIntroData(IntroScreenItem intro_screen_item) {
            imageintro.setImageResource(intro_screen_item.getScreenImg());
            title.setText(intro_screen_item.getTitle());
            description.setText(intro_screen_item.getDescription());
        }
    }

}