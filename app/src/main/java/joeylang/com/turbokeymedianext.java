package joeylang.com.turbokeymedianext;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.io.IOException;


public class turbokeymedianext extends AccessibilityService {
    private static final String TAG = "TurboKey2MediaNext";
    String[] PACKAGES = { "com.android.settings" };

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        int flag=0;
        int key = event.getKeyCode();
        Log.i(TAG, "onKeyEvent "+ key);
        switch(key){
            case 702:  //Note 10, Turbo Key Code
                Log.i(TAG, "onKeyEvent "+ key +" Start");
                //Send broadcast intent to main activity.
                //On the main activity you can take any desired action.

                Intent media_intent = new Intent("com.exmaple.broadcaster.KEYDOWN");
                media_intent.putExtra("dtime", System.currentTimeMillis());
                if(flag==0){
                    sendBroadcast(media_intent);
                    flag+=1;
                }else if (flag==1) {
                    flag=0;
                }
                Log.i(TAG, "onKeyEvent "+ key +" End");

                break;
            default:
                break;
        }
        return super.onKeyEvent(event);
    }

    @Override
    protected void onServiceConnected() {

        Log.i(TAG, "config success!");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // TODO Auto-generated method stub
        int eventType = event.getEventType();
        Log.i(TAG, "onAccessibilityEvent");
        String eventText = "";
        switch (eventType) {
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                Log.i(TAG, "==============Start====================");
                eventText = "TYPE_VIEW_CLICKED";
                AccessibilityNodeInfo noteInfo = event.getSource();
                Log.i(TAG, noteInfo.toString());
                Log.i(TAG, "=============END=====================");
                break;
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                eventText = "TYPE_VIEW_FOCUSED";
                break;
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                eventText = "TYPE_VIEW_LONG_CLICKED";
                break;
            case AccessibilityEvent.TYPE_VIEW_SELECTED:
                eventText = "TYPE_VIEW_SELECTED";
                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                eventText = "TYPE_VIEW_TEXT_CHANGED";
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                eventText = "TYPE_WINDOW_STATE_CHANGED";
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                eventText = "TYPE_NOTIFICATION_STATE_CHANGED";
                break;
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END:
                eventText = "TYPE_TOUCH_EXPLORATION_GESTURE_END";
                break;
            case AccessibilityEvent.TYPE_ANNOUNCEMENT:
                eventText = "TYPE_ANNOUNCEMENT";
                break;
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START:
                eventText = "TYPE_TOUCH_EXPLORATION_GESTURE_START";
                break;
            case AccessibilityEvent.TYPE_VIEW_HOVER_ENTER:
                eventText = "TYPE_VIEW_HOVER_ENTER";
                break;
            case AccessibilityEvent.TYPE_VIEW_HOVER_EXIT:
                eventText = "TYPE_VIEW_HOVER_EXIT";
                break;
            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
                eventText = "TYPE_VIEW_SCROLLED";
                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
                eventText = "TYPE_VIEW_TEXT_SELECTION_CHANGED";
                break;
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                eventText = "TYPE_WINDOW_CONTENT_CHANGED";
                break;
        }
    }

    @Override
    public void onInterrupt() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCreate() {
        Log.i(TAG, "::onCreate");
        super.onCreate();
    }


}


