package com.example.android.newsapp_stage1;

/**
 * Created by Coline on 26/03/2018.
 */

public class News {
    /** Title of the news article */
    private String mNewsTitle;

    /** Tag of the news article (ex: Society, Politics...) */
    private String mNewsTag;

    /** Time of article */
    private String mNewsDate;

    /** Website URL of the article */
    private String mUrl;


    /**
     * Create a new News object.
     *
     * @param newsTitle is the title
     * @param newsTag is the tag
     * @param newsDate is the time in milliseconds (from the Epoch) when the
     * article came out
     * @param url is the website URL to find more details about the article
     */
    public News(String newsTitle, String newsTag, String newsDate, String url) {
        mNewsTitle = newsTitle;
        mNewsTag = newsTag;
        mNewsDate = newsDate;
        mUrl = url;
    }

    /**
     * Get the title of the news article.
     */
    public String getmNewsTitle() {
        return mNewsTitle;
    }

    /**
     * Get the tag of the news article.
     */
    public String getmNewsTag() {
        return mNewsTag;
    }

    /**
     * Get the date of the article.
     */
    public String getmNewsDate() {
        return mNewsDate;
    }

    /**
     * Returns the website URL to find more information about the article.
     */
    public String getmUrl() {
        return mUrl;
    }

}
