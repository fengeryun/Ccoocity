package citypass.jiyun.com.citypass.control.fragment.naonao;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import citypass.jiyun.com.citypass.App;
import citypass.jiyun.com.citypass.R;
import citypass.jiyun.com.citypass.adapter.TabLayoutAdapter;
import citypass.jiyun.com.citypass.control.base.BaseFragment;

/**
 * Created by my on 2017/6/20.
 */

public class NaoNaoFragment extends BaseFragment {
    @Bind(R.id.nao_headImg)
    ImageView naoHeadImg;
    @Bind(R.id.mao_photo)
    ImageView maoPhoto;
    @Bind(R.id.nao_title)
    TextView naoTitle;
    @Bind(R.id.nao_tab)
    TabLayout naoTab;
    @Bind(R.id.nao_pag)
    ViewPager naoPag;
    @Bind(R.id.nao_headlayout)
    RelativeLayout naoHeadlayout;
    ArrayList<BaseFragment> list = new ArrayList<>();
    TabLayoutAdapter adapter;
    View view;
    PopupWindow popu;

    @Override
    public void initView(View view) {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_naonao;
    }

    @Override
    public void initData() {

        naoTab.setupWithViewPager(naoPag);
        naoTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        list.add(new NaoNaoListview());
        adapter = new TabLayoutAdapter(getChildFragmentManager(),list);
        naoPag.setAdapter(adapter);
        naoPag.setCurrentItem(3);

    }

    @Override
    public void loadData() {
        view = LayoutInflater.from(App.activity).inflate(R.layout.popuview_nao, null);
        initpopuView(view);
        popu = new PopupWindow(view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
    }

    public void initpopuView(View v) {
        RelativeLayout populayout = (RelativeLayout) v.findViewById(R.id.popu_layout);
        TextView video = (TextView) v.findViewById(R.id.popu_video);
        TextView selectphoto = (TextView) v.findViewById(R.id.popu_photo);
        TextView quxiao = (TextView) v.findViewById(R.id.popu_quxiao);

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                mIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0.5);
                startActivityForResult(mIntent, 1);
            }
        });

        selectphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            }
        });

        populayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popu.dismiss();
            }
        });

        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popu.dismiss();
            }
        });
    }

    @Override
    public void initListener() {

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

    @OnClick({R.id.nao_headImg, R.id.mao_photo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nao_headImg:
                break;
            case R.id.mao_photo:
                popu.showAsDropDown(naoHeadlayout, 0, 0);
                break;
        }
    }

}
