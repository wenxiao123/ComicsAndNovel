package com.collection.comicsandnovel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.collection.comicsandnovel.adapter.BottomTitleAdapter;
import com.collection.comicsandnovel.wight.WrapContentLinearLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    BottomTitleAdapter bottomTitleAdapter;

    @BindView(R.id.title_bottom)
    RecyclerView recyclerView_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLisition();
    }

    private void initLisition() {
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager=new WrapContentLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_bottom.setLayoutManager(wrapContentLinearLayoutManager);
    }
}
