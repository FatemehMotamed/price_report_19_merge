package com.poulstar.pricereport_sat_19.models;

import java.util.Map;

public class MainResponse {
    Map<String, Float> usd;

    public Map<String, Float> getUsd() {
        return usd;
    }

    @Override
    public String toString() {
        return "MainResponse{" +
                "usd=" + usd +
                '}';
    }
}
