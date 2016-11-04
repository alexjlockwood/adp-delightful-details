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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_playpausestop);
    ButterKnife.bind(this);
  }

  @OnClick({R.id.play, R.id.pause, R.id.stop})
  public void onButtonClick(View view) {
    if (view.getId() == R.id.play) {
      iconView.setImageState(STATE_SET_PLAY, true);
    } else if (view.getId() == R.id.pause) {
      iconView.setImageState(STATE_SET_PAUSE, true);
    } else if (view.getId() == R.id.stop) {
      iconView.setImageState(STATE_SET_STOP, true);
    }
  }
}
