package com.example.myapplicationrv.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrv.R;
import com.example.myapplicationrv.models.Data;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.myViewHolder> {

    private ArrayList<Data> arr;

    public CustomeAdapter(ArrayList<Data> arr) {
        this.arr = arr;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        TextView username;
        TextView nameVersion;
        ImageView imageViewItem;

        public myViewHolder ( View itemView){
            super(itemView);
           username = itemView.findViewById(R.id.textName);
           nameVersion = itemView.findViewById(R.id.textVer);
           imageViewItem = itemView.findViewById(R.id.imageView);

           itemView.setOnClickListener(v-> {
               int position = getAdapterPosition();

               if(position != RecyclerView.NO_POSITION){
                   String itemName = arr.get(position).getName();
                   Toast.makeText(itemView.getContext(),"Clicked on " + itemName, Toast.LENGTH_SHORT).show();
               }
           });
        }

    }

    public void setFilteredList(ArrayList<Data> filteredList){
        this.arr = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomeAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview , parent , false ) ;

        myViewHolder MyViewHolder = new myViewHolder(view);

       return MyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.myViewHolder holder, int position) {

        holder.username.setText(arr.get(position).getName());
        holder.nameVersion.setText(arr.get(position).getVersion());
        holder.imageViewItem.setImageResource(arr.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}