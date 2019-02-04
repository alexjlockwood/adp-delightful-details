package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PathMorphActivity extends AppCompatActivity {

  @BindView(R.id.drawer) ImageView drawerView;
  @BindView(R.id.crosstick) ImageView crossTickView;
  @BindView(R.id.plusminus) ImageView plusMinusView;
  @BindView(R.id.arrowoverflow) ImageView arrowoverflowView;
  @BindView(R.id.filterclear) ImageView filterclear;
  private boolean isChecked;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pathmorph);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    isChecked = !isChecked;
    final int[] stateSet = {android.R.attr.state_checked * (isChecked ? 1 : -1)};
    drawerView.setImageState(stateSet, true);
    crossTickView.setImageState(stateSet, true);
    plusMinusView.setImageState(stateSet, true);
    arrowoverflowView.setImageState(stateSet, true);
    filterclear.setImageState(stateSet, true);
  }
}
