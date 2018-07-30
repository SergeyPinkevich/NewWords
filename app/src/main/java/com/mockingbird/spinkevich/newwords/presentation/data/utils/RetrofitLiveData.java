package com.mockingbird.spinkevich.newwords.presentation.data.utils;

import android.arch.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitLiveData<T> extends LiveData<T> implements Callback<T> {

    private Call<T> call;

    private Response<T> response;

    public RetrofitLiveData(Call call) {
        this.call = call;
    }

    @Override
    public void onActive() {
        if (!call.isCanceled() && !call.isExecuted()) {
            call.enqueue(this);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        //not implemented
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        this.response = response;
    }

    public void cancel() {
        if (!call.isCanceled()) {
            call.cancel();
        } else {
            return;
        }
    }

    public Response<T> getResponse() {
        return response;
    }
}
