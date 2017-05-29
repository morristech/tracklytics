package com.orhanobut.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.orhanobut.tracklytics.Event;
import com.orhanobut.tracklytics.TrackEvent;
import com.orhanobut.tracklytics.Tracker;
import com.orhanobut.tracklytics.trackers.SimpleTrackingAdapter;

import java.util.Map;

public class MainActivity extends Activity {


  @Override @TrackEvent("Event Java")
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Tracker.init(new SimpleTrackingAdapter() {
      @Override public void trackEvent(Event event, Map<String, Object> superAttributes) {
        super.trackEvent(event, superAttributes);
        Log.d("TrackingSample", event.eventName);
      }
    });

    new Foo().trackFoo();
  }

  @Override protected void onResume() {
    super.onResume();

    new Tracking().trackScreenDisplayed();
  }
}
