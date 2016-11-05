package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ProgressBarActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_progressbar);
    startProgressBar(R.id.circular_indeterminate_progress_medium);
    startProgressBar(R.id.horizontal_indeterminate_progress);
  }

  private void startProgressBar(@IdRes int progressBarId) {
    ((Animatable) ((ImageView) findViewById(progressBarId)).getDrawable()).start();
  }
}
