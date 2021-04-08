package com.example.investigationauxiliary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Upload_Data_1[] upload_data;
    Context context;
    public MyAdapter(Upload_Data_1[] upload_data,Context context){
        this.upload_data = upload_data;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sub_missing_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Upload_Data_1 upload_data1 = upload_data[position];
        holder.details.setText(upload_data1.getImgDetails());
        holder.img_view.setImageResource(upload_data1.getImg_no());
    }

    @Override
    public int getItemCount() {
        return upload_data.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView details;
        ImageView img_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            details = itemView.findViewById(R.id.textView);
            img_view = itemView.findViewById(R.id.imageView);
        }
    }


}
