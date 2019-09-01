package com.example.pickingimageanduploading;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivityTest extends AppCompatActivity {
    private static final int CAMERA_REQUEST_CODE = 102;
    private String cameraFilePath;
    private static final int GALLERY_REQUEST_CODE = 101;
    ImageView imageView;
    TextView textResponse;
    Button fromGallary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        fromGallary = findViewById(R.id.callapi);
        textResponse = findViewById(R.id.id_responsetext);
        fromGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToServer();
            }
        });


    }


    private void uploadToServer() {
        Retrofit retrofit = NetworkClient.getRetrofitClient(this);

        UploadAPIs uploadAPIs = retrofit.create(UploadAPIs.class);


        //
        Call call = uploadAPIs.login("923001234567", "123");

        call.enqueue(new retrofit2.Callback() {

            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                Log.d("MainActivity1", "Success: " + response);

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("MainActivity1", "Error: " + t);

            }
        });

    }
}
