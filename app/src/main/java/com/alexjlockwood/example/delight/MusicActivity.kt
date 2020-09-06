package com.alexjlockwood.example.delight

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MusicActivity : AppCompatActivity() {
    @BindView(R.id.previous)
    var previousView: ImageView? = null

    @BindView(R.id.next)
    var nextView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        (previousView!!.drawable as Animatable).start()
        (nextView!!.drawable as Animatable).start()
    }
}