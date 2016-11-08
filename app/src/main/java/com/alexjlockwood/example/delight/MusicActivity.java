package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicActivity extends AppCompatActivity {

  @BindView(R.id.previous) ImageView previousView;
  @BindView(R.id.next) ImageView nextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_music);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.rootview)
  void onClick() {
    ((Animatable) previousView.getDrawable()).start();
    ((Animatable) nextView.getDrawable()).start();
  }
}
