package com.guillaumegonnet.recyclerviewrecipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
    public static final String EXTRA_NAME = "com.guillaumegonnet.recyclerviewrecipe.EXTRA.NAME";
    private final LinkedList<String> mRecipeList;
    private final LinkedList<String> mRecipeDetailList;
    private LayoutInflater mInflater;
    private Context mContext;
    private String mCurrentHeader;
    private String mCurrentSubHeader;

    public RecipeAdapter(Context context, LinkedList<String> recipeList,LinkedList<String> recipeDetailList) {
        this.mRecipeList = recipeList;
        this.mRecipeDetailList = recipeDetailList;
        mInflater = LayoutInflater.from(context);
        this.mContext=context;

    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeItemViewHeader;
        public final TextView recipeItemViewSubHeader;

        final RecipeAdapter mAdapter;

        public RecipeViewHolder(@NonNull View itemView, RecipeAdapter adapter) {
            super(itemView);
            recipeItemViewHeader = itemView.findViewById(R.id.recipe_item_header);
            recipeItemViewSubHeader = itemView.findViewById(R.id.recipe_item_subheader);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(),RecipeActivity.class);
            int mPosition = getLayoutPosition();
            String message = mRecipeList.get(mPosition);
            Bundle extra = new Bundle();
            extra.putString(EXTRA_NAME,message);
            intent.putExtras(extra);
            v.getContext().startActivity(intent);

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
        mCurrentHeader = mRecipeList.get(position);
        mCurrentSubHeader = mRecipeDetailList.get(position);

        holder.recipeItemViewHeader.setText(mCurrentHeader);
        holder.recipeItemViewSubHeader.setText(mCurrentSubHeader);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
