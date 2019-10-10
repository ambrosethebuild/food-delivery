package com.wwdevelopers.fooddelivery.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wwdevelopers.fooddelivery.R;
import com.wwdevelopers.fooddelivery.adapters.CategoryAdapter;
import com.wwdevelopers.fooddelivery.adapters.ItemsAdapter;
import com.wwdevelopers.fooddelivery.adapters.SideItemsAdapter;
import com.wwdevelopers.fooddelivery.interfaces.MyRecycleViewClickListener;
import com.wwdevelopers.fooddelivery.models.CategoryModel;
import com.wwdevelopers.fooddelivery.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    NestedScrollView itemListingView;
    RelativeLayout itemFullDetailsView;

    List<CategoryModel> categoryModels;
    List<ItemModel> featuredItemModels;
    List<ItemModel> itemModels;

    RecyclerView categories_recycler_view;
    RecyclerView side_items_recycler_view;
    RecyclerView items_recycler_view;


    TextView item_full_details_name_text_view;
    TextView item_full_details_price_text_view;
    ImageView item_full_details_picture_img;
    TextView item_full_details_description_text_view;


    private CategoryAdapter categoryAdapter;
    private SideItemsAdapter sideItemsAdapter;
    private ItemsAdapter itemsAdapter;

    Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mActivity = HomeActivity.this;

        categories_recycler_view = findViewById(R.id.activity_home_categories_recycler_view);
        side_items_recycler_view = findViewById(R.id.activity_home_side_items_recycler_view);
        items_recycler_view = findViewById(R.id.activity_home_items_recycler_view);

        itemFullDetailsView = findViewById(R.id.itemFullDetailsView);
        itemListingView = findViewById(R.id.itemListingView);

        item_full_details_name_text_view = findViewById(R.id.item_full_details_name_text_view);
        item_full_details_price_text_view = findViewById(R.id.item_full_details_price_text_view);
        item_full_details_picture_img = findViewById(R.id.item_full_details_picture_img);
        item_full_details_description_text_view = findViewById(R.id.item_full_details_description_text_view);

        itemListingView.setVisibility(View.VISIBLE);
        itemFullDetailsView.setVisibility(View.GONE);


        categoryModels = getCategoryModels();
        featuredItemModels = getFeaturedItemModels();
        itemModels = getItemModels();


        categoryAdapter = new CategoryAdapter(mActivity, categoryModels);
        categories_recycler_view.setAdapter(categoryAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        categories_recycler_view.setLayoutManager(linearLayoutManager);
        categories_recycler_view.addOnItemTouchListener(new MyRecycleViewClickListener(this, new MyRecycleViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                categoryAdapter.setSelected(position);
                linearLayoutManager.scrollToPosition(position);
                //DO YOUR ITEM SORTING HERE

            }
        }));



        sideItemsAdapter = new SideItemsAdapter(mActivity, featuredItemModels);
        side_items_recycler_view.setAdapter(sideItemsAdapter);
        final LinearLayoutManager sideItemsLinearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        side_items_recycler_view.setLayoutManager(sideItemsLinearLayoutManager);
        side_items_recycler_view.addOnItemTouchListener(new MyRecycleViewClickListener(this, new MyRecycleViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                sideItemsLinearLayoutManager.scrollToPosition(position);
                //DO YOUR ITEM FULL DETAILS VIEW HERE
                showItemFullDetails((ItemModel) sideItemsAdapter.getItem(position));

            }
        }));


        itemsAdapter = new ItemsAdapter(mActivity, itemModels);
        items_recycler_view.setAdapter(itemsAdapter);
        final LinearLayoutManager itemsLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        items_recycler_view.setLayoutManager(itemsLinearLayoutManager);
        items_recycler_view.addOnItemTouchListener(new MyRecycleViewClickListener(this, new MyRecycleViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                itemsLinearLayoutManager.scrollToPosition(position);
                //DO YOUR ITEM FULL DETAILS VIEW HERE
                showItemFullDetails((ItemModel) itemsAdapter.getItem(position));

            }
        }));

    }



    private void showItemFullDetails(ItemModel selectedItemModel) {

        itemFullDetailsView.setVisibility(View.VISIBLE);
        itemListingView.setVisibility(View.GONE);


        item_full_details_description_text_view.setText(selectedItemModel.getDescription());
        item_full_details_name_text_view.setText(selectedItemModel.getName());
        item_full_details_price_text_view.setText(selectedItemModel.getPrice());

        Picasso.get().load(selectedItemModel.getPicture_url()).placeholder(mActivity.getResources().getDrawable(R.drawable.logo)).into(item_full_details_picture_img);


    }

    private List<ItemModel> getFeaturedItemModels() {

        featuredItemModels = new ArrayList<>();
        ItemModel featuredItemModel = new ItemModel();
        featuredItemModel.setCategory_id("1");
        featuredItemModel.setItem_id("1");
        featuredItemModel.setName("Burger");
        featuredItemModel.setPrice("₵24");
        featuredItemModel.setPicture_url("https://www.modernhoney.com/wp-content/uploads/2016/05/DSC_0127ed2.jpg");
        featuredItemModel.setDescription("Remove the burgers from the bags and place them on a paper towel–lined plate. Pat dry very carefully on both sides and season with additional salt and pepper. Let the burgers rest at room temperature for 10 minutes to dry their exteriors. Before searing the burgers, have your toasted buns and condiments ready to accept them. Heat the oil in a large cast iron or stainless steel skillet over high heat until lightly smoking. Add the burger patties and cook, without moving, until just browned, about 1 minute.");
        featuredItemModels.add(featuredItemModel);

        featuredItemModel = new ItemModel();
        featuredItemModel.setCategory_id("1");
        featuredItemModel.setItem_id("2");
        featuredItemModel.setName("Pizza");
        featuredItemModel.setPrice("₵54");
        featuredItemModel.setPicture_url("https://www.washingtonpost.com/resizer/M-WnldvRmvg3qyWg0Om8ssM6E3M=/1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/UM4VXMMJ5Y7T5MPQALWPL73RGM.jpg");
        featuredItemModel.setDescription("Turn onto floured surface; knead until smooth and elastic, about 2-3 minutes. Place in a greased bowl, turning once to grease the top. Cover and let rise in a warm place until doubled, about 45 minutes. Meanwhile, cook beef and onion over medium heat until no longer pink; drain.");
        featuredItemModels.add(featuredItemModel);

        featuredItemModel = new ItemModel();
        featuredItemModel.setCategory_id("1");
        featuredItemModel.setItem_id("3");
        featuredItemModel.setName("Donut");
        featuredItemModel.setPrice("₵12");
        featuredItemModel.setPicture_url("https://www.crunchycreamysweet.com/wp-content/uploads/2016/02/chocolate-donuts-1.jpg");
        featuredItemModel.setDescription("While cake donuts are traditionally fried, they're just as delicious baked in the oven, with far less cleanup. Toss in powdered sugar or finish with a simple glaze and sprinkles or toasted coconut -- you can't go wrong! ");
        featuredItemModels.add(featuredItemModel);

        featuredItemModel = new ItemModel();
        featuredItemModel.setCategory_id("1");
        featuredItemModel.setItem_id("4");
        featuredItemModel.setName("Cake");
        featuredItemModel.setPrice("₵57");
        featuredItemModel.setPicture_url("https://www.giverecipe.com/wp-content/uploads/2016/05/strawberry-chocolate-cake-1.jpg");
        featuredItemModel.setDescription("Black Forest cake has multiple layers of chocolate sponge, cherries, and whipped cream. It is frosted with whipped cream and covered with chocolate shavings and a few cherries for decoration.");
        featuredItemModels.add(featuredItemModel);



        return featuredItemModels;

    }

    private List<ItemModel> getItemModels() {

        itemModels = new ArrayList<>();
        ItemModel itemModel = new ItemModel();
        itemModel.setCategory_id("1");
        itemModel.setItem_id("1");
        itemModel.setName("Burger");
        itemModel.setPrice("₵24");
        itemModel.setPicture_url("https://www.modernhoney.com/wp-content/uploads/2016/05/DSC_0127ed2.jpg");
        itemModel.setDescription("Remove the burgers from the bags and place them on a paper towel–lined plate. Pat dry very carefully on both sides and season with additional salt and pepper. Let the burgers rest at room temperature for 10 minutes to dry their exteriors. Before searing the burgers, have your toasted buns and condiments ready to accept them. Heat the oil in a large cast iron or stainless steel skillet over high heat until lightly smoking. Add the burger patties and cook, without moving, until just browned, about 1 minute.");
        itemModels.add(itemModel);

        itemModel = new ItemModel();
        itemModel.setCategory_id("1");
        itemModel.setItem_id("2");
        itemModel.setName("Pizza");
        itemModel.setPrice("₵54");
        itemModel.setPicture_url("https://www.washingtonpost.com/resizer/M-WnldvRmvg3qyWg0Om8ssM6E3M=/1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/UM4VXMMJ5Y7T5MPQALWPL73RGM.jpg");
        itemModel.setDescription("Turn onto floured surface; knead until smooth and elastic, about 2-3 minutes. Place in a greased bowl, turning once to grease the top. Cover and let rise in a warm place until doubled, about 45 minutes. Meanwhile, cook beef and onion over medium heat until no longer pink; drain.");
        itemModels.add(itemModel);

        itemModel = new ItemModel();
        itemModel.setCategory_id("1");
        itemModel.setItem_id("3");
        itemModel.setName("Donut");
        itemModel.setPrice("₵12");
        itemModel.setPicture_url("https://www.crunchycreamysweet.com/wp-content/uploads/2016/02/chocolate-donuts-1.jpg");
        itemModel.setDescription("While cake donuts are traditionally fried, they're just as delicious baked in the oven, with far less cleanup. Toss in powdered sugar or finish with a simple glaze and sprinkles or toasted coconut -- you can't go wrong! ");
        itemModels.add(itemModel);

        itemModel = new ItemModel();
        itemModel.setCategory_id("1");
        itemModel.setItem_id("4");
        itemModel.setName("Cake");
        itemModel.setPrice("₵57");
        itemModel.setPicture_url("https://www.giverecipe.com/wp-content/uploads/2016/05/strawberry-chocolate-cake-1.jpg");
        itemModel.setDescription("Black Forest cake has multiple layers of chocolate sponge, cherries, and whipped cream. It is frosted with whipped cream and covered with chocolate shavings and a few cherries for decoration.");
        itemModels.add(itemModel);



        return itemModels;
    }

    private List<CategoryModel> getCategoryModels() {

        categoryModels = new ArrayList<>();
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategory_id("1");
        categoryModel.setName("FEATURED");
        categoryModel.setSelected(true);
        categoryModels.add(categoryModel);

        categoryModel = new CategoryModel();
        categoryModel.setCategory_id("2");
        categoryModel.setName("COMBOS");
        categoryModels.add(categoryModel);

        categoryModel = new CategoryModel();
        categoryModel.setCategory_id("3");
        categoryModel.setName("FAVORITES");
        categoryModels.add(categoryModel);

        categoryModel = new CategoryModel();
        categoryModel.setCategory_id("4");
        categoryModel.setName("DRINKS");
        categoryModels.add(categoryModel);

        categoryModel = new CategoryModel();
        categoryModel.setCategory_id("5");
        categoryModel.setName("DOUGHS");
        categoryModels.add(categoryModel);
        return categoryModels;

    }


    @Override
    public void onBackPressed() {

        if(itemFullDetailsView.getVisibility() == View.VISIBLE){

            itemListingView.setVisibility(View.VISIBLE);
            itemFullDetailsView.setVisibility(View.GONE);

        }else{

            finishAffinity();
            super.onBackPressed();

        }

    }


}
