package toxm.com.dxt.zmovie.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toxm.com.dxt.zmovie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieRootFragment extends BaseCompatFragment {
    public static MovieRootFragment newInstance(){
        Bundle args = new Bundle();
        MovieRootFragment fragment = new MovieRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MovieRootFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_root, container, false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie_root;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

}
