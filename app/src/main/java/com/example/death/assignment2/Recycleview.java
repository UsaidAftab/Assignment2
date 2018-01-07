package com.example.death.assignment2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Death on 10/17/2017.
 */

public class Recycleview extends RecyclerView.Adapter<Recycleview.ViewHolder>
{
    View view;
    private List<Detail> list;
    static int count=1;
    Context context;
    public Recycleview(List<Detail> list, Context context)
    {
        this.list=list;this.context=context;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,name1;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.listimg);
            name= (TextView) itemView.findViewById(R.id.txtview1);
            name1=(TextView) itemView.findViewById(R.id.txtview2);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Detail contact=list.get(position);
        holder.name.setText(contact.getFullname());
        holder.name1.setText(contact.getId());
        Picasso.with(context).load("https://www.gstatic.com/webp/gallery3/"+count+".sm.png").resize(150,150).centerCrop().into(holder.imageView);
        count++;
        if(count>5)
        {
            count=1;
        }
    }

    @Override
    public int getItemCount()
    {
        int size=list.size();
        return size;
    }


}