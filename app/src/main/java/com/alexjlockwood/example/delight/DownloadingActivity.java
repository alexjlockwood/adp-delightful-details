package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DownloadingActivity extends AppCompatActivity {

  @BindView(R.id.downloading) ImageView downloadingView;
  private boolean isDownloading;

  // We want to begin the progress-to-check animation only when the progress bar is at
  // its initial start state (i.e. trimPathStart = 0, trimPathEnd = 0.03, and the visible
  // portion of the path begins at the very top of the circle). We achieve this by keeping
  // track of the last time the downloading view was clicked and by delaying the start of
  // the progress-to-check animation manually here. It's slightly hacky, but unfortunately
  // there isn't much else we can do. :/
  private long downloadingStartTimeMillis;

  private boolean isCompleteAnimationPending;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_downloading);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    if (isCompleteAnimationPending) {
      return;
    }
    if (isDownloading) {
      final long delayMillis = 2666 - ((System.currentTimeMillis() - downloadingStartTimeMillis) % 2666);
      downloadingView.postDelayed(() -> {
        swapAnimation(R.drawable.avd_downloading_finish);
        isCompleteAnimationPending = false;
      }, delayMillis);
      isCompleteAnimationPending = true;
    } else {
      swapAnimation(R.drawable.avd_downloading_begin);
      downloadingStartTimeMillis = System.currentTimeMillis();
    }
    isDownloading = !isDownloading;
  }

  private void swapAnimation(@DrawableRes int drawableResId) {
    final AnimatedVectorDrawableCompat avd =
        AnimatedVectorDrawableCompat.create(this, drawableResId);
    downloadingView.setImageDrawable(avd);
    avd.start();
  }
}
