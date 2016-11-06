package com.alexjlockwood.example.delight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  private static final SparseArray<Class<?>> LIST_ITEM_TO_ACTIVITY_MAP = new SparseArray<>();
  static {
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.clock, ClockActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.curvedmotion, CurvedMotionActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.fingerprint, FingerprintActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.handwriting, HandwritingActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.pathmorph, PathMorphActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.playpausestop, PlayPauseStopActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.progressbar, ProgressBarActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.trimclip, TrimClipActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.uploading, UploadingActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.widgets, WidgetsActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick({
      R.id.clock,
      R.id.curvedmotion,
      R.id.fingerprint,
      R.id.handwriting,
      R.id.pathmorph,
      R.id.playpausestop,
      R.id.progressbar,
      R.id.trimclip,
      R.id.uploading,
      R.id.widgets,
  })
  void onListItemClick(View view) {
    startActivity(new Intent(this, LIST_ITEM_TO_ACTIVITY_MAP.get(view.getId())));
  }
}
