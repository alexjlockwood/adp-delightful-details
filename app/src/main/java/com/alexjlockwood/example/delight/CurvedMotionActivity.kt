package com.alexjlockwood.example.delight

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class CurvedMotionActivity : AppCompatActivity() {
    @BindView(R.id.curvedmotion)
    var curvedMotionView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curvedmotion)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        (curvedMotionView!!.drawable as Animatable).start()
    }
}