package com.mobiarch.fragmenttest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobiarch.android.NavigationFragment;

public class PageA extends NavigationFragment {
	public PageA() {
		setTitle("Page A");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("MOBIARCH", "Page A: onCreateView");
		
		View v = inflater.inflate(R.layout.page_a, container, false);
		
		Button b = (Button) v.findViewById(R.id.openButton);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("MOBIARCH", "Opening fragment B");
				getNavigationActivity().pushFragment(new PageB());
			}
		});
		return v;
	}
}
