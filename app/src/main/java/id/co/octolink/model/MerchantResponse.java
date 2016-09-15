package id.co.octolink.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ILM on 8/29/2016.
 */
public class MerchantResponse {
    @SerializedName("store")
    private List<Merchant> store;

    public MerchantResponse(List<Merchant> store) {
        this.store = store;
    }

    public List<Merchant> getStore() {
        return store;
    }

    public void setStore(List<Merchant> store) {
        this.store = store;
    }

}
