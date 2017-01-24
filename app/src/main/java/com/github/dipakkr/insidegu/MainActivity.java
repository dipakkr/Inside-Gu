package com.github.dipakkr.insidegu;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.dipakkr.insidegu.Activity.AboutDeveloper;
import com.github.dipakkr.insidegu.Activity.ContributionActivity;
import com.github.dipakkr.insidegu.Activity.DiscussionActivity;
import com.github.dipakkr.insidegu.Fragment.NotesFragment;
import com.github.dipakkr.insidegu.Fragment.SettingFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private String LOG_TAG = MainActivity.class.getSimpleName();
    private boolean backpressedonce = false;
    private Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,new NotesFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Class fragmentClass = null;
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        switch (item.getItemId()){

            case R.id.notes :
                fragmentClass = NotesFragment.class;
                if(getSupportActionBar()!=null){
                    getSupportActionBar().setTitle(R.string.notes);
                }
                break;

            case R.id.setting :
                fragmentClass = SettingFragment.class;
                if(getSupportActionBar()!=null) {
                    getSupportActionBar().setTitle(R.string.setting);
                }

                break;

            case R.id.share :
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Hey Check my new application");
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
                break;

            case R.id.contribute :
                Intent contributeIntent = new Intent(this, ContributionActivity.class);
                startActivity(contributeIntent);
                break;

            case R.id.about_dev :
                Intent aboutdev = new Intent(this,AboutDeveloper.class);
                startActivity(aboutdev);
                break;

            default:
                fragmentClass = NotesFragment.class;
        }
        try
        {
            fragment = (Fragment)fragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            Log.e(LOG_TAG,"Error in Instantiation",e);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
          if (backpressedonce) {
                finish();
            } else if (!backpressedonce) {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
                backpressedonce = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backpressedonce = false;
                    }
                }, 2000);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.froum){
            Intent discussion  = new Intent(this,DiscussionActivity.class);
            startActivity(discussion);
        }
        return super.onOptionsItemSelected(item);
    }
}
