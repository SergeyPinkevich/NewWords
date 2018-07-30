package com.mockingbird.spinkevich.newwords.presentation.data.api;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TranslateService {

    @POST("/api/v1.5/tr.json/translate")
    Single<TranslateResponse> translate(@Query("key") String apiKey,
                                                 @Query("lang") String translateDirection,
                                                 @Query("text") String text);
}
