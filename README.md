# adp-delightful-details

This repository accompanies a blog post I wrote on [Android Design Patterns](http://www.androiddesignpatterns.com/2016/11/introduction-to-icon-animation-techniques.html) on animated icons.

It contains over **25 `AnimatedVectorDrawable`s** that you can refer to free of charge. You know... cool animated icons like these!

![Example animated vector drawables](http://i.imgur.com/0aFdjJn.gif)

...or these!

![Another example animated vector drawable](http://i.imgur.com/ybpVE65.gif)

...or this!

![Another example animated vector drawable](http://i.imgur.com/IG7YxHD.gif)

...and also this!

![Another example animated vector drawable](http://i.imgur.com/4UsNhqV.gif)

...and a bunch of others too!

Additional icon implementations are welcome if you've written anything cool that you want to share... submit a pull request! :)

## Some notes on backwards compatibility

1. `VectorDrawableCompat` and `AnimatedVectorDrawableCompat` can be used on pre-Lollipop devices. Read [Chris Banes' blog post][chris-banes-vector-blog-post] for more information. Note that even if an app uses a `minSdkVersion` of 21, it is still advantageous to use the `VectorDrawableCompat` support library implementation (as it backports new features and fixes some framework bugs that existed on API versions 21-23). Also note that you'll need to assign your vector drawables to your `ImageView`s using `app:srcCompat="@drawable/my_vd_or_avd"`.

2. Specifying tints, tint modes and/or theme attributes in `VectorDrawableCompat` XML **is supported** on all platform versions. Read [this blog post](http://www.androiddesignpatterns.com/2016/08/contextcompat-getcolor-getdrawable.html) for more information.

3. `AnimatedStateListDrawable` **is supported** on pre-Lollipop devices if you use support lib v28 or above. Under-the-hood, an `AnimatedStateListDrawableCompat` will be inflated instead.

  [chris-banes-vector-blog-post]: https://chris.banes.me/2016/02/25/appcompat-vector/
  [theme-attributes-blog-post]: http://www.androiddesignpatterns.com/2016/08/contextcompat-getcolor-getdrawable.html
  [PathInterpolatorCompat]: https://developer.android.com/reference/android/support/v4/view/animation/PathInterpolatorCompat.html
  [FastOutSlowInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/FastOutSlowInInterpolator.html
  [FastOutLinearInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/FastOutLinearInInterpolator.html
  [LinearOutSlowInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/LinearOutSlowInInterpolator.html
  [android.R.interpolator]: https://developer.android.com/reference/android/R.interpolator.html
  [ObjectAnimator]: https://developer.android.com/reference/android/animation/ObjectAnimator.html
  [ObjectAnimator#ofFloat()]: https://developer.android.com/reference/android/animation/ObjectAnimator.html#ofFloat(java.lang.Object,%20java.lang.String,%20java.lang.String,%20android.graphics.Path)

