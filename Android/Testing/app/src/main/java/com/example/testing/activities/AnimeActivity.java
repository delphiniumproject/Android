package com.example.testing.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testing.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);


        getSupportActionBar().hide();


        String name =getIntent().getExtras().getString("anime_name");
        String description=getIntent().getExtras().getString("anime_description");
        String studio=getIntent().getExtras().getString("anime_studio");
        String category=getIntent().getExtras().getString("anime_category");
        String rating=getIntent().getExtras().getString("anime_rating");
//        int nb_episode=getIntent().getExtras().getInt("nime_nb_episode");
        String date=getIntent().getExtras().getString("anime_date");
        String image_url=getIntent().getExtras().getString("anime_img");

        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name=findViewById(R.id.aa_anime_name);
        TextView tv_studio=findViewById(R.id.aa_studio);
        TextView tv_categories=findViewById(R.id.aa_categories);
        TextView tv_description=findViewById(R.id.aa_description);
        TextView tv_rating=findViewById(R.id.aa_rating);
        TextView tv_date=findViewById(R.id.aa_date);
        ImageView img=findViewById(R.id.aa_thumbnail);

        tv_name.setText(name);
        tv_studio.setText(studio);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_categories.setText(category);
        tv_date.setText(date);


        RequestOptions requestOptions=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape);


        Glide.with(this).load(image_url).apply(requestOptions).into(img);
    }
}
