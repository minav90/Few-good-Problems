package com.example.purvesh.hack_fb;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Purvesh on 8/27/2015.
 */
public class GridViewElem extends Object {
    private static final String SLOT_NUM = "slotNum";
    View elemView;
    private ImageView friendImg;
    private TextView friendName;
    FriendsActivity context;
    int m_slotNum;
    String m_friendName;

    private static LayoutInflater inflater=null;

    public GridViewElem(FriendsActivity a_context, int a_slotNum, String friendName) {
        context = a_context;
        m_slotNum = a_slotNum + 1;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        elemView = inflater.inflate(R.layout.friend_slot, null);
        m_friendName = friendName;
    }

    public int getSlotNum() {
        return m_slotNum;
    }

    public View getView() {
        return elemView;
    }

    public void init() {
        friendName = (TextView) elemView.findViewById(R.id.friendName);
        friendImg = (ImageView) elemView.findViewById(R.id.friendPic);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        GridView gv = (GridView) context.findViewById(R.id.friendsGrid);
        friendName.setText(m_friendName);
    }

    public void reset() {

    }
}
