package toxm.com.dxt.lxiang1.location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import toxm.com.dxt.lxiang1.R;

import toxm.com.dxt.lxiang1.util.Constants;
import toxm.com.dxt.lxiang1.util.DataCallback;
import toxm.com.dxt.lxiang1.util.HttpUtils;
/**
 * A simple {@link Fragment} subclass.
 */
public class FShouYeFragment extends Fragment{

    public FShouYeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fhome, container, false);
        return view;
    }

}
