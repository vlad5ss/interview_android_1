package tylkovich.interview_android_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import tylkovich.interview_android_1.data.ShowImageUrl;
import tylkovich.interview_android_1.recyclerview.MyAdapter;
import tylkovich.interview_android_1.recyclerview.SimpleBlueDivider;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRv;
    MyAdapter mAdapter;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRv = (RecyclerView) findViewById(R.id.recview);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this, ShowImageUrl.getTVShows());
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(new SimpleBlueDivider(this));
    }


}
