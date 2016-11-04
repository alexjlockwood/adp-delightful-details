package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HandwritingActivity extends AppCompatActivity {

  @BindView(R.id.icon) ImageView iconView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_handwriting);
    ButterKnife.bind(this);
    startAnimation();
  }

  @OnClick(R.id.rootview)
  void onClick() {
    startAnimation();
  }

  private void startAnimation() {
    final Animatable avd = (Animatable) iconView.getDrawable();
    avd.stop();
    avd.start();
  }
}
