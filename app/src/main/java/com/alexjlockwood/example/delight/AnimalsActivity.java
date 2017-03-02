package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimalsActivity extends AppCompatActivity {
  private static final int[] STATE_SET_HIPPO =
      {R.attr.state_hippo, -R.attr.state_buffalo, -R.attr.state_elephant};
  private static final int[] STATE_SET_BUFFALO =
      {-R.attr.state_hippo, R.attr.state_buffalo, -R.attr.state_elephant};
  private static final int[] STATE_SET_ELEPHANT =
      {-R.attr.state_hippo, -R.attr.state_buffalo, R.attr.state_elephant};

  @BindView(R.id.icon) ImageView iconView;
  @BindView(R.id.hippo) View hippoButton;
  @BindView(R.id.buffalo) View buffaloButton;
  @BindView(R.id.elephant) View elephantButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_animals);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.hippo)
  void setHippo() {
    hippoButton.setEnabled(false);
    buffaloButton.setEnabled(true);
    elephantButton.setEnabled(true);
    iconView.setImageState(STATE_SET_HIPPO, true);
  }

  @OnClick(R.id.buffalo)
  void setBuffalo() {
    hippoButton.setEnabled(true);
    buffaloButton.setEnabled(false);
    elephantButton.setEnabled(true);
    iconView.setImageState(STATE_SET_BUFFALO, true);
  }

  @OnClick(R.id.elephant)
  void setElephant() {
    hippoButton.setEnabled(true);
    buffaloButton.setEnabled(true);
    elephantButton.setEnabled(false);
    iconView.setImageState(STATE_SET_ELEPHANT, true);
  }
}
