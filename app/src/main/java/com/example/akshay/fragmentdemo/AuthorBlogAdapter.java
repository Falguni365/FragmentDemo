package com.example.akshay.fragmentdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Akshay on 15-03-2018.
 */

class AuthorBlogAdapter extends BaseAdapter {


    Context context;
    ArrayList<AuthorBlog> authorBlogArrayList;
    LayoutInflater inflater;

    public AuthorBlogAdapter(Context context, ArrayList<AuthorBlog> authorBlogArrayList) {
        this.context = context;
        this.authorBlogArrayList = authorBlogArrayList;
    }

    @Override
    public int getCount() {
        return authorBlogArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return authorBlogArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_list_item_bolg, parent, false);
        }

        // get current item to be displayed
        AuthorBlog currentItem = (AuthorBlog) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.tv_blog_name);

        TextView textViewBlogerName = (TextView)
                convertView.findViewById(R.id.blogername);




        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getBlog());
        textViewBlogerName.setText(currentItem.getEmailID());

        // returns the view for the current row
        return convertView;

    }


}
