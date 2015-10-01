package com.fia.mia.mifitabfragment.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fia.mia.mifitabfragment.R;


public class ContentFragment extends Fragment{


	private ViewGroup rootView;

	private TextView mTv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = (ViewGroup)inflater.inflate(R.layout.content_layout, null);

		mTv = (TextView)rootView.findViewById(R.id.tv);

		return rootView;
	}


	public void setContent(String text){
		mTv.setText(text);
	}

}
