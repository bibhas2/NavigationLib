package com.mobiarch.android;

import android.app.Fragment;

public abstract class NavigationFragment extends Fragment {
	private NavigationActivity navigationActivity;
	private String title;

	public NavigationActivity getNavigationActivity() {
		return navigationActivity;
	}
	public void setNavigationActivity(NavigationActivity navigationActivity) {
		this.navigationActivity = navigationActivity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void onResume() {
		super.onResume();
		
		navigationActivity.setTitle(getTitle());
	}
}
