# EazyCore
Code base for Android

Using :
- [ButterKnife](https://github.com/JakeWharton/butterknife)
- [Parceler](https://github.com/johncarl81/parceler)
- [FragmentArgs](https://github.com/sockeqwe/fragmentargs)
- [NoListAdapter](https://github.com/TellH/NoListAdapter)
- [Timber](https://github.com/JakeWharton/timber)

##Structure

There are base classes . They're separated into 3 main parts (activity, fragment, adapter)
- **Activity :**
  - **BaseActivity :** it contains basic functions to manage the life-cycle of the activity.
  - **BaseMainActivity: ** it inherits from `BaseActivity` and manage toolbar, fragments.

- **Fragment :**
  - **BaseFragment :** it's same as `BaseActivity`. It manages the life-cycle of the fragment.
  - **BaseMainFragment :** it inherits from `BaseFragment` and provide the functions to handle toolbar quickly.
  - **BaseMainWithDataFragment :** it inherits from `BaseMainFragment` and provide the functions to push data into `Recyclerview` quickly.

- **Adapter :**
  - **BaseViewBinder :** it's provide the functions to implement `Adapter` into `Recyclerview` quickly.
