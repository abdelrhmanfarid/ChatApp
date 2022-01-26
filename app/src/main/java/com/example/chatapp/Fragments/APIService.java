package com.example.chatapp.Fragments;

import com.example.chatapp.Notifications.MyResponse;
import com.example.chatapp.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAXILnkws:APA91bFT9nP-741ECAanE4iOoOLA-_yI9Z5_KKLlY9oFcrvgfXnk4ElngXqC8cSOCtpfZfigE5x9FcYaWF3czkb4_DA7-XhLPn_hoFc31D14vhU5Xb7ZGMtr21ytxPw9QFTSiEI2VNCX\t\n"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
