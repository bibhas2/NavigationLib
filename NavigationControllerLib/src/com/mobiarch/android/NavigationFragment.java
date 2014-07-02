package com.mobiarch.android;

import android.app.Fragment;

public abstract class NavigationFragment extends Fragment {
	private String title;

	public NavigationActivity getNavigationActivity() {
		return (NavigationActivity) getActivity();
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
		//Set the title of the activity to the top most fragment in the stack
		getNavigationActivity().setTitle(getTitle());
	}
}
