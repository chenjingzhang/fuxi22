package toxm.com.dxt.lxiang1.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import toxm.com.dxt.lxiang1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadChildFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private boolean isPrepared;
    MainReadContentData contentData;
    int pos;
    ListView listView;
    ReadContentAdapter readContentAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
        contentData = getArguments().getParcelable("content");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_child, container, false);
        listView = view.findViewById(R.id.read_listView_home);
        listView.setOnItemClickListener(this);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        MainReadContentData.DataBean.SerialBean serialBean = contentData.getData().getSerial().get(pos);
        MainReadContentData.DataBean.QuestionBean questionBean = contentData.getData().getQuestion().get(pos);
        MainReadContentData.DataBean.EssayBean essayBean = contentData.getData().getEssay().get(pos);
        List<MainReadBean> objList = new ArrayList<>();

        MainReadBean readBean = new MainReadBean();
        readBean.setType(0);
        readBean.setOo(essayBean);
        objList.add(readBean);

        MainReadBean readBean2 = new MainReadBean();
        readBean2.setType(1);
        readBean2.setOo(serialBean);
        objList.add(readBean2);

        MainReadBean readBean3 = new MainReadBean();
        readBean3.setType(2);
        readBean3.setOo(questionBean);
        objList.add(readBean3);
        readContentAdapter = new ReadContentAdapter(objList, getActivity());
        listView.setAdapter(readContentAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
