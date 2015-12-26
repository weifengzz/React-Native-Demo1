package cn.applean.reactnative.appview;

import com.facebook.react.bridge.Callback;

import java.io.Serializable;

/**
 * Created by songximing on 15/12/25.
 */
public class Model implements Serializable{
    String message;
    int duration;
    Callback callback;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
