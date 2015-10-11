package com.example.purvesh.hack_fb;

/**
 * Created by Purvesh on 8/25/2015.
 */
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.purvesh.hack_fb.FriendsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomAdapter extends BaseAdapter{
    FriendsActivity context;
    public ArrayList<GridViewElem> gridViewElems;
    int m_count;
    String[] m_friendNames;
    public CustomAdapter(FriendsActivity mainActivity, int count, String[] friendNames) {
        // TODO Auto-generated constructor stub
        context=mainActivity;
        m_count = count;
        gridViewElems = new ArrayList<GridViewElem>(count);
        m_friendNames = friendNames;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return m_count;
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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        GridView gv = (GridView) context.findViewById(R.id.friendsGrid);
        GridViewElem gridElemView;
        if(gridViewElems.toArray().length < (position + 1)) {
            gridElemView = new GridViewElem(context, position,m_friendNames[position]);
            gridElemView.init();
            gridViewElems.add(gridElemView);
        } else {
            gridElemView = gridViewElems.get(position);
        }
//        rowView.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                ImageView img = (ImageView) v.findViewById(R.id.imageView1);
//                img.setImageResource(R.drawable.green_bg);
                //    Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
//            }
//        });
        return gridElemView.getView();
    }

    public void reset() {
        for(int i = 0; i < gridViewElems.toArray().length; i++) {
            gridViewElems.get(i).reset();
        }
    }
}