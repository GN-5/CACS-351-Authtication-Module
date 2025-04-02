package com.gaurab.auth.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.gaurab.auth.data.pojo.RegisterBody;
import com.gaurab.auth.utility.ServiceProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class RegisterViewModel extends ViewModel {

    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_CONFIRM_PASSWORD = "confirm_password";

    Map<String, String> validateFullName(String fullName){
        HashMap<String, String> fullNameErrors = new HashMap<>();
        if(fullName.isEmpty()){
            fullNameErrors.put(KEY_FULL_NAME, "Full Name is required");
        } else if (!Pattern.compile("^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$").matcher(fullName).matches()) {
            fullNameErrors.put(KEY_FULL_NAME, "Full Name is required");
        }
        return fullNameErrors;
    }

    Map<String, String> validateEmail(String email){
        HashMap<String, String> emailErrors = new HashMap<>();

        if(email.isEmpty()){
            emailErrors.put(KEY_EMAIL, "Email is required");
        }else if(!Pattern.compile("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,6}$").matcher(email).matches()){
            emailErrors.put(KEY_EMAIL, "Email is invalid");
        }
        return emailErrors;
    }

    Map<String, String> validatePassword(String password){
        HashMap<String, String> passwordErrors = new HashMap<>();

        if(password.isEmpty()){
            passwordErrors.put(KEY_PASSWORD, "Password is required");
        }

        return passwordErrors;
    }

    Map<String, String> validateConfirmPassword(String password, String confirmPassword){
        HashMap<String, String> confirmPasswordErrors = new HashMap<>();

        if(confirmPassword.isEmpty()){
            confirmPasswordErrors.put(KEY_CONFIRM_PASSWORD, "Confirm Password is required");
        } else if (validatePassword(password).isEmpty() && !password.equals(confirmPassword)) {
            confirmPasswordErrors.put(KEY_CONFIRM_PASSWORD, "Passwords do not match.")
        }

        return confirmPasswordErrors;
    }


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
