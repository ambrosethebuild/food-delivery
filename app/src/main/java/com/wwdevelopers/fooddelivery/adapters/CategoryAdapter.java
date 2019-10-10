package com.wwdevelopers.fooddelivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wwdevelopers.fooddelivery.R;
import com.wwdevelopers.fooddelivery.models.CategoryModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<CategoryModel> categoryModelList;
    private int previousSelectedPosition = 0;



    public CategoryAdapter(Context ctx, List<CategoryModel> categoryModelList){

            inflater = LayoutInflater.from(ctx);
            this.mContext = ctx;
            this.categoryModelList = categoryModelList;

    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.category_recycler_item, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;

    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {

            holder.category_name.setText(categoryModelList.get(position).getName());

            if(categoryModelList.get(position).isSelected()){
                holder.category_name.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
            }else{
                holder.category_name.setTextColor(mContext.getResources().getColor(R.color.colorLightGrey));
            }

    }

    @Override
    public int getItemCount() {
            return categoryModelList.size();
    }

    public void setSelected(int position) {

        if(this.previousSelectedPosition != position){

            this.categoryModelList.get(previousSelectedPosition).setSelected(false);
            this.categoryModelList.get(position).setSelected(true);
            this.previousSelectedPosition = position;
            notifyDataSetChanged();

        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView category_name;

        public MyViewHolder(View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);
        }

    }







}
