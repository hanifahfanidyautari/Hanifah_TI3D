package com.example.windows10.yukmasak;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Windows 10 on 17-Dec-18.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //deklarasi global objek
    private ArrayList<DataModel> dataModelArrayList; //deklarasi arraylist dari extends recyclerview
    private Activity activity;

    //condtructor dataadapter
    public DataAdapter(Activity activity, ArrayList<DataModel> dataModelArrayList) {
        this.activity = activity;
        this.dataModelArrayList = dataModelArrayList;
        //auto memanggil arraylist saat data adapter berjalan
    }

    @Override //override meythod dari hasil extends recyclerview, untuk menempatkan posisi header dan item
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch(viewType){
            case 1:{
                View v = inflater.inflate(R.layout.list_item, parent, false);
                viewHolder = new ItemHolder(v);
                break;
            }
            case 2:{
                View v = inflater.inflate(R.layout.list_header, parent, false);
                viewHolder = new HeaderHolder(v);
                break;
            }
        }
        return viewHolder;
    }

    //method untuk menampilkan judul maskakan pada tiap item
    public static class ItemHolder extends RecyclerView.ViewHolder {
        public TextView txtJudul;
        public ItemHolder(View view) {
            super(view);
            txtJudul = (TextView) view.findViewById(R.id.txtJudul);
        }
    }


    public static class HeaderHolder extends RecyclerView.ViewHolder {
        public HeaderHolder(View view) {
            super(view);
        }
    }
    /*public static class FooterHolder extends RecyclerView.ViewHolder {
        public FooterHolder(View view) {
            super(view);
        }
    }*/

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        switch(getItem(position).getViewType()){
            case 1:{
                ItemHolder holder = (ItemHolder) viewHolder;
                holder.txtJudul.setText(getItem(position).getJudul());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent intent = new Intent(activity, DetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("dataModel", getItem(position));
                        intent.putExtras(bundle);
                        activity.startActivity(intent);
                    }
                });

                break;
            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        return dataModelArrayList.get(position).getViewType();
    }


    public DataModel getItem(int position) {
        return dataModelArrayList.get(position);
    }


    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

}

