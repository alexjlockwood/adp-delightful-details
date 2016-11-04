package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FingerprintActivity extends AppCompatActivity {
  private static final int[] STATE_SET_ON =
      {R.attr.state_on, -R.attr.state_off, -R.attr.state_error};
  private static final int[] STATE_SET_OFF =
      {-R.attr.state_on, R.attr.state_off, -R.attr.state_error};
  private static final int[] STATE_SET_ERROR =
      {-R.attr.state_on, -R.attr.state_off, R.attr.state_error};

  @BindView(R.id.icon) ImageView iconView;
  @BindView(R.id.on) View onButton;
  @BindView(R.id.off) View offButton;
  @BindView(R.id.error) View errorButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fingerprint);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.on)
  void setFingerprintOn() {
    onButton.setEnabled(false);
    offButton.setEnabled(true);
    errorButton.setEnabled(true);
    iconView.setImageState(STATE_SET_ON, true);
  }

  @OnClick(R.id.off)
  void setFingerprintOff() {
    onButton.setEnabled(true);
    offButton.setEnabled(false);
    errorButton.setEnabled(false);
    iconView.setImageState(STATE_SET_OFF, true);
  }

  @OnClick(R.id.error)
  void setFingerprintError() {
    onButton.setEnabled(true);
    offButton.setEnabled(false);
    errorButton.setEnabled(false);
    iconView.setImageState(STATE_SET_ERROR, true);
  }
}
