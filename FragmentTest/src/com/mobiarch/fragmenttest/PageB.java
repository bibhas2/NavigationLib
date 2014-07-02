package com.mobiarch.fragmenttest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobiarch.android.NavigationFragment;

public class PageB extends NavigationFragment {
	public PageB() {
		setTitle("Page B");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("MOBIARCH", "Page B: onCreateView");
		
		return inflater.inflate(R.layout.page_b, container, false);
	}
}
