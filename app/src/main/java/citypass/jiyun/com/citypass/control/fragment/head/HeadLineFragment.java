package citypass.jiyun.com.citypass.control.fragment.head;

import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import citypass.jiyun.com.citypass.R;
import citypass.jiyun.com.citypass.control.bbs.base.BaseFragment;

/**
 * t头条
 * Created by 123 on 2017/6/19.
 */

public class HeadLineFragment extends BaseFragment {
    ListView listView;
    ScrollView scrollView;
    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_headline;

    }

    @Override
    public void initData() {
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean onBackClick() {
        return false;
    }
}
