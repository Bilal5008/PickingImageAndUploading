package com.example.pickingimageanduploading;

import android.database.Observable;

import com.google.gson.JsonElement;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadAPIs {


    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseBody>login(@Field("phone") String mobileNumber, @Field("password") String password);


    // Call<ResponseBody> uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody requestBody);

    @Multipart
    @POST("accounts/NewAccountApi")
    Call<ResponseBody> uploadImage(@Part("userId") String userId, @Part("name") String name, @Part MultipartBody.Part file, @Part("phone") String phone, @Part("address") String address, @Part("active") Boolean active);
}