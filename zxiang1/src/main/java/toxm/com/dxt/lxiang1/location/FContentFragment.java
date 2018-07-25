package toxm.com.dxt.lxiang1.location;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import toxm.com.dxt.lxiang1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FContentFragment extends Fragment {
    int pos;
    String textView;

    public FContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
        TextView tv=new TextView(getContext());
        Bundle arguments = getArguments();
        String text = arguments.getString("text");
        tv.setText(text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fcontent, container, false);
        switch (pos) {
            case 0:
                getChildFragmentManager().beginTransaction().replace(R.id.tab_container, new FGuanZhuFragment()).commit();
                break;
            case 1:
                getChildFragmentManager().beginTransaction().replace(R.id.tab_container, new FTuiJianFragment()).commit();
                break;
            case 2:
                getChildFragmentManager().beginTransaction().replace(R.id.tab_container, new FShouYeFragment()).commit();
                break;
        }
        return view;
    }

}
