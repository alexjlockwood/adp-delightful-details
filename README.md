# adp-delightful-details

## Backwards compatibility

This app uses a `minSdkVersion` of 21. However, much of the functionality can still
be backported to previous API versions. Below is a summary of what is and isn't supported by
`VectorDrawableCompat` and `AnimatedVectorDrawableCompat`:

### What _is_ supported

#### `VectorDrawable` & `AnimatedVectorDrawable`

See [Chris Banes' blog post][chris-banes-vector-blog-post] for more information.

#### `android:tint` & `android:tintMode` in `VectorDrawable` XML

Specifying tints and tint modes in vector drawable XML files works across all platform versions.

#### Theme attributes in `VectorDrawable` XML

Specifying theme attributes (such as `?attr/colorControlNormal`) in vector drawable
XML files works across all platform versions (check out [this blog post][theme-attributes-blog-post]
for more information).

### What _isn't_ supported

#### `AnimatedStateListDrawable`

This is only supported on API 21 and above. However, using it is often not required. Instead of
having the framework automatically trigger the state change, you can simply swap in/out different
animated vector drawables and start them manually.

TODO(alockwood): give an in-depth example

#### `ObjectAnimator` & `android:pathData`

Path morphing is only supported on API 21 and above.

#### `ObjectAnimator` & `android:property{X,Y}Name`

Beginning in API 21, a property in X or Y dimension can be animated along a path.
The properties to animate should be defined in the `android:propertyXName` 
and/or `android:propertyYName` attributes. The values will be taken from the path
specified in the `android:pathData` attribute (and thus, using `android:valueFrom` 
and `android:valueTo` is not necessary). See the "curved motion" and "progress bar" demos
in this sample app for example usages.

These new attributes correspond to the [`ObjectAnimator#ofFloat(Object, String, String, Path)`][ObjectAnimator#ofFloat()] method. 

TODO(alockwood): give possible example of backporting using propertyValuesHolder
(like in [this example code][ObjectAnimator])?

#### Declaring custom `PathInterpolator`s in XML

Declaring custom `PathInterpolator`s in XML is only supported on API 21 and above. Note that 
they can however be constructed programatically on older platform versions using 
[`PathInterpolatorCompat`][PathInterpolatorCompat] from the support library.

#### Using material design style interpolators in XML

Using the new material design interpolators (such as `@android:interpolator/fast_out_slow_in`, etc.)
is only supported on API 21 and above. See the documentation for [`android.R.interpolator`][android.R.interpolator]
for a complete listing of interpolators that can be declared in XML at each platform version. Usually you can get
a pretty similar effect using the decelerate and accelerate interpolators, although it won't be identical.

Note that the newer interpolators can be constructed programatically on older platform versions using
the support library:

* [`FastOutSlowInInterpolator`][FastOutSlowInInterpolator]
* [`FastOutLinearInInterpolator`][FastOutLinearInInterpolator]
* [`LinearOutSlowInInterpolator`][LinearOutSlowInInterpolator]

asdf

  [chris-banes-vector-blog-post]: https://chris.banes.me/2016/02/25/appcompat-vector/
  [theme-attributes-blog-post]: http://www.androiddesignpatterns.com/2016/08/contextcompat-getcolor-getdrawable.html
  [PathInterpolatorCompat]: https://developer.android.com/reference/android/support/v4/view/animation/PathInterpolatorCompat.html
  [FastOutSlowInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/FastOutSlowInInterpolator.html
  [FastOutLinearInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/FastOutLinearInInterpolator.html
  [LinearOutSlowInInterpolator]: https://developer.android.com/reference/android/support/v4/view/animation/LinearOutSlowInInterpolator.html
  [android.R.interpolator]: https://developer.android.com/reference/android/R.interpolator.html
  [ObjectAnimator]: https://developer.android.com/reference/android/animation/ObjectAnimator.html
  [ObjectAnimator#ofFloat()]: https://developer.android.com/reference/android/animation/ObjectAnimator.html#ofFloat(java.lang.Object,%20java.lang.String,%20java.lang.String,%20android.graphics.Path)

