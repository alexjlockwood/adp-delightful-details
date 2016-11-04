package com.alexjlockwood.example.delight;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.SoundEffectConstants;
import android.widget.Checkable;
import android.widget.ImageView;

/**
 * An extension to {@link ImageView} which implements the {@link Checkable} interface.
 */
public class CheckableImageView extends AppCompatImageView implements Checkable {
  private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};

  private boolean isChecked;

  public CheckableImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean isChecked() {
    return isChecked;
  }

  @Override
  public void setChecked(boolean isChecked) {
    if (this.isChecked != isChecked) {
      this.isChecked = isChecked;
      refreshDrawableState();
    }
  }

  @Override
  public void toggle() {
    setChecked(!isChecked);
  }

  @Override
  public boolean performClick() {
    toggle();
    final boolean handled = super.performClick();
    if (!handled) {
      // View only makes a sound effect if the onClickListener was
      // called, so we'll need to make one here instead.
      playSoundEffect(SoundEffectConstants.CLICK);
    }
    return handled;
  }

  @Override
  public int[] onCreateDrawableState(int extraSpace) {
    final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
    if (isChecked()) {
      mergeDrawableStates(drawableState, CHECKED_STATE_SET);
    }
    return drawableState;
  }
}