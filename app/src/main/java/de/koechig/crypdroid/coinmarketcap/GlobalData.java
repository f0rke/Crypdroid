package de.koechig.crypdroid.coinmarketcap;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalData implements Serializable, Parcelable {

    @SerializedName("total_market_cap_usd")
    @Expose
    private Integer totalMarketCapUsd;
    @SerializedName("total_24h_volume_usd")
    @Expose
    private Integer total24hVolumeUsd;
    @SerializedName("bitcoin_percentage_of_market_cap")
    @Expose
    private Double bitcoinPercentageOfMarketCap;
    @SerializedName("active_currencies")
    @Expose
    private Integer activeCurrencies;
    @SerializedName("active_assets")
    @Expose
    private Integer activeAssets;
    @SerializedName("active_markets")
    @Expose
    private Integer activeMarkets;
    @SerializedName("last_updated")
    @Expose
    private Integer lastUpdated;
    public final static Parcelable.Creator<GlobalData> CREATOR = new Creator<GlobalData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GlobalData createFromParcel(Parcel in) {
            return new GlobalData(in);
        }

        public GlobalData[] newArray(int size) {
            return (new GlobalData[size]);
        }

    };
    private final static long serialVersionUID = 3402961406880493132L;

    protected GlobalData(Parcel in) {
        this.totalMarketCapUsd = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total24hVolumeUsd = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bitcoinPercentageOfMarketCap = ((Double) in.readValue((Double.class.getClassLoader())));
        this.activeCurrencies = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.activeAssets = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.activeMarkets = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lastUpdated = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public GlobalData() {
    }

    public Integer getTotalMarketCapUsd() {
        return totalMarketCapUsd;
    }

    public void setTotalMarketCapUsd(Integer totalMarketCapUsd) {
        this.totalMarketCapUsd = totalMarketCapUsd;
    }

    public Integer getTotal24hVolumeUsd() {
        return total24hVolumeUsd;
    }

    public void setTotal24hVolumeUsd(Integer total24hVolumeUsd) {
        this.total24hVolumeUsd = total24hVolumeUsd;
    }

    public Double getBitcoinPercentageOfMarketCap() {
        return bitcoinPercentageOfMarketCap;
    }

    public void setBitcoinPercentageOfMarketCap(Double bitcoinPercentageOfMarketCap) {
        this.bitcoinPercentageOfMarketCap = bitcoinPercentageOfMarketCap;
    }

    public Integer getActiveCurrencies() {
        return activeCurrencies;
    }

    public void setActiveCurrencies(Integer activeCurrencies) {
        this.activeCurrencies = activeCurrencies;
    }

    public Integer getActiveAssets() {
        return activeAssets;
    }

    public void setActiveAssets(Integer activeAssets) {
        this.activeAssets = activeAssets;
    }

    public Integer getActiveMarkets() {
        return activeMarkets;
    }

    public void setActiveMarkets(Integer activeMarkets) {
        this.activeMarkets = activeMarkets;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalMarketCapUsd);
        dest.writeValue(total24hVolumeUsd);
        dest.writeValue(bitcoinPercentageOfMarketCap);
        dest.writeValue(activeCurrencies);
        dest.writeValue(activeAssets);
        dest.writeValue(activeMarkets);
        dest.writeValue(lastUpdated);
    }

    public int describeContents() {
        return 0;
    }

}