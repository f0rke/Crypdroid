package de.koechig.crypdroid;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import de.koechig.crypdroid.coinmarketcap.CoinMarketCapApiEndpointInterface;
import de.koechig.crypdroid.coinmarketcap.CurrencyTicker;
import de.koechig.crypdroid.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://api.coinmarketcap.com/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CoinMarketCapApiEndpointInterface coinMarketCapApi = retrofit.create(CoinMarketCapApiEndpointInterface.class);
        Call<List<CurrencyTicker>> tickers = coinMarketCapApi.getTickers();
        tickers.enqueue(new Callback<List<CurrencyTicker>>() {
            @Override
            public void onResponse(Call<List<CurrencyTicker>> call, Response<List<CurrencyTicker>> response) {
                int statusCode = response.code();
                binding.setText(String.valueOf(statusCode));
            }

            @Override
            public void onFailure(Call<List<CurrencyTicker>> call, Throwable t) {
                binding.setText(t.getMessage());
            }
        });
    }
}
