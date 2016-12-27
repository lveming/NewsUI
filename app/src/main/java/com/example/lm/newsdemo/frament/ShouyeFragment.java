package com.example.lm.newsdemo.frament;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lm.newsdemo.R;

public class ShouyeFragment extends Fragment {

 
  public static ShouyeFragment newInstance(String param1) {
    ShouyeFragment fragment = new ShouyeFragment();
    Bundle args = new Bundle();
    args.putString("agrs1", param1);
    fragment.setArguments(args);
    return fragment;
  }
 
  public ShouyeFragment() {
 
  }
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
 
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_shouye, container, false);
    Bundle bundle = getArguments();
    String agrs1 = bundle.getString("agrs1");
    TextView tv = (TextView)view.findViewById(R.id.id_fragment_shouye_textView);
    tv.setText(agrs1);
    return view;
  }
 
 
 
}