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

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<ItemModel> itemModels;


    public ItemsAdapter(Context ctx, List<ItemModel> itemModels){

        inflater = LayoutInflater.from(ctx);
        this.mContext = ctx;
        this.itemModels = itemModels;

    }

    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_recycler_item, parent, false);
        ItemsAdapter.MyViewHolder holder = new ItemsAdapter.MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ItemsAdapter.MyViewHolder holder, int position) {

        holder.item_name.setText(itemModels.get(position).getName());
        holder.item_price.setText(itemModels.get(position).getPrice());
        holder.item_description.setText(itemModels.get(position).getDescription());

        //holder.item_picture.getDrawable().
        Picasso.get()
                .load(itemModels.get(position).getPicture_url())
                .placeholder(mContext.getResources().getDrawable(R.drawable.logo))
                .into(holder.item_picture);

    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public Object getItem(int position) {
        return this.itemModels.get(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView item_name;
        TextView item_price;
        TextView item_description;
        ImageView item_picture;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_description = itemView.findViewById(R.id.item_description);
            item_picture = itemView.findViewById(R.id.item_picture);

        }

    }







}
