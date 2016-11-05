package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PathMorphActivity extends AppCompatActivity {

  private static final int[] DIGIT_STATES = {
      R.attr.state_zero,
      R.attr.state_one,
      R.attr.state_two,
      R.attr.state_three,
      R.attr.state_four,
      R.attr.state_five,
      R.attr.state_six,
      R.attr.state_seven,
      R.attr.state_eight,
      R.attr.state_nine,
  };

  @BindView(R.id.drawer) ImageView drawerView;
  @BindView(R.id.crosstick) ImageView crossTickView;
  @BindView(R.id.plusminus) ImageView plusMinusView;
  @BindView(R.id.countdown) ImageView countdownView;
  private boolean isChecked;
  private int nextDigitStateIndex;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pathmorph);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    isChecked = !isChecked;
    final int[] checkedStateSet = new int[]{android.R.attr.state_checked * (isChecked ? 1 : -1)};
    drawerView.setImageState(checkedStateSet, true);
    crossTickView.setImageState(checkedStateSet, true);
    plusMinusView.setImageState(checkedStateSet, true);

    // Decrement the countdown view by one.
    final int numStates = DIGIT_STATES.length;
    final int[] stateSet = new int[numStates];
    for (int i = 0; i < stateSet.length; i++) {
      if (i == nextDigitStateIndex) {
        stateSet[i] = DIGIT_STATES[numStates - i - 1];
      } else {
        stateSet[i] = -DIGIT_STATES[numStates - i - 1];
      }
    }
    countdownView.setImageState(stateSet, true);
    nextDigitStateIndex = (nextDigitStateIndex + 1) % numStates;
  }
}
