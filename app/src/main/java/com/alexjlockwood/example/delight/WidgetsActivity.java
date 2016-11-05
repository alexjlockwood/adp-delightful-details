package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WidgetsActivity extends AppCompatActivity {

  @BindView(R.id.radiobutton) ImageView radioButtonView;
  @BindView(R.id.checkbox) ImageView checkBoxView;
  @BindView(R.id.ft_arrow_overflow) ImageView arrowOverflowView;
  @BindView(R.id.expandcollapse) ImageView expandCollapseView;
  private boolean isChecked;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_widgets);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    isChecked = !isChecked;
    final int stateChecked = android.R.attr.state_checked * (isChecked ? 1 : -1);
    final int stateExpanded = android.R.attr.state_expanded * (isChecked ? 1 : -1);
    radioButtonView.setImageState(new int[]{stateChecked}, true);
    checkBoxView.setImageState(new int[]{stateChecked}, true);
    arrowOverflowView.setImageState(new int[]{stateChecked}, true);
    expandCollapseView.setImageState(new int[]{stateExpanded}, true);
  }
}
