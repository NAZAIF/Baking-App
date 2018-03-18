package com.example.android.bakingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nazaif on 17/3/18.
 */

public class RecipeDetailAdapter extends RecyclerView.Adapter<RecipeDetailAdapter.RecyclerViewHolder> {

    List<Steps> steps;
    private String recipeName;
    final private ListItemClickListener clickListener;

    public RecipeDetailAdapter(ListItemClickListener listener) {
        this.clickListener = listener;
    }


    public void setMasterRecipeData(List<Recipes> recipesIn, Context context) {
        steps = recipesIn.get(0).getSteps();
        recipeName = recipesIn.get(0).getName();
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClick(List<Steps> stepsOut, int clickedItemIndex, String recipeName);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.recipe_detail_cardview_items;
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.textRecyclerView.setText(steps.get(position).getId() + ". " + steps.get(position).getShortDescription());
    }

    @Override
    public int getItemCount() {
        return steps != null ? steps.size() : 0;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textRecyclerView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textRecyclerView = (TextView) itemView.findViewById(R.id.shortDescription);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onListItemClick(steps, getAdapterPosition(), recipeName);
        }
    }
}
