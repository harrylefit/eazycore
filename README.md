# EazyCore
Code base for Android

**What is MVP ?**
=============
 - **View :** is a layer that displays data and reacts to user actions. On
   Android, this could be an Activity, a Fragment, an android.view.View
   or a Dialog.
 - **Model :** is a data access layer such as database API or remote server API.
 - **Presenter:** is a layer that provides View with data from Model. Presenter also handles background tasks.

 ----------

 Android MVP is a way to separate Business logic from activities/views/fragments to make them independent of most lifecycle-related events. This way an application becomes simpler, overall application reliability increases up to 10 times, application code becomes shorter, code maintainability becomes better and developer's life becomes happier.

 A sample Android app using the MVP architecture, using :
- [ButterKnife](https://github.com/JakeWharton/butterknife)
- [Parceler](https://github.com/johncarl81/parceler)
- [FragmentArgs](https://github.com/sockeqwe/fragmentargs)
- [NoListAdapter](https://github.com/TellH/NoListAdapter)
- [Timber](https://github.com/JakeWharton/timber)
