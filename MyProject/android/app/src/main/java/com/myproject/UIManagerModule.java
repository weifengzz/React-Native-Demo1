package com.myproject;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by songximing on 15/12/25.
 */
public class UIManagerModule extends ReactContextBaseJavaModule {
    public UIManagerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        WritableMap params = Arguments.createMap();
        sendEvent(reactContext, "keyboardWillShow", params);
    }

    @Override
    public String getName() {
        return null;
    }


    //-----------//
    private void sendEvent(ReactContext reactContext,String eventName,@Nullable WritableMap params){
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName,params);
    }
    //-----------//



}
