package com.poulstar.pricereport_sat_19;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poulstar.pricereport_sat_19.api.CurrencyExchange;
import com.poulstar.pricereport_sat_19.models.MainResponse;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Item> main_data;
    MainAdapter adapter;
    RecyclerView main_recycle;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        main_data = new ArrayList<>();

        Retrofit currency_list = new Retrofit.Builder()
                .baseUrl("https://cdn.jsdelivr.net/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        CurrencyExchange currency_main_model = currency_list.create(CurrencyExchange.class);

        Call<MainResponse> get_main_call = currency_main_model.getCurrencyList("1","2020-11-24", "usd");

        get_main_call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                getActivity().runOnUiThread(() -> {
                    Log.d("rrrrrrrrrr", response.body().toString());
                    SetData(response.body().getUsd());
                    adapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                Log.d("errrrrrror", "failed");
            }
        });

       View view =inflater.inflate(R.layout.fragment_main, container, false);

        main_recycle = view.findViewById(R.id.main_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        adapter = new MainAdapter(main_data, getContext());
        main_recycle.setAdapter(adapter);
        main_recycle.setLayoutManager(manager);

        return view;
    }

    public void SetData(Map<String, Float> map){
        main_data.add(new Item ("aed", map.get("aed").toString(), "2020-90-12", "usd"  ));
        main_data.add(new Item ("afn", map.get("afn").toString(), "2020-90-12", "usd"  ));
        main_data.add(new Item ("eur", map.get("eur").toString(), "2020-90-12", "usd"  ));
        main_data.add(new Item ("amd", map.get("amd").toString(), "2020-90-12", "usd"  ));
    }


}