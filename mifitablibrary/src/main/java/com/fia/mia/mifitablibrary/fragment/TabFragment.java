package com.fia.mia.mifitablibrary.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

import com.fia.mia.mifitablibrary.R;


public class TabFragment extends Fragment implements View.OnClickListener{


	private ViewGroup rootView;

	private TextView mTab1Text;
	private TextView mTab2Text;
	private TextView mTabViewArray[] = {mTab1Text,mTab2Text};


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = (ViewGroup)inflater.inflate(R.layout.tab_layout, null);

		return rootView;
	}


	@Override
	public void onClick(View v) {
		TabClick(v);
	}

	public synchronized void TabClick(View v){
		setTabClickOn(v);
		for(TextView offTv:mTabViewArray){
			if(offTv != v) {
				setTabClickOff(offTv);
			}
		}
	}

	public void setTabClickOn(View v){
		if(!v.isSelected()) {
			ButtonOn(v, R.drawable.tab_blue_on);
		}
	}

	public void setTabClickOff(View v){
		if(v.isSelected()) {
			ButtonOff(v, R.drawable.tab_blue_bg);
		}
	}


	private boolean isOning = false;
	private  void ButtonOn(final View v, int resId){
		if(isOning)
			return;

		v.setBackgroundResource(resId);
		Animation anim = new OpenAnimation(v, true);
		anim.setDuration(200);
		anim.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				isOning = true;
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				if(v instanceof TextView) {
					v.setSelected(true);
					((TextView) v).setTextColor(Color.parseColor("#ffffffff"));
				}
				isOning = false;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		v.startAnimation(anim);
	}

	boolean isOffing = false;
	private  void ButtonOff(final View v, final int resId){
		if(isOffing)
			return;

		Animation anim = new OpenAnimation(v, false);
		anim.setDuration(200);
		anim.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				isOffing = true;
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				if(v instanceof TextView) {
					v.setSelected(false);
					v.setBackgroundResource(resId);
					((TextView) v).setTextColor(Color.parseColor("#99ffffff"));
				}
				isOffing = false;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		v.startAnimation(anim);
	}


	private class OpenAnimation extends Animation {
		private int startHeight;
		private int endHeight;
		private View view1;
		private float scale = 1.5f;

		public OpenAnimation(View view1, boolean on) {
			this.view1 = view1;
			this.startHeight = view1.getLayoutParams().height;

			if(on) {
				this.endHeight = (int) ((float) view1.getLayoutParams().height * (float) scale);
			}else {
				this.endHeight = (int) ((float) view1.getLayoutParams().height / (float) scale);
			}

		}

		@Override
		protected void applyTransformation(float interpolatedTime, Transformation t) {
			if(interpolatedTime < 1.0f) {
				int reHeight = startHeight - (int) ((startHeight - endHeight) * interpolatedTime);
				view1.getLayoutParams().height = reHeight;
				view1.requestLayout();
			}
		}
	}


}
