package com.alexjlockwood.example.delight

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import butterknife.ButterKnife
import butterknife.OnClick

class HandwritingActivity : AppCompatActivity() {
    private var cursiveAvd: Animatable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handwriting)
        ButterKnife.bind(this)
        ((findViewById<View>(R.id.io16Icon) as ImageView).drawable as Animatable).start()
        cursiveAvd = (findViewById<View>(R.id.cursiveIcon) as ImageView).drawable as Animatable
        restartCursiveAnimation()
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        restartCursiveAnimation()
    }

    private fun restartCursiveAnimation() {
        cursiveAvd!!.stop()
        cursiveAvd!!.start()
    }
}