package joeylang.com.turbokeymedianext;

import android.accessibilityservice.AccessibilityService;
//import android.content.Intent;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.SystemClock;
//import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
//import android.view.accessibility.AccessibilityNodeInfo;

public class turbokeymedianext extends AccessibilityService {
    //private static final String TAG = "TurboKey2MediaNext";
    private AudioManager mAudioManager;
    private PowerManager.WakeLock mWakeLock;

    @Override
    protected boolean onKeyEvent(KeyEvent event) {

        int key = event.getKeyCode();
        int key_action_code = event.getAction();
        long eventtime = SystemClock.uptimeMillis();
        //Log.i(TAG, "onKeyEvent key: "+ key);
        //Log.i(TAG, "onKeyEvent event.getAction(): "+ event.getAction());

        if (key_action_code==KeyEvent.ACTION_UP)
        {

            switch (key) {
                case 702:  //Note 10, Turbo Key Code

//                    Log.d(TAG, "ACTION_UP onKeyEvent " + key + " Start");
                    AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);

                    if(mAudioManager.isMusicActive()) {
                        KeyEvent upEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT, 0);

                        mAudioManager.dispatchMediaKeyEvent(upEvent);
//                        Log.d(TAG, "MusicActive");
                    }
//                    Log.d(TAG, "ACTION_UP onKeyEvent " + key + " End");

                    break;
                default:
                    break;
            }
        }else if (key_action_code==KeyEvent.ACTION_DOWN)
        {
            switch (key) {
                case 702:  //Note 10, Turbo Key Code
//                    Log.d(TAG, " ACTION_DOWN onKeyEvent " + key + " Start");
                    AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);

                    if(mAudioManager.isMusicActive()) {
                        KeyEvent downEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT, 0);
                        mAudioManager.dispatchMediaKeyEvent(downEvent);
//                        Log.d(TAG, "MusicActive");
                    }
//                    Log.d(TAG, "ACTION_DOWN onKeyEvent " + key + " End");

                    break;
                default:
                    break;
            }
        }
        return super.onKeyEvent(event);
    }

    @Override
    protected void onServiceConnected() {

        //Log.i(TAG, "config success!");

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // TODO Auto-generated method stub
//        int eventType = event.getEventType();
//        Log.i(TAG, "onAccessibilityEvent");
//        String eventText = "";
//        switch (eventType) {
//            case AccessibilityEvent.TYPE_VIEW_CLICKED:
//                Log.i(TAG, "==============Start====================");
//                eventText = "TYPE_VIEW_CLICKED";
//                Log.i(TAG, "=============END=====================");
//                break;
//            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
//                eventText = "TYPE_VIEW_FOCUSED";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
//                eventText = "TYPE_VIEW_LONG_CLICKED";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_SELECTED:
//                eventText = "TYPE_VIEW_SELECTED";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
//                eventText = "TYPE_VIEW_TEXT_CHANGED";
//                break;
//            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
//                eventText = "TYPE_WINDOW_STATE_CHANGED";
//                break;
//            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
//                eventText = "TYPE_NOTIFICATION_STATE_CHANGED";
//                break;
//            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END:
//                eventText = "TYPE_TOUCH_EXPLORATION_GESTURE_END";
//                break;
//            case AccessibilityEvent.TYPE_ANNOUNCEMENT:
//                eventText = "TYPE_ANNOUNCEMENT";
//                break;
//            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START:
//                eventText = "TYPE_TOUCH_EXPLORATION_GESTURE_START";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_HOVER_ENTER:
//                eventText = "TYPE_VIEW_HOVER_ENTER";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_HOVER_EXIT:
//                eventText = "TYPE_VIEW_HOVER_EXIT";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
//                eventText = "TYPE_VIEW_SCROLLED";
//                break;
//            case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
//                eventText = "TYPE_VIEW_TEXT_SELECTION_CHANGED";
//                break;
//            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
//                eventText = "TYPE_WINDOW_CONTENT_CHANGED";
//                break;
//        }
//
//        Log.i(TAG, "onAccessibilityEvent " + eventText);
    }

    @Override
    public void onInterrupt() {
        // TODO Auto-generated method stub
        //((PowerManager.WakeLock) mWakeLock).release();
        //Log.i(TAG, "::onInterrupt");

    }

    @Override
    public void onCreate() {

        //Log.i(TAG, "::onCreate");
        //PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        //mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"MyWakelockTag");
        //((PowerManager.WakeLock) mWakeLock).acquire();

        super.onCreate();
    }



}


