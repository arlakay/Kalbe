package id.co.octolink.api.services;


import id.co.octolink.model.HistoryResponse;
import id.co.octolink.model.MerchantResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ILM on 6/29/2016.
 */
public interface ApiService {

    //Login - Test Success
    @FormUrlEncoded
    @POST("transaction/store")
    Call<MerchantResponse> getMerchantByCategory(@Field("category") String category);

    //History - Test Success
    @FormUrlEncoded
    @POST("users/history")
    Call<HistoryResponse> getHistoryByCustId(@Field("cid") String customerId);



}
