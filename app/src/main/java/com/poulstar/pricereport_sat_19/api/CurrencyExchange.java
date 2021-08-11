package com.poulstar.pricereport_sat_19.api;

import com.poulstar.pricereport_sat_19.models.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyExchange {
    @GET("gh/fawazahmed0/currency-api@{apiVersion}/{date}/currencies/{endpoint}.json")
    Call<MainResponse> getCurrencyList(@Path("apiVersion") String api_v, @Path("date") String date, @Path("endpoint") String endpoint);

}
