package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.TopRecyclerViewAdapter;
import test.com.commonmethod.R;


/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/3/24 19:44
 * @desc:
 */

public class FrgMuiItem extends Fragment {

    private RecyclerView tRecyclerView;

    private List<Integer> typeList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_muiitem, null);
        initParam();
        initView(v);
        return v;
    }
    private void initParam() {
        typeList.add(2);
        typeList.add(3);
        typeList.add(3);
        typeList.add(2);
        typeList.add(3);
    }

    private void initView(View view) {
        tRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerview);
        TopRecyclerViewAdapter adapter = new TopRecyclerViewAdapter(getActivity(), typeList);
        tRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tRecyclerView.setHasFixedSize(false);
        tRecyclerView.setAdapter(adapter);
    }
}
