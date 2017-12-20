package com.example.tobias.board;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
//    int [] imageId;
    String [] descrId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(BoardListActivity boardListActivity, String[] prgmNameList, String[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=boardListActivity;
//        imageId=prgmImages;
        descrId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView name;
        TextView description;
        TextView time;
        ImageView img;
    }
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        //rowView = inflater.inflate(R.layout.bored_user_adapter, null);
//        holder.name=(TextView) rowView.findViewById(R.id.nameView);
//        holder.description=(TextView) rowView.findViewById(R.id.descriptionView);
//        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
//        holder.img.setImageResource(imageId[position]);


        rowView = inflater.inflate(R.layout.board_message, null);
        holder.name=(TextView) rowView.findViewById(R.id.message_user);
        holder.description=(TextView) rowView.findViewById(R.id.message_text);
        holder.time=(TextView) rowView.findViewById(R.id.message_time);

        ImageView ic_cam = (ImageView) rowView.findViewById(R.id.ic_cam);

        ic_cam.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked Cam of " +result[position], Toast.LENGTH_SHORT).show();
            }
        });

        holder.name.setText(result[position]);
        holder.description.setText(descrId[position]+" is Bored");
        holder.time.setText(DateFormat.format("HH:mm:ss",new Date()));
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
//                Intent i = new Intent(context,PlayerAccountActivity.class);
//                context.startActivity(i);
            }
        });
        return rowView;
    }
}