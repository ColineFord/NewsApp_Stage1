package com.example.android.newsapp_stage1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Coline on 26/03/2018.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Create a new {@link NewsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param news is the list of {@link News}s to be displayed.
     */
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the article at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID magnitude
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);

        // Get the original tag string from the News object
        String originalTag = currentNews.getmNewsTag();

        // Find the TextView with view ID place
        TextView tagTextView = (TextView) listItemView.findViewById(R.id.tag);
        // Display the tag of the current article in that TextView
        tagTextView.setText(originalTag);

        // Create a new Date object from the date of the article
        Date dateObject = new Date(currentNews.getmNewsDate());

        // Find the TextView with view ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current article in that TextView
        dateTextView.setText(formattedDate);

        // Return the whole list item layout (containing 3 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
