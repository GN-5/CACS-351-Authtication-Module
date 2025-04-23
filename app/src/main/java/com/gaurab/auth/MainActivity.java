package com.gaurab.auth;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gaurab.auth.model.User;
import com.gaurab.auth.model.Address;
import com.gaurab.auth.ui.RegisterFragment;

import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new RegisterFragment())
                .commit();

        try(InputStream stream = getResources().openRawResource(R.raw.user)) {
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            String json = new String(bytes);
            Log.d("Gaurab", "User JSON:" + json);

            //Using GSON

            //Using JSON
            try {
                JSONObject jsonObject = new JSONObject(json);
                String firstName = jsonObject.getString("first_name");
                String lastName = jsonObject.getString("last_name");
                String email = jsonObject.getString("email");

                JSONObject addressJson = jsonObject.getJSONObject("address");
                String country = addressJson.getString("country");
                String region = addressJson.getString("region");
                String district = addressJson.getString("district");
                String addressLine = addressJson.getString("address_line");
                Boolean isInsideRingRoad = addressJson.getBoolean("isInsideRingRoad");
                int houseNumber = addressJson.getInt("house_no");


                Address address = new Address(country, region, district, addressLine, isInsideRingRoad, houseNumber);
                User user = new User(firstName, lastName, email, address);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}