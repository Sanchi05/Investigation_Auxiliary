package com.example.investigationauxiliary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

    Upload_Data_2[] upload_data;
    Context context;
    public MyAdapter1(Upload_Data_2[] upload_data,Context context){
        this.upload_data = upload_data;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sub_criminal_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Upload_Data_2 upload_data_2 = upload_data[position];
        holder.details.setText(upload_data_2.getImgDetails());
        holder.img_view.setImageResource(upload_data_2.getImg_no());
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
