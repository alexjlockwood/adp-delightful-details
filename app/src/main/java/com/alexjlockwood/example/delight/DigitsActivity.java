package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DigitsActivity extends AppCompatActivity {

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

  @BindView(R.id.icon) ImageView iconView;
  private int nextDigitStateIndex;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_digits);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    final int numStates = DIGIT_STATES.length;
    final int[] stateSet = new int[numStates];
    for (int i = 0; i < stateSet.length; i++) {
      if (i == nextDigitStateIndex) {
        stateSet[i] = DIGIT_STATES[numStates - i - 1];
      } else {
        stateSet[i] = -DIGIT_STATES[numStates - i - 1];
      }
    }
    iconView.setImageState(stateSet, true);
    nextDigitStateIndex = (nextDigitStateIndex + 1) % numStates;
  }
}
