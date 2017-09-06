package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bean.MyEntity;
import test.com.commonmethod.R;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/3/24 15:55
 * @desc: recycleView demo
 */

public class FrgRecycleViewDmeo  extends Fragment{
    private RecyclerView recyclerView;
    private ArrayList<MyEntity> myData;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frg_recycle,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        initData();
        LinearLayoutManager ll;
        MyLayoutManager layoutManager = new MyLayoutManager();
        MyAdapter adapter = new MyAdapter();
       // recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    //初始化数据
    private void initData() {
        int size = 30 ;
        myData = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            MyEntity e = new MyEntity();
            e.setStr("str:" + i);
            myData.add(e);
        }
    }

    //自定义Adapter
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_view_item, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MyEntity myEntity = myData.get(position);
            holder.setStr(myEntity.getStr());
        }

        @Override
        public int getItemCount() {
            return myData.size();
        }
    }

    //自定义Holder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView strTv;


        public MyViewHolder(View itemView) {
            super(itemView);
            strTv = (TextView) itemView.findViewById(R.id.str);
        }

        public void setStr(String str) {
            strTv.setText(str);
        }

    }

}
