package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class PathMorphActivity : AppCompatActivity() {
    @BindView(R.id.drawer)
    var drawerView: ImageView? = null

    @BindView(R.id.crosstick)
    var crossTickView: ImageView? = null

    @BindView(R.id.plusminus)
    var plusMinusView: ImageView? = null

    @BindView(R.id.arrowoverflow)
    var arrowoverflowView: ImageView? = null
    private var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pathmorph)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        isChecked = !isChecked
        val stateSet = intArrayOf(android.R.attr.state_checked * if (isChecked) 1 else -1)
        drawerView!!.setImageState(stateSet, true)
        crossTickView!!.setImageState(stateSet, true)
        plusMinusView!!.setImageState(stateSet, true)
        arrowoverflowView!!.setImageState(stateSet, true)
    }
}