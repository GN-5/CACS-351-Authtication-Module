package com.gaurab.auth.data;

import com.gaurab.auth.data.pojo.RegisterBody;
import com.gaurab.auth.data.pojo.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    static String BASE_URL = "https://sunilprasai.com.np";
    @POST("api/user/register")
    Call<RegisterResponse> registerUser(@Body RegisterBody body);
}
