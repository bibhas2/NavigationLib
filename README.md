#Overview
Android provides two ways of doing navigation:

1. Using activities. In this scheme, your code launches new activity to move forward. User clicks the back button to move back in the stack.
2. Using fragment backstack. In this scheme, you add a new fragment to the activity's and then push the current state to the back stack. User clicks the back button to pop the back state to go back to the previous state. This effectively removes the top most (last added) fragment.

The fragment based approach works faster since new activities are not 
created and destroyed as you move forward and backward respectively. 
This approach also closely resembles the way iOS UINavigationController works. Except, it is important to note that in Android you maintain a stack of state and not actual fragments. Each state maintains a list of fragments currently added to the activity and their visibility status.

The purpose of this library is to fill in a few holes left in the fragment API
to fully implement a fragment based navigation. These missing features are:
	- Show an Up (or Back) button on top left corner of the action bar if back stack can be navigated back.
	- Pop the back stack when the Up button is clicked.
	- Hide the last added fragment when a new fragment is added. Otherwise the previously added fragments will be still visible and accept user input.
	- Change the title shown on the action bar based on the fragment that is at the top of the stack.

##Usage
To create a fragment class, extend NavigationFragment. 

```java
public class PageA extends NavigationFragment {
        public PageA() {
                setTitle("Page A");
        }
	public View onCreateView(...) {
		...
	}
}
```

Here, we set the title of the fragment to ``"Page A"``. Whenever this fragment is
shown at the top of the stack, this title will be displayed on the action bar.

The activity class must extend ``NavigationActivity``. The ``onCreate()`` method
of ``NavigationActivity`` takes the root fragment of the navigation.

```java
public class MainActivity extends NavigationActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState, new PageA());
        }
}
```

To push a new fragment to the top of the stack, call 
``pushFragment(NavigationFragment f)`` of the ``NavigationActivity`` class. 
A fragment can obtain it's parent ``NavigationActivity`` by calling 
``getNavigationActivity()`` of ``NavigationFragment``.
