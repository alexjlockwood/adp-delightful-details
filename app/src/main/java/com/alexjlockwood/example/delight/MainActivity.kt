package com.alexjlockwood.example.delight

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.SparseArray
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    companion object {
        private val LIST_ITEM_TO_ACTIVITY_MAP = SparseArray<Class<*>>()

        init {
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.animals, AnimalsActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.checkable, CheckableActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.clock, ClockActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.countdown, CountdownActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.curvedmotion, CurvedMotionActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.downloading, DownloadingActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.fingerprint, FingerprintActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.handwriting, HandwritingActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.music, MusicActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.pathmorph, PathMorphActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.playpausestop, PlayPauseStopActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.progressbar, ProgressBarActivity::class.java)
            LIST_ITEM_TO_ACTIVITY_MAP.put(R.id.trimclip, TrimClipActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.animals, R.id.checkable, R.id.clock, R.id.countdown, R.id.curvedmotion, R.id.downloading, R.id.fingerprint, R.id.handwriting, R.id.music, R.id.pathmorph, R.id.playpausestop, R.id.progressbar, R.id.trimclip)
    fun onListItemClick(view: View) {
        startActivity(Intent(this, LIST_ITEM_TO_ACTIVITY_MAP[view.id]))
    }
}