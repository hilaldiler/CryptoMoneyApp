package com.hilal.cryptomoneyapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.hilal.cryptomoneyapp.PaginationListener.PaginationListener;
import com.hilal.cryptomoneyapp.R;
import com.hilal.cryptomoneyapp.adapter.CryptoAdapter;
import com.hilal.cryptomoneyapp.model.Crypto;
import com.hilal.cryptomoneyapp.service.CryptoAPI;
import com.hilal.cryptomoneyapp.service.RetrofitClientInstance;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CryptoAdapter cryptoAdapter;
    Context context;
    LinearLayoutManager linearLayoutManager;

    private ArrayList<Crypto> cryptoList;
    private int TOTAL_PAGES = 4;
    private static final int PAGE_START = 0;
    private int currentPage  = PAGE_START;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    int succesCode = 0;
    private KProgressHUD hud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cryptoList = new ArrayList<>();
        context = this;
        recyclerView = findViewById(R.id.recylerview);

        loadDataFromAPI(currentPage);

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new PaginationListener(linearLayoutManager) {
            @Override
            protected void loadItems() {
                isLoading = true;
                currentPage += 1;
                loadNextPage(currentPage);

            }

            @Override
            public int getPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });


    }

    private void showRecyclerView() {
        recyclerView.setLayoutManager(linearLayoutManager);
        cryptoAdapter = new CryptoAdapter(getApplicationContext(), new CryptoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//
            }
        });
        cryptoAdapter.addAll(cryptoList);
        recyclerView.setAdapter(cryptoAdapter);
    }

    private void loadDataFromAPI(int currentPage) {
        CryptoAPI cryptoAPI = RetrofitClientInstance.retrofitClient().create(CryptoAPI.class);
        Call<Crypto> call = cryptoAPI.getData(40, "desc", currentPage);

        call.enqueue(new Callback<Crypto>() {
            @Override
            public void onResponse(Call<Crypto> call, Response<Crypto> response) {
                assert response.body() != null;
                succesCode = response.code();
                Crypto responseList = response.body();

                for (int i = 0; i < responseList.getData().getCoins().size(); i++) {
                    cryptoList.add(responseList);
                }

                if (cryptoList.size() > 0){

                    showRecyclerView();
                    cryptoList.clear();

                }
                cryptoAdapter = new CryptoAdapter(getApplicationContext(), new CryptoAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                    //    Intent intent = new Intent(MainActivity.this, CryptoDescriptionActivity.class);
                    //    intent.putExtra("name", cryptoList.get(position).getData().getCoins().get(position).getName());
                    //    startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Crypto> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void loadNextPage(int currentPage) {
        cryptoAdapter.removeLoadingFooter();
        isLoading = false;
        loadDataFromAPI(currentPage);
        if (this.currentPage != TOTAL_PAGES) cryptoAdapter.addLoadingFooter();
        else isLastPage = true;

    }

    }





