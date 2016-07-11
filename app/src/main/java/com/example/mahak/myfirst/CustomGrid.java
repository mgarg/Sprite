package com.example.mahak.myfirst;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mahak Garg on 11-07-2016.
 */
public class CustomGrid extends BaseAdapter {
    private Context context;
    private int[] imgs;
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public CustomGrid(Context context, int[] imgs) {
        this.context = context;
        this.imgs = imgs;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.gridText);
            final ImageButton imageView = (ImageButton) grid.findViewById(R.id.gridImage);
            textView.setText("Style "+(i+1));
            imageView.setImageResource(imgs[i]);
            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
//                    Intent intent = new Intent(context, CreateNew.class);
//                    context.startActivity(intent);
                    PopupMenu popupMenu = new PopupMenu(context,imageView);
                    popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                    popupMenu.show();
                }
            });
        }
        else {
            grid =  view;
        }

        return grid;
    }
//        return null;

}
