package com.mobiarch.fragmenttest;

import android.os.Bundle;

import com.mobiarch.android.NavigationActivity;

public class MainActivity extends NavigationActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new PageA());
	}
}
