package com.mockingbird.spinkevich.newwords.presentation.data.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslateResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("lang")
    private String translateDirection;

    @SerializedName("text")
    private List<String> translation;
}
