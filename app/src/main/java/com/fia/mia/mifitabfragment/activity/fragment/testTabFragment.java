package com.fia.mia.mifitabfragment.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fia.mia.mifitabfragment.R;
import com.fia.mia.mifitabfragment.activity.MainActivity;
import com.fia.mia.mifitablibrary.fragment.TabFragment;


public class testTabFragment extends TabFragment implements View.OnClickListener{


	private ViewGroup rootView;

	private TextView mTab1Text;
	private TextView mTab2Text;
	private TextView mTab3Text;
	private TextView mTab4Text;
	private TextView mTabViewArray[] = {mTab1Text,mTab2Text,mTab3Text,mTab4Text};


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = (ViewGroup)inflater.inflate(R.layout.test_tab_layout, null);

		mTab1Text = (TextView)rootView.findViewById(R.id.tab_1_text);
		mTab2Text = (TextView)rootView.findViewById(R.id.tab_2_text);
		mTab3Text = (TextView)rootView.findViewById(R.id.tab_3_text);
		mTab4Text = (TextView)rootView.findViewById(R.id.tab_4_text);

		mTab1Text.setOnClickListener(this);
		mTab2Text.setOnClickListener(this);
		mTab3Text.setOnClickListener(this);
		mTab4Text.setOnClickListener(this);

		mTabViewArray[0] = mTab1Text;
		mTabViewArray[1] = mTab2Text;
		mTabViewArray[2] = mTab3Text;
		mTabViewArray[3] = mTab4Text;

		return rootView;
	}


	@Override
	public void onClick(View v) {
		TabClick(v);
	}

	public synchronized void TabClick(View v){
		setTabClickOn(v);
		((MainActivity)getActivity()).setContentText(((TextView) v).getText().toString());
		for(TextView offTv:mTabViewArray){
			if(offTv != v) {
				setTabClickOff(offTv);
			}
		}
	}
}
