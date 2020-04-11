package com.guillaumegonnet.recyclerviewrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivity extends AppCompatActivity {
    private ImageView mImageView;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mTextView=findViewById(R.id.recipe_recipe);
        mImageView=findViewById(R.id.recipe_image);

        //get message from Intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String recipe = extras.getString(RecipeAdapter.EXTRA_NAME);

        switch (recipe) {
            case "Pate a Crepe":
                mTextView.setText("Ingredients: 500g de farine");
                break;
            case "Canard à l'orange":
                mTextView.setText("Ingredients: du canard et de l'orange");
                break;
            case "Boeuf Bourguignon":
                mTextView.setText("Ingredients: du boeuf et des carottes");
                break;
            default:
                mTextView.setText("pas de recette");
                break;
        }


    }
}
