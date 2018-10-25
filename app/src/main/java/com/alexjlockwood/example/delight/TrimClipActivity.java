package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TrimClipActivity extends AppCompatActivity {

  @BindView(R.id.airplane) ImageView airplaneView;
  @BindView(R.id.eye) ImageView eyeView;
  @BindView(R.id.flashlight) ImageView flashlightView;
  @BindView(R.id.searchback) ImageView searchbackView;
  @BindView(R.id.heart) ImageView heartView;
  @BindView(R.id.cross) ImageView crossView;
  private boolean isChecked;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_trimclip);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    isChecked = !isChecked;
    final int[] stateSet = {android.R.attr.state_checked * (isChecked ? 1 : -1)};
    airplaneView.setImageState(stateSet, true);
    eyeView.setImageState(stateSet, true);
    flashlightView.setImageState(stateSet, true);
    searchbackView.setImageState(stateSet, true);
    heartView.setImageState(stateSet, true);
    crossView.setImageState(stateSet, true);
  }
}
