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

This sample app uses a `minSdkVersion` of 21. However, there is a good amount of stuff in here that could still
be used on older platform versions:

1. `VectorDrawableCompat` and `AnimatedVectorDrawableCompat` can for the most part be used on pre-Lollipop devices with a couple of restrictions (continue reading below). Read [Chris Banes' blog post][chris-banes-vector-blog-post] for more information. Note that even though this app uses a `minSdkVersion` of 21, it is still advantageous to use the `VectorDrawableCompat` support library implementation (as it fixes some framework bugs that existed on API versions 21-22).

2. Specifying tints, tint modes and/or theme attributes in `VectorDrawable` XML **is supported** on all platform versions. Read [this blog post](http://www.androiddesignpatterns.com/2016/08/contextcompat-getcolor-getdrawable.html) for more information.

3. `AnimatedStateListDrawable` is **not supported** on pre-Lollipop devices. However, it is only being used in this project for convenience and is not strictly required (not using it just means you'll need to manually start the `AnimatedVectorDrawable`s yourself).

4. Path morphing (i.e. animating the `android:pathData` attribute using an `ObjectAnimator`) is **not supported** on pre-Lollipop devices. Sorry!

5. Using the `android:property{X,Y}Name` attributes in an `ObjectAnimator`'s XML is **not supported** on pre-Lollipop devices. These new attributes correspond to the [`ObjectAnimator#ofFloat(Object, String, String, Path)`][ObjectAnimator#ofFloat()] method, which was only added in API 21.

6. Defining custom `PathInterpolator`s in XML is **not supported** on pre-Lollipop devices.

7. Using the new material design interpolators (such as `@android:interpolator/fast_out_slow_in`, etc.) is **not supported** on pre-Lollipop devices. See the documentation for [`android.R.interpolator`][android.R.interpolator] for a complete listing of interpolators that can be declared in XML at each platform version. Usually you can get a pretty similar effect using the decelerate and accelerate interpolators, although it won't be identical.

  [chris-banes-vector-blog-post]: https://chris.banes.me/2016/02/25/appcompat-vector/
  [theme-attributes-blog-post]: http://www.androiddesignpatterns.com/2016/08/contextcompat-getcolor-getdrawable.html
  [PathInterpolatorCompat]: https://developer.android.com/reference/android/support/v4/view/animation/PathInterpolatorCompat.html
  [FastOutSlowInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/FastOutSlowInInterpolator.html
  [FastOutLinearInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/FastOutLinearInInterpolator.html
  [LinearOutSlowInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/LinearOutSlowInInterpolator.html
  [android.R.interpolator]: https://developer.android.com/reference/android/R.interpolator.html
  [ObjectAnimator]: https://developer.android.com/reference/android/animation/ObjectAnimator.html
  [ObjectAnimator#ofFloat()]: https://developer.android.com/reference/android/animation/ObjectAnimator.html#ofFloat(java.lang.Object,%20java.lang.String,%20java.lang.String,%20android.graphics.Path)

