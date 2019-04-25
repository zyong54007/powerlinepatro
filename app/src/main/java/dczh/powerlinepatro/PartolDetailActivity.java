package dczh.powerlinepatro;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import dczh.Util.MathUtil;
import dczh.adapter.TowerAccountAdapter;
import dczh.adapter.TowerPartoImageAdapter;
import dczh.model.LineTowerModel;
import dczh.model.TowerAccountItemModel;
//巡视详情
public class PartolDetailActivity extends BaseAppCompatActivity {
    RecyclerView mRecyclerView_item;
    RecyclerView mRecyclerView_image;
    LineTowerModel model;
    TowerAccountAdapter mAapter;
    TowerPartoImageAdapter mPatroAdapter;
    private static final String ARG_PARAM1 = "param1";

    List<Integer> colorList = new ArrayList<>();
    List<TowerAccountItemModel> list = new ArrayList<TowerAccountItemModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partol_detail);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null && actionBar != null)
        {
            model = (LineTowerModel)bundle.getSerializable(ARG_PARAM1);
            setCustomTitle(model.getTowerName(), true);
        }

        mRecyclerView_item = findViewById(R.id.recyler_tower_patrol);
        mRecyclerView_item.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView_item.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView_image = findViewById(R.id.recyler_tower_image);
        GridLayoutManager layoutManage = new GridLayoutManager(this, 3);
        mRecyclerView_image.setLayoutManager(layoutManage);

        TowerAccountItemModel model1 = new TowerAccountItemModel(getString(R.string.string_partol_worker)+"张三","");
        TowerAccountItemModel model2 = new TowerAccountItemModel(getString(R.string.string_partol_detail),"");

        list.add(model1);
        list.add(model2);

        mAapter = new TowerAccountAdapter(list);
        mRecyclerView_item.setAdapter(mAapter);

        for (int i = 0;i<6;i++){
            int color =  Color.rgb((int) MathUtil.nextDouble(0,255), (int)MathUtil.nextDouble(0,255), (int)MathUtil.nextDouble(0,255));
            colorList.add(color);
        }
        mPatroAdapter = new TowerPartoImageAdapter(colorList);
        mRecyclerView_image.setAdapter(mPatroAdapter);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.blank_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}