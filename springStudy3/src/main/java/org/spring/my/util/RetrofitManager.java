package org.spring.my.util;

import org.spring.my.util.Kakao.KakaoResultJson;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class RetrofitManager {
	public static KakaoAPI getKakaoAPI() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KakaoAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .build();
        return retrofit.create(KakaoAPI.class);
	}
}

interface KakaoAPI {
	String BASE_URL = "https://kapi.kakao.com";

	@GET("/v2/user/me")
	Call<KakaoResultJson> userMeForToken(@Header("Authorization") String authorization);

	@FormUrlEncoded
	@POST("/v2/user/me")
	@Headers("Authorization: KakaoAK" + Kakao.ADMIN_KEY)
	Call<KakaoResultJson> userMeForUserId(
		@Field("target_id_type") String targetIdType,
		@Field("target_id") String targetId
	);
}