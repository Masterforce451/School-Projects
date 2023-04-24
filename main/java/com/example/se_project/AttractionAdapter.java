package com.example.se_project;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import static com.example.se_project.R.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionAdapterVH> {
    private static List<AttractionLineItem> attractionLineItemList;
    private static AttractionLineItem attractionLineItem;
    private static Context context;
    public AttractionAdapter(List<AttractionLineItem> attractionLineItemList) {
        AttractionAdapter.attractionLineItemList = attractionLineItemList;
    }
    @NonNull
    @Override
    public AttractionAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new AttractionAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_attracrions,null));
    }
    @Override
    public void onBindViewHolder(@NonNull AttractionAdapterVH holder, int position) {
        attractionLineItem = attractionLineItemList.get(position);
        String attractionName = attractionLineItem.getAttractionName();
        Drawable photo_id = attractionLineItem.getPhoto_id();
        holder.attractionName.setText(attractionName);
        holder.photo.setImageDrawable(photo_id);
    }
    @Override
    public int getItemCount() {
        return attractionLineItemList.size();
    }
    public static void enterAttractionPage(View itemview,int pos) {
        Intent intent = new Intent(context,AttractionActivity.class);

        attractionLineItem = attractionLineItemList.get(pos);
        intent.putExtra("attractionObject",attractionLineItem);
        intent.putExtra("position",pos);
        context.startActivity(intent);
    }
    public static class AttractionAdapterVH extends RecyclerView.ViewHolder{
        TextView attractionName;
        ImageView photo;
        public AttractionAdapterVH(@NonNull View itemView) {
            super(itemView);
            attractionName = itemView.findViewById(id.attraction_name);
            photo = itemView.findViewById(id.attractionPhoto_menu);
            photo.setOnClickListener(view -> {
                int pos = getAbsoluteAdapterPosition();
                enterAttractionPage(itemView,pos);
            });
            attractionName.setOnClickListener(view -> {
                int pos = getAbsoluteAdapterPosition();
                enterAttractionPage(itemView,pos);
            });
        }
    }
}