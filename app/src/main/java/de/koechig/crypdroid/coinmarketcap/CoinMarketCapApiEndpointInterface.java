package de.koechig.crypdroid.coinmarketcap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mumpi_000 on 28.11.2017.
 */

public interface CoinMarketCapApiEndpointInterface {

    String TICKER = "ticker";

    @GET(TICKER)
    Call<List<CurrencyTicker>> getTickers();

    @GET(TICKER + "/{id}")
    Call<CurrencyTicker> getCurrencyTicker(@Path("id") int tickerId);
}
