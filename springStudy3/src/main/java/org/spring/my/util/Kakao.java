package org.spring.my.util;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.annotations.SerializedName;

public class Kakao {
	final static String ADMIN_KEY = "9d494a36270630d16f3db17fb25ffa1c";

	public static KakaoResultJson getUserInfoByAccessToken(String access_token){
		System.out.println("getUserInfoByAccessToken");
		try{
			KakaoAPI kakaoAPI = RetrofitManager.getKakaoAPI();

			KakaoResultJson kakaoResultJson = kakaoAPI.userMeForToken("Bearer "+access_token).execute().body();//sendApi(access_token);
			System.out.println("id : "+kakaoResultJson.getId());

			if(kakaoResultJson.getKaccount_email() == null || !kakaoResultJson.isKaccount_email_verified())
				return null;

			KakaoResultJson kakaoResultJson2 = kakaoAPI.userMeForUserId("user_id", ""+kakaoResultJson.getId()).execute().body();//checkIdByAdminKey(kakaoResultJson.id);

			if(kakaoResultJson2.id != kakaoResultJson.id) {
				System.out.println("kakao id not equal");
				return null;
			}

			return kakaoResultJson;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static KakaoResultJson getUserInfoById(long id){
		try{
			return checkIdByAdminKey(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static KakaoResultJson sendApi(String access_token) throws Exception{
		URI uri = URI.create("https://kapi.kakao.com/v2/user/me");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+access_token);
		ResponseEntity<KakaoResultJson> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), KakaoResultJson.class);
		return responseEntity.getBody();
	}
	public static KakaoResultJson checkIdByAdminKey(long id) throws Exception{
		URI uri = URI.create("https://kapi.kakao.com/v2/user/me");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		headers.set("Authorization", "KakaoAK "+ADMIN_KEY);
		MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
		body.add("target_id_type", "user_id");
		body.add("target_id", ""+id);
	    HttpEntity<MultiValueMap<String,Object>> entity = new HttpEntity<>(body,headers);
		ResponseEntity<KakaoResultJson> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, KakaoResultJson.class);
		return responseEntity.getBody();//new Gson().fromJson(responseEntity.getBody(),new TypeToken<KakaoResultJson>(){}.getType());
	}
	public class KakaoResultJson{
		private long id;
		private String kaccount_email;
		@SerializedName("kakao_account.has_email")
		private boolean kaccount_email_verified;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getKaccount_email() {
			return kaccount_email;
		}
		public void setKaccount_email(String kaccount_email) {
			this.kaccount_email = kaccount_email;
		}
		public boolean isKaccount_email_verified() {
			return kaccount_email_verified;
		}
		public void setKaccount_email_verified(boolean kaccount_email_verified) {
			this.kaccount_email_verified = kaccount_email_verified;
		}
	}
}
