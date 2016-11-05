package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleActivity extends AppCompatActivity {

  @BindView(R.id.curvedmotion) ImageView curvedMotionView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    ((Animatable) curvedMotionView.getDrawable()).start();
  }
}
