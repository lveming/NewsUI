package com.example.lm.newsdemo.frament;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lm.newsdemo.R;
import com.example.lm.newsdemo.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

  private Banner mBanner;
  List<String> images=new ArrayList<>();
  List<String> titles=new ArrayList<>();

  public static NewsFragment newInstance(String param1) {
    NewsFragment fragment = new NewsFragment();
    Bundle args = new Bundle();
    args.putString("agrs1", param1);
    fragment.setArguments(args);
    return fragment;
  }

  public NewsFragment() {
 
  }
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_news, container, false);
    Bundle bundle = getArguments();
    String agrs1 = bundle.getString("agrs1");
    TextView tv = (TextView)view.findViewById(R.id.id_fragment_news_textView);
    tv.setText(agrs1);

    mBanner= (Banner) view.findViewById(R.id.banner);
    initDate();
    initBanner();
    return view;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);


  }
  private void initDate() {
    images.add("http://img4.hao123.com/data/desktop/9b971921cf99deb8e1504440963ed027_1366_768");
    images.add("http://img1.hao123.com/data/desktop/969fdd9fbbcf7db65300be6907efafea_1366_768");
    images.add("http://img6.hao123.com/data/desktop/cc0eadd69eb31f5c2530df7dc824ee7b_1366_768");
    images.add("http://img.hao123.com/data/desktop/2b5c0d84e5422f758d18dc4ed447f8bd_1366_768");
    images.add("http://img1.hao123.com/data/desktop/1a379d62eff117ee8548343ad9819d07_1366_768");
    images.add("http://img1.hao123.com/data/desktop/933f195b9f4f445a183e261c0dc2d1a4_1366_768");
    for (int i = 0; i < images.size(); i++) {
      titles.add("文本"+(i+1));
    }

  }

  private void initBanner() {
    //设置banner样式
    mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
    //设置图片加载器
    mBanner.setImageLoader(new GlideImageLoader());
    //设置图片集合
    mBanner.setImages(images);
    //设置banner动画效果
    mBanner.setBannerAnimation(Transformer.DepthPage);
    //设置标题集合（当banner样式有显示title时）
    mBanner.setBannerTitles(titles);
    //设置自动轮播，默认为true
    mBanner.isAutoPlay(true);
    //设置轮播时间
    mBanner.setDelayTime(3000);
    //设置指示器位置（当banner模式中有指示器时）
    mBanner.setIndicatorGravity(BannerConfig.CENTER);
    //banner设置方法全部调用完毕时最后调用
    mBanner.start();
  }

  //如果你需要考虑更好的体验，可以这么操作
  @Override
  public void onStart() {
    super.onStart();
    //开始轮播
    mBanner.startAutoPlay();
  }

  @Override
  public void onStop() {
    super.onStop();
    //结束轮播
    mBanner.stopAutoPlay();
  }
}