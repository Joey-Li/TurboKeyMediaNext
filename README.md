# TurboKeyMediaNext
Create TurboKey alternative function.
TurboKey will pass Media_Next to AUDIO_SERVICE of system when clicking TurboKey. It's only for Honor Note10 Device.

TurboKey : KeyEvent is 702

Keep Sevice always running : 
Setting->電池優化->把TurboKeyMediaNext設定為不允許

``settings put secure enabled_accessibility_services joeylang.com.turbokeymedianext/.turbokeymedianext``
``settings put secure accessibility_enabled 1``

![](https://github.com/Joey-Li/TurboKeyMediaNext/blob/master/Screenshot_20190124_140532_com.android.settings.jpg)
