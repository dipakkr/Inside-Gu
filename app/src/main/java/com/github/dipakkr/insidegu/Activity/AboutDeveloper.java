package com.github.dipakkr.insidegu.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.github.dipakkr.insidegu.R;

/**
 * Created by deepak on 21-01-2017.
 */

public class AboutDeveloper extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.github :
                Intent github = new Intent(Intent.ACTION_VIEW);
                github.setData(Uri.parse("https://github.com/dipakkr"));
                startActivity(github);
                break;

            case R.id.linkedin :
                Intent linkedin = new Intent(Intent.ACTION_VIEW);
                linkedin.setData(Uri.parse("https://in.linkedin.com/in/dipakkr"));
                startActivity(linkedin);
                break;

            case R.id.facebook :
                Intent fb = new Intent(Intent.ACTION_VIEW);
                fb.setData(Uri.parse("https://fb.com/dipakraj111"));
                startActivity(fb);
                break;

            case R.id.tweet :
                Intent twitter  = new Intent(Intent.ACTION_VIEW);
                twitter.setData(Uri.parse("https://twitter.com/diipakkr"));
                startActivity(twitter);
                break;

        }
    }
}
