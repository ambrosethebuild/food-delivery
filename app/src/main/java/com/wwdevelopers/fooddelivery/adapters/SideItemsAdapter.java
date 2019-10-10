package com.wwdevelopers.fooddelivery.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;
import com.wwdevelopers.fooddelivery.R;
import com.wwdevelopers.fooddelivery.models.ItemModel;

import java.util.List;

public class SideItemsAdapter extends RecyclerView.Adapter<SideItemsAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<ItemModel> featuredItemModels;
    private int previousSelectedPosition = 0;



    public SideItemsAdapter(Context ctx, List<ItemModel> featuredItemModels){

        inflater = LayoutInflater.from(ctx);
        this.mContext = ctx;
        this.featuredItemModels = featuredItemModels;

    }

    @Override
    public SideItemsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.side_item_recycler_item, parent, false);
        SideItemsAdapter.MyViewHolder holder = new SideItemsAdapter.MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final SideItemsAdapter.MyViewHolder holder, int position) {

        holder.item_name.setText(featuredItemModels.get(position).getName());
        holder.item_price.setText(featuredItemModels.get(position).getPrice());

        Bitmap bitmap =((BitmapDrawable)holder.item_picture.getDrawable()).getBitmap();
        Palette palette = Palette.from(bitmap).generate();
        holder.item_background_card_view.setCardBackgroundColor(palette.getLightVibrantColor(mContext.getResources().getColor(R.color.colorAccent)));
        holder.item_name.setTextColor(palette.getVibrantSwatch().getTitleTextColor());
        holder.item_price.setTextColor(palette.getVibrantSwatch().getBodyTextColor());


        //holder.item_picture.getDrawable().
        Picasso.get()
                .load(featuredItemModels.get(position).getPicture_url())
                .placeholder(mContext.getResources().getDrawable(R.drawable.logo))
                .into(holder.item_picture, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                        Bitmap bitmap =((BitmapDrawable) holder.item_picture.getDrawable()).getBitmap();
                        Palette palette = Palette.from(bitmap).generate();
                        holder.item_background_card_view.setCardBackgroundColor(palette.getLightVibrantColor(mContext.getResources().getColor(R.color.colorAccent)));

                        holder.item_name.setTextColor(palette.getVibrantSwatch().getTitleTextColor());
                        holder.item_price.setTextColor(palette.getVibrantSwatch().getBodyTextColor());

                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });

    }

    @Override
    public int getItemCount() {
        return featuredItemModels.size();
    }

    public Object getItem(int position) {
        return this.featuredItemModels.get(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView item_name;
        TextView item_price;
        ImageView item_picture;
        MaterialCardView item_background_card_view;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_picture = itemView.findViewById(R.id.item_picture);
            item_background_card_view = itemView.findViewById(R.id.item_background_card_view);

        }

    }







}
