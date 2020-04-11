package com.guillaumegonnet.recyclerviewrecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

/**
 * Created by Guillaume Gonnet on 10/04/20.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private final LinkedList<String> mRecipeList;
    private LayoutInflater mInflater;

    public RecipeAdapter(Context context, LinkedList<String> recipeList) {
        this.mRecipeList = recipeList;
        mInflater = LayoutInflater.from(context);
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeItemView;
        final RecipeAdapter mAdapter;

        public RecipeViewHolder(@NonNull View itemView, RecipeAdapter adapter) {
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.recipe_item_header);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item,parent,false);

        return new RecipeViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder holder, int position) {
        String mCurrent = mRecipeList.get(position);
        holder.recipeItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
