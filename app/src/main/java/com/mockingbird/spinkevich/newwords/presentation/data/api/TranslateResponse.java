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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTranslateDirection() {
        return translateDirection;
    }

    public void setTranslateDirection(String translateDirection) {
        this.translateDirection = translateDirection;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }
}
