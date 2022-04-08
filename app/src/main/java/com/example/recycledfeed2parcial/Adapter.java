package com.example.recycledfeed2parcial;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<elemento> mLista;

    public Adapter (Context context,ArrayList<elemento> lista){
        mContext=context;
        mLista=lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.elemento2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        elemento actual=mLista.get(position);
        String name= actual.getmName();
        String year= actual.getmYear();
        String lengu= actual.getmLengu();
        String dir= actual.getmDirector();

        holder.mName.setText(name);
        holder.mYear.setText(year);
        holder.mDirector.setText(dir);
        holder.mLengu.setText(lengu);
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mName;
        public TextView mYear;
        public TextView mDirector;
        public TextView mLengu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName= itemView.findViewById(R.id.NombrePe);
            mYear= itemView.findViewById(R.id.Year);
            mDirector= itemView.findViewById(R.id.Dir);
            mLengu=itemView.findViewById(R.id.Lengu);
        }
    }
}