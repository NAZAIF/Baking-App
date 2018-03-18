package com.example.android.bakingapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nazaif on 17/3/18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecyclerViewHolder> {

    ArrayList<Recipes> recipes;
    Context mContext;
    final private ListItemClickListener clickListener;

    public RecipeAdapter(ListItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setRecipeData(ArrayList<Recipes> recipesIn,Context context){
        recipes = recipesIn;
        mContext = context;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener{
        void onListItemClick(Recipes index);
    }
    @Override
    public RecipeAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.recipe_cardview_items;
        View view = LayoutInflater.from(context).inflate(layoutId,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeAdapter.RecyclerViewHolder holder, int position) {
        holder.textRecyclerView.setText(recipes.get(position).getName());
        String imageUrl = recipes.get(position).getImage();
        if (imageUrl != ""){
            Uri builtUri = Uri.parse(imageUrl).buildUpon().build();
            Picasso.with(mContext).load(builtUri).into(holder.imageRecyclerView);
        }
    }

    @Override
    public int getItemCount() {
        return recipes != null ? recipes.size():0;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textRecyclerView;
        ImageView imageRecyclerView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textRecyclerView = (TextView) itemView.findViewById(R.id.title);
            imageRecyclerView = (ImageView) itemView.findViewById(R.id.recipeImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onListItemClick(recipes.get(getAdapterPosition()));
        }
    }
}
