package com.example.softwareprojedeneme2;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AttractionRecyclerViewAdapter extends RecyclerView.Adapter<AttractionRecyclerViewAdapter.AttractionAdapterVH> {
    private static List<AttractionElement> attractionLineItemList;
    private static AttractionElement attractionLineItem;
    private static Context context;
    public AttractionRecyclerViewAdapter(List<AttractionElement> attractionLineItemList) {
        AttractionRecyclerViewAdapter.attractionLineItemList = attractionLineItemList;
    }
    @NonNull
    @Override
    public AttractionAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new AttractionAdapterVH(LayoutInflater.from(context).inflate(R.layout.attraction_recycler_item_layout,null));
    }
    @Override
    public void onBindViewHolder(@NonNull AttractionAdapterVH holder, int position) {
        attractionLineItem = attractionLineItemList.get(position);
        String attractionName = attractionLineItem.getAttractionName();
        Drawable photo_id = attractionLineItem.getPhoto_id();
        String type = attractionLineItem.getType();
        holder.attractionName.setText(attractionName);
        holder.photo.setImageDrawable(photo_id);
        holder.attraction_type.setText(type);

    }
    @Override
    public int getItemCount() {
        return attractionLineItemList.size();
    }
    public static void enterAttractionPage(int pos) {
        Intent intent = new Intent(context,AttractionInfoActivity.class);
        attractionLineItem = attractionLineItemList.get(pos);
        intent.putExtra("attractionObject",attractionLineItem);
        intent.putExtra("position",pos);
        context.startActivity(intent);
    }
    public static class AttractionAdapterVH extends RecyclerView.ViewHolder{
        TextView attractionName,attraction_type;
        ImageView photo;
        public AttractionAdapterVH(@NonNull View itemView) {
            super(itemView);
            attractionName = itemView.findViewById(R.id.attraction_name);
            photo = itemView.findViewById(R.id.attractionPhoto_menu);
            attraction_type = itemView.findViewById(R.id.attraction_type);
            photo.setOnClickListener(view -> {
                int pos = getAdapterPosition();
                enterAttractionPage(pos);
            });
            attractionName.setOnClickListener(view -> {
                int pos = getAdapterPosition();
                enterAttractionPage(pos);
            });
        }

    }
}