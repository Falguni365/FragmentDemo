package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akshay on 15-03-2018.
 */

class AuthorEventAdapter extends BaseAdapter{
    Context context;
    ArrayList<AuthorEvent> authorAuthorEventsArrayList;
    LayoutInflater inflater;
    public AuthorEventAdapter(Context context, ArrayList<AuthorEvent> authorEventArrayList) {
        this.context = context;
        this.authorAuthorEventsArrayList = authorEventArrayList;
    }

    @Override
    public int getCount() {
        return authorAuthorEventsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return authorAuthorEventsArrayList.get(position);
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
                    inflate(R.layout.layout_list_event_item_bolg, parent, false);
        }

        // get current item to be displayed
        AuthorEvent currentItem = (AuthorEvent) getItem(position);

        // get the TextView for item name and item description
        TextView textViewTitleName = (TextView)
                convertView.findViewById(R.id.eventtithere);

        TextView textViewDescription = (TextView)
                convertView.findViewById(R.id.eventdescriptionhere);

        TextView textViewLocation = (TextView)
                convertView.findViewById(R.id.eventlocationhere);


        //sets the text for item name and item description from the current item object
        textViewTitleName.setText(currentItem.getEventName());
        textViewDescription.setText(currentItem.getEventDescription());
        textViewLocation.setText(currentItem.getEventLocation());

        // returns the view for the current row
        return convertView;

    }
}
