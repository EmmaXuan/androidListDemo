package com.emma.recyclerviewdatademo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.emma.recyclerviewdatademo.dataModel.viewHolder.main.ListItemViewHolder;
import com.emma.recyclerviewdatademo.dataModel.vo.ListItemVo;
import com.emma.recyclerviewdatademo.databinding.ActivityMainBinding;
import com.emma.recyclerviewdatademo.ui.recylerView.CustomAdapter;

import java.util.ArrayList;

import static com.emma.recyclerviewdatademo.BR.itemVo;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private CustomAdapter adapter;

    private ArrayList<ListItemVo> listItemVos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //databinding綁定對應的layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        listItemVos.add(new ListItemVo("HI","你是誰",true));
        listItemVos.add(new ListItemVo("HI","是我",false));
        listItemVos.add(new ListItemVo("HI","4你",true));
        listItemVos.add(new ListItemVo("HI","是0",true));
        listItemVos.add(new ListItemVo("HI","40",true));
        listItemVos.add(new ListItemVo("HI","4我",true));

        adapter = new CustomAdapter(listItemVos,R.layout.layout_list_item,itemVo) {
            @Override
            public RecyclerView.ViewHolder viewHolder(ViewDataBinding viewDataBinding) {
                return new ListItemViewHolder(viewDataBinding,MainActivity.this);
            }

            @Override
            public void convertViewHolder(RecyclerView.ViewHolder holder, Object o) {
                ((ListItemViewHolder) holder).setBinding(variableId, o);
            }
        };

        setRecycleView();

    }

    private void setRecycleView(){
        // init recycleView
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.listView.setLayoutManager(layoutManager);
        binding.listView.setAdapter(adapter);
    }

    public void showNowClick(String click){
        binding.nowClick.setText("now click:"+click);
    }

    public void notifyList(){
        adapter.notifyDataSetChanged();
    }
}
