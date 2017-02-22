package com.github.dipakkr.insidegu.HOGFeed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;


import com.github.dipakkr.insidegu.R;

/**
 * Created by deepak on 03-02-2017.
 */

public class StoryMainActivity extends AppCompatActivity {
    private PostAdapter postsAdapter;
    private List<FeedItem> feedItems;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    public static String FACEBOOK_URL = "https://www.facebook.com/humansofGalgotiasOfficial";
    public static String FACEBOOK_PAGE_ID = "113821202432553";
    private String URL_FEED = "https://graph.facebook.com/113821202432553/feed?fields=id,full_picture,message,story,created_time,link," +
            "comments&access_token=1610382879221507|eQEEkGV4wk9PHCBzrw9Whbdzyuc";
    private String id ="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
