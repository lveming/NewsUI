package com.example.lm.newsdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/27.
 */

public class NewsPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] imgRes;

    public NewsPagerAdapter(Context mContext, int[] imgRes) {
        this.mContext = mContext;
        this.imgRes = imgRes;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
//        ImageView view = new ImageView(mContext);
//        view.setImageResource(imgRes[position%imgRes.length]);
//        container.addView(view);
//        return view;
        //对ViewPager页号求模取出View列表中要显示的项
        position %= imgRes.length;
        if (position<0){
            position = imgRes.length+position;
        }
        ImageView view = new ImageView(mContext);
        view.setImageResource(imgRes[position]);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent vp =view.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(view);
        }
        container.addView(view);
        //add listeners here if necessary
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);
    }



}
