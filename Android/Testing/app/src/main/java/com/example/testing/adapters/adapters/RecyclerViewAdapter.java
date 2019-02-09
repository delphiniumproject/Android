package com.example.testing.adapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testing.activities.AnimeActivity;
import com.example.testing.model.Anime;

import java.util.List;
import com.example.testing.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater= LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.anime_row_item,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategories());
                //i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_date",mData.get(viewHolder.getAdapterPosition()).getDateReleased());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getStudio());
        holder.tv_category.setText(mData.get(position).getCategories());
        holder.tv_date.setText(mData.get(position).getDateReleased());

        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        TextView tv_date;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container=itemView.findViewById(R.id.container);
            tv_name=itemView.findViewById(R.id.anime_name);
            tv_category=itemView.findViewById(R.id.categories);
            tv_rating=itemView.findViewById(R.id.rating);
            tv_studio=itemView.findViewById(R.id.studio);
            img_thumbnail=itemView.findViewById(R.id.thumbnail);
            tv_date=itemView.findViewById(R.id.date);



        }
    }
}
