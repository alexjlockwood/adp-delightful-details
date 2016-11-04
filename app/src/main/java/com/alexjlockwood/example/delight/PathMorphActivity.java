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
  @BindView(R.id.expandcollapse) ImageView expandCollapseView;
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
    final int[] checkedStateSet = new int[]{android.R.attr.state_checked * (isChecked ? 1 : -1)};
    final int[] expandedStateSet = new int[]{android.R.attr.state_expanded * (isChecked ? 1 : -1)};
    drawerView.setImageState(checkedStateSet, true);
    crossTickView.setImageState(checkedStateSet, true);
    plusMinusView.setImageState(checkedStateSet, true);
    expandCollapseView.setImageState(expandedStateSet, true);
  }
}
