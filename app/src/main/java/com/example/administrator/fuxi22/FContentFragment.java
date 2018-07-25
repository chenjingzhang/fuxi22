package com.example.administrator.fuxi22;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FContentFragment extends Fragment {
    int pos = 0;
    public FContentFragment() {
        // Required empty public constructor
    }
  //接收数据
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos =  getArguments().getInt(Constant.POS);
    }
    //加载类

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
       switch (pos){
           case 0:
               getChildFragmentManager().beginTransaction().replace(R.id.container,new FHomeFragment()).commit();
               break;
           case 1:
               getChildFragmentManager().beginTransaction().replace(R.id.container,new FmyFragment()).commit();
               break;
           case 2:
               getChildFragmentManager().beginTransaction().replace(R.id.container,new FClasslfyFragment()).commit();
               break;
       }
        return view;
    }
}
