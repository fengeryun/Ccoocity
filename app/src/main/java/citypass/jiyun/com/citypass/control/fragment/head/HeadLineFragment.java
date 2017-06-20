package citypass.jiyun.com.citypass.control.fragment.head;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.nineoldandroids.view.ViewHelper;

import citypass.jiyun.com.citypass.R;
import citypass.jiyun.com.citypass.control.bbs.base.BaseFragment;
import citypass.jiyun.com.citypass.control.sideslip.view.DragLayout;

/**
 * t头条
 * Created by 123 on 2017/6/19.
 */

public class HeadLineFragment extends BaseFragment {

    ListView listView;
    ScrollView scrollView;
    DragLayout dl;
    ImageView imageView;
    OthClik othClik;

    @Override
    public void initView(View view) {

        dl = (DragLayout) view.findViewById(R.id.dl);
        imageView = (ImageView) view.findViewById(R.id.headImg);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_headline;

    }

    @Override
    public void initData() {
        othClik = new OthClik();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        dl.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {

            }

            @Override
            public void onClose() {

            }

            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(imageView,1-percent);
            }
        });
        imageView.setOnClickListener(othClik);

    }

    @Override
    public boolean onBackClick() {
        return false;
    }


    private class  OthClik implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            dl.open();
        }
    }
}
