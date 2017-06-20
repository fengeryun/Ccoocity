package citypass.jiyun.com.citypass.control.bbs;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import citypass.jiyun.com.citypass.R;
import citypass.jiyun.com.citypass.control.bbs.base.BaseFragment;
import citypass.jiyun.com.citypass.control.bbs.base.CommonAdapter;
import citypass.jiyun.com.citypass.control.bbs.base.MRecyclerView;
import citypass.jiyun.com.citypass.control.bbs.base.ViewHolder;


/**
 * Created by Daddy on 2017/6/19.
 */

public class BbsFragment extends BaseFragment {
    @Override
    public void initView(final View view) {
    }

    @Override
    public int getLayoutId() {
        return R.layout.bbs_home_fragment;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
