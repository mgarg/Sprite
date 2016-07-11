package com.example.mahak.myfirst;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mahak Garg on 11-07-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private MyItem[] mDataset;
    private Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout linearLayout;

        public ViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(MyItem[] myDataset,Context context)
    {
        this.context = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        TextView name = (TextView) holder.linearLayout.findViewById(R.id.name);
        TextView limit = (TextView) holder.linearLayout.findViewById(R.id.limit);
//        GridView grid = (GridView) holder.linearLayout.findViewById(R.id.)

        String limitText = "1-"+mDataset[position].limit+" images";
        name.setText(mDataset[position].name);

        limit.setText(limitText);


        GridView gridView = (GridView) holder.linearLayout.findViewById(R.id.grid);

        gridView.setAdapter(new CustomGrid(context, mDataset[position].imgs));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        ((TextView) v.findViewById(R.id.grid_item_label))
//                                .getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}