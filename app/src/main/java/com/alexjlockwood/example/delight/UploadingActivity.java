package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadingActivity extends AppCompatActivity {

  @BindView(R.id.uploading) ImageView uploadingView;
  private int numClicks;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_uploading);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    if (numClicks % 2 == 0) {
      final AnimatedVectorDrawableCompat avd =
          AnimatedVectorDrawableCompat.create(this, R.drawable.avd_uploading);
      uploadingView.setImageDrawable(avd);
      avd.start();
    } else if (numClicks % 2 == 1) {
      final AnimatedVectorDrawableCompat avd =
          AnimatedVectorDrawableCompat.create(this, R.drawable.avd_upload_error);
      uploadingView.setImageDrawable(avd);
      avd.start();
    }
    numClicks++;
  }
}
