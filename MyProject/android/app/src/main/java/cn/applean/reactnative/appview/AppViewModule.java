package cn.applean.reactnative.appview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by songximing on 15/12/25.
 */
public class AppViewModule extends ReactContextBaseJavaModule {


    public AppViewModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Applean";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        return constants;
    }

    @ReactMethod
    public void show(String message,int duration,Callback callback){
        Toast.makeText(getReactApplicationContext(),message,duration).show();
        Intent intent = new Intent(getReactApplicationContext(),AppViewActivity.class);
        getReactApplicationContext().startActivity(intent);
    }



}
