package com.hilal.cryptomoneyapp.model;

import com.google.gson.annotations.SerializedName;
import com.hilal.cryptomoneyapp.model.Data;

public class Crypto {
    @SerializedName("status")
    public String status;
    @SerializedName("data")
    public Data data;

    @Override
    public String toString() {
        return "" +
                "{" +
                "status='" + status + '\'' +
                ",data=" + data +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
