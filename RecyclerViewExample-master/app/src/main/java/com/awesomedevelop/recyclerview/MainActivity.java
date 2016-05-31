package com.awesomedevelop.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ActionBarActivity {
    private List<Path> pathPoster = null;
    RecyclerView recyclerView = null;
    ArrayList<PosterData> posters = new ArrayList<>();
    List<Up> upPost = new ArrayList<>();
    RecyclerView.Adapter adapter;
    PosterAdapter posterAdapter = null;
    RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount, dx, dy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisiblesItems = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.v("...", "Last Item Wow !");
                            refreshData();
                            //Do pagination.. i.e. fetch new data
                        }
                    }
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        loadData();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });
    }

    void refreshItems() {
        // Load items
        // ...
        update();
        // Load complete
        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...

        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void update() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://posterkeeper.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RESTPK service = retrofit.create(RESTPK.class);
        Call<Update> call = service.uploadJsonStr();
        call.enqueue(new Callback<Update>() {
            @Override
            public void onResponse(Call<Update> call, Response<Update> response) {
                upPost = null;
                upPost = response.body().getUp();
                String name = upPost.get(0).get1();
                posters.add(0,new PosterData(name));
                posterAdapter = new PosterAdapter(MainActivity.this, posters);
                recyclerView.setAdapter(posterAdapter);
            }
            @Override
            public void onFailure(Call<Update> call, Throwable t) {
            }
        });
    }

    public void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://posterkeeper.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RESTPK service = retrofit.create(RESTPK.class);
        Call<JsonStr> call = service.loadJsonStr();
        call.enqueue(new Callback<JsonStr>() {
            @Override
            public void onResponse(Call<JsonStr> call, Response<JsonStr> response) {
                String name = null;
                pathPoster = response.body().getPath();
                for (int i = 0; i < pathPoster.size(); i++) {
                    switch (i){
                        case 0:name = pathPoster.get(i).get1();
                            break;
                        case 1:name = pathPoster.get(i).get2();
                            break;
                        case 2:name = pathPoster.get(i).get3();
                            break;
                        case 3:name = pathPoster.get(i).get4();
                            break;
                        case 4:name = pathPoster.get(i).get5();
                            break;
                        case 5:name = pathPoster.get(i).get6();
                            break;
                        case 6:name = pathPoster.get(i).get7();
                            break;
                        case 7:name = pathPoster.get(i).get8();
                            break;
                        case 8:name = pathPoster.get(i).get9();
                            break;
                        case 9:name = pathPoster.get(i).get10();
                            break;
                    }
                    posters.add(new PosterData(name));
                }
                pathPoster = null;
                posterAdapter = new PosterAdapter(MainActivity.this, posters);
                recyclerView.setAdapter(posterAdapter);
            }
            @Override
            public void onFailure(Call<JsonStr> call, Throwable t) {
            }
        });
    }
    public void refreshData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://posterkeeper.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RESTPK service = retrofit.create(RESTPK.class);
        Call<JsonStr> call = service.reloadJsonStr();
        call.enqueue(new Callback<JsonStr>() {
            @Override
            public void onResponse(Call<JsonStr> call, Response<JsonStr> response) {
                String name = null;
                pathPoster = response.body().getPath();
                for (int i = 0; i < pathPoster.size(); i++) {
                    switch (i){
                        case 0:name = pathPoster.get(i).get1();
                            break;
                        case 1:name = pathPoster.get(i).get2();
                            break;
                        case 2:name = pathPoster.get(i).get3();
                            break;
                        case 3:name = pathPoster.get(i).get4();
                            break;
                        case 4:name = pathPoster.get(i).get5();
                            break;
                        case 5:name = pathPoster.get(i).get6();
                            break;
                        case 6:name = pathPoster.get(i).get7();
                            break;
                        case 7:name = pathPoster.get(i).get8();
                            break;
                        case 8:name = pathPoster.get(i).get9();
                            break;
                        case 9:name = pathPoster.get(i).get10();
                            break;
                    }
                    posters.add(new PosterData(name));
                }
                pathPoster = null;
                posterAdapter = new PosterAdapter(MainActivity.this, posters);
                recyclerView.setAdapter(posterAdapter);
            }
            @Override
            public void onFailure(Call<JsonStr> call, Throwable t) {
            }
        });
    }
}
