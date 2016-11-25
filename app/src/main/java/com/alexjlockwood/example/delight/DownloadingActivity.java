package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.os.Handler;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// TODO(alockwood): still need to add arrow clip path fill
public class DownloadingActivity extends AppCompatActivity {

  @BindView(R.id.downloading) ImageView downloadingView;
  private boolean isDownloading;
  private long lastKnownTimeMillis;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_downloading);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    if (isDownloading) {
      // TODO(alockwood): replace this with something less hacky
      new Handler().postDelayed(this::beginFinishAnimation, 2666 - ((System.currentTimeMillis() - lastKnownTimeMillis) % 2666));
    } else {
      final AnimatedVectorDrawableCompat avd =
          AnimatedVectorDrawableCompat.create(this, R.drawable.avd_downloading_begin);
      downloadingView.setImageDrawable(avd);
      avd.start();
      lastKnownTimeMillis = System.currentTimeMillis();
    }
    isDownloading = !isDownloading;
  }

  private void beginFinishAnimation() {
    final AnimatedVectorDrawableCompat avd =
        AnimatedVectorDrawableCompat.create(this, R.drawable.avd_downloading_finish);
    downloadingView.setImageDrawable(avd);
    avd.start();
  }
}
