package com.gaurab.auth.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.gaurab.auth.data.pojo.RegisterBody;
import com.gaurab.auth.utility.ServiceProvider;

import java.util.concurrent.Executors;

public class RegisterViewModel extends ViewModel {
    public void registerUser(RegisterBody registerBody){
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                ServiceProvider.getService().registerUser(registerBody).execute();
            } catch (Exception e) {
                // If no internet, it will reach this condition
                Log.e("API_FAILED", "RegisterUser: ", e);
            }
        });
    }
    }
