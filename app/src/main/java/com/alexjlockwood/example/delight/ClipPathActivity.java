package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClipPathActivity extends AppCompatActivity {

  @BindView(R.id.airplane) ImageView airplaneView;
  @BindView(R.id.flashlight) ImageView flashlightView;
  private boolean isChecked;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clippath);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    isChecked = !isChecked;
    final int[] stateSet = new int[]{android.R.attr.state_checked * (isChecked ? 1 : -1)};
    airplaneView.setImageState(stateSet, true);
    flashlightView.setImageState(stateSet, true);
  }
}
