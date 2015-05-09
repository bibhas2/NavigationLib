package com.mobiarch.android;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

public class NavigationActivity extends Activity implements OnBackStackChangedListener  {
	private NavigationFragment rootFragment;
    Fragment topFragment = null;

	protected void onCreate(Bundle savedInstanceState, NavigationFragment rootFragment) {

		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.navigation_activity_layout);
		//Set the root fragment
		getFragmentManager().beginTransaction()
			.add(R.id.navigation_container, rootFragment).commit();
        topFragment = rootFragment;
		//Listen for backstack change events
		getFragmentManager().addOnBackStackChangedListener(this);
		
		this.rootFragment = rootFragment; 
	}

	public void onBackStackChanged() {
		FragmentManager mgr = getFragmentManager();
		int count = mgr.getBackStackEntryCount();
		//If there is nothing in backstack, do not show the Up button
		if (count == 0) {
			getActionBar().setDisplayHomeAsUpEnabled(false);
		}
	}
	
	public void pushFragment(NavigationFragment f) {
		FragmentManager mgr = getFragmentManager();
		FragmentTransaction t = mgr.beginTransaction();

        t.hide(topFragment);
        t.add(R.id.navigation_container, f);
		t.addToBackStack(null);
		t.commit();
		
		//Show the Up button
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	public void popFragment() {
        getFragmentManager().popBackStack();
	}
	@Override
	public boolean onNavigateUp() {
		//When Up button is clicked, pop the backstack
		popFragment();
		
		return true;
	}
}
