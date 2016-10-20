package aohuan.com.listadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import aohuan.com.listadapter.adapter.CommonAdapter;
import aohuan.com.listadapter.adapter.ViewHolder;

public class MainActivity extends AppCompatActivity {
    private ListView mList;
    private List<TestBean> mStrList = new ArrayList<>();
    private CommonAdapter<TestBean> mAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = (ListView) findViewById(R.id.m_list);
        initData();
        initAdapter();
    }

    private void initData() {
        mStrList.add(new TestBean("张三", "http://p2.so.qhmsg.com/t018b83cc648853f307.jpg"));
        mStrList.add(new TestBean("李四", "http://img4.duitang.com/uploads/item/201305/02/20130502185029_EkKYh.jpeg"));
        mStrList.add(new TestBean("王五","http://img1.touxiang.cn/uploads/20120509/09-014358_953.jpg"));
        mStrList.add(new TestBean("赵六", "http://www.qqw21.com/article/UploadPic/2013-9/2013911764015374.jpg"));
        mStrList.add(new TestBean("田七", "http://www.qqbody.com/uploads/allimg/201308/07-151626_52.jpg"));
    }

    private void initAdapter() {
        mAdapter = new CommonAdapter<TestBean>(MainActivity.this, mStrList, R.layout.layout_test) {
            @Override
            public void convert(ViewHolder helper, final TestBean item, int position) {
                helper.setText(R.id.m_name, item.getName());
                ImageView imageView = helper.getView(R.id.m_image);
                Picasso.with(MainActivity.this).load(item.getIcon()).into(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了"+ item.getName() +"的图像", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        mList.setAdapter(mAdapter);
    }
}
