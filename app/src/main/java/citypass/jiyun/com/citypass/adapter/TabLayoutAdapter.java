package citypass.jiyun.com.citypass.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import citypass.jiyun.com.citypass.control.base.BaseFragment;

/**
 * Created by my on 2017/6/20.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter{

    List<BaseFragment> list;
    List<String> titlelist = new ArrayList<>();

    public TabLayoutAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
        titlelist.add("闹闹帝");
        titlelist.add("闹闹王");
        titlelist.add("闹闹星");
        titlelist.add("广场");
        titlelist.add("话题");
        titlelist.add("推荐");
        titlelist.add("晒图");
        titlelist.add("网友自荐");
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}
