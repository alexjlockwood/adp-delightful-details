package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayPauseStopActivity extends AppCompatActivity {
  private static final int[] STATE_SET_PLAY =
      {R.attr.state_play, -R.attr.state_pause, -R.attr.state_stop};
  private static final int[] STATE_SET_PAUSE =
      {-R.attr.state_play, R.attr.state_pause, -R.attr.state_stop};
  private static final int[] STATE_SET_STOP =
      {-R.attr.state_play, -R.attr.state_pause, R.attr.state_stop};

  @BindView(R.id.icon) ImageView iconView;
  @BindView(R.id.play) View playButton;
  @BindView(R.id.pause) View pauseButton;
  @BindView(R.id.stop) View stopButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_playpausestop);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.play)
  void setPlay() {
    playButton.setEnabled(false);
    pauseButton.setEnabled(true);
    stopButton.setEnabled(true);
    iconView.setImageState(STATE_SET_PLAY, true);
  }

  @OnClick(R.id.pause)
  void setPause() {
    playButton.setEnabled(true);
    pauseButton.setEnabled(false);
    stopButton.setEnabled(true);
    iconView.setImageState(STATE_SET_PAUSE, true);
  }

  @OnClick(R.id.stop)
  void setStop() {
    playButton.setEnabled(true);
    pauseButton.setEnabled(true);
    stopButton.setEnabled(false);
    iconView.setImageState(STATE_SET_STOP, true);
  }
}
