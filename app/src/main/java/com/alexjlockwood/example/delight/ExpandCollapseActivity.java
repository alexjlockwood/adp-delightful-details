package com.alexjlockwood.example.delight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpandCollapseActivity extends AppCompatActivity {

  @BindView(R.id.icon) ImageView iconView;
  private boolean isExpanded;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expandcollapse);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    isExpanded = !isExpanded;
    iconView.setImageState(new int[]{android.R.attr.state_expanded * (isExpanded ? 1 : -1)}, true);
  }
}
