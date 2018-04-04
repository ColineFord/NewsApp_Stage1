package com.example.android.newsapp_stage1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
     * @param news    is the list of {@link News}s to be displayed.
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

        // Find the TextView with view ID title
        TextView titleTextView = listItemView.findViewById(R.id.title);
        // Get the original title string from the News object
        String title = currentNews.getmNewsTitle();
        // Display the title of the current article in that TextView
        titleTextView.setText(title);

        // Find the TextView with view ID author
        TextView authorTextView = listItemView.findViewById(R.id.author);
        if(currentNews.hasAuthor()) {
            // Get the author string from the News object
            String author = currentNews.getmNewsAuthor();
            // Display the title of the current article in that TextView
            authorTextView.setText(author);
            // Make sure the view is visible
            authorTextView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            authorTextView.setVisibility(View.GONE);
        }

        // Find the TextView with view ID tag
        TextView tagTextView = listItemView.findViewById(R.id.tag);
        // Get the original tag string from the News object
        String originalTag = currentNews.getmNewsTag();
        // Display the tag of the current article in that TextView
        tagTextView.setText(originalTag);

        // Get the appropriate background color based on the current article tag
        int tagColor = getTagValue(currentNews.getmNewsTag());
        // Set the text color of the tag TextView
        tagTextView.setTextColor(tagColor);

        // Find the TextView with view ID date
        TextView dateTextView = listItemView.findViewById(R.id.date);
        // Get the date string from the News object
        String date = getDate(currentNews.getmNewsDate());
        // Display the date of the current article in that TextView
        dateTextView.setText(date);


        // Return the whole list item layout (containing 3 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }

    private String getDate(String date) {
        String[] parts = date.split("T");
        return parts[0];
    }

    /**
     * Return the color for the tag TextView based on the tag String of the article.
     *
     * @param tag of the article
     */
    private int getTagValue(String tag) {
        int tagColorResourceId;
        switch (tag) {
            case "Music":
                tagColorResourceId = R.color.musicTag;
                break;
            case "Travel":
                tagColorResourceId = R.color.travelTag;
                break;
            case "Teacher Network":
                tagColorResourceId = R.color.teacher_networkTag;
                break;
            case "Guardian Masterclasses":
                tagColorResourceId = R.color.guardian_masterclassesTag;
                break;
            case "World news":
                tagColorResourceId = R.color.world_newsTag;
                break;
            case "Stage":
                tagColorResourceId = R.color.stage;
                break;
            default:
                tagColorResourceId = R.color.defaultTag;
                break;
        }
        return ContextCompat.getColor(getContext(), tagColorResourceId);
    }
}
