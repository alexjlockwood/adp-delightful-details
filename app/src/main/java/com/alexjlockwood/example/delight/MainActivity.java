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
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.playpausestop, PlayPauseStopActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.digits, DigitsActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.search, SearchActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.clippath, ClipPathActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.heart, HeartActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.fingerprint, FingerprintActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.uploading, UploadingActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.clock, ClockActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.drawer, DrawerActivity.class);
    LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.expandcollapse, ExpandCollapseActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick({
      R.id.playpausestop,
      R.id.digits,
      R.id.search,
      R.id.clippath,
      R.id.heart,
      R.id.fingerprint,
      R.id.uploading,
      R.id.clock,
      R.id.drawer,
      R.id.expandcollapse,
  })
  void onListItemClick(View view) {
    startActivity(new Intent(this, LIST_ITEM_TO_ACTIVITY_MAP.get(view.getId())));
  }
}
