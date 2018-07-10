package com.example.gasstation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] stationName = {"AutoGrill", "Eni Gas", "Esso", "IP", "Q8", "Shell", "Total"};
    int[] stationImage = {R.drawable.autogrill_logo,
            R.drawable.eni_logo,
            R.drawable.esso_logo,
            R.drawable.logo_ip,
            R.drawable.q8_logo,
            R.drawable.shell_logo,
            R.drawable.total_logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, stationName, stationImage);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("stationName", stationName[i]);
                mIntent.putExtra("stationImage", stationImage[i]);
                startActivity(mIntent);
            }
        });
    }
}
