package com.alexjlockwood.example.delight

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class DownloadingActivity : AppCompatActivity() {
    @BindView(R.id.downloading)
    var downloadingView: ImageView? = null
    private var isDownloading = false

    // We want to begin the progress-to-check animation only when the progress bar is at
    // its initial start state (i.e. trimPathStart = 0, trimPathEnd = 0.03, and the visible
    // portion of the path begins at the very top of the circle). We achieve this by keeping
    // track of the last time the downloading view was clicked and by delaying the start of
    // the progress-to-check animation manually here. It's slightly hacky, but unfortunately
    // there isn't much else we can do. :/
    private var downloadingStartTimeMillis: Long = 0
    private var isCompleteAnimationPending = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloading)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        if (isCompleteAnimationPending) {
            return
        }
        if (isDownloading) {
            val delayMillis = 2666 - (System.currentTimeMillis() - downloadingStartTimeMillis) % 2666
            downloadingView!!.postDelayed({
                swapAnimation(R.drawable.avd_downloading_finish)
                isCompleteAnimationPending = false
            }, delayMillis)
            isCompleteAnimationPending = true
        } else {
            swapAnimation(R.drawable.avd_downloading_begin)
            downloadingStartTimeMillis = System.currentTimeMillis()
        }
        isDownloading = !isDownloading
    }

    private fun swapAnimation(@DrawableRes drawableResId: Int) {
        val avd: Drawable? = AnimatedVectorDrawableCompat.create(this, drawableResId)
        downloadingView!!.setImageDrawable(avd)
        (avd as Animatable?)!!.start()
    }
}