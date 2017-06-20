package citypass.jiyun.com.citypass.control.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.OnClick;
import citypass.jiyun.com.citypass.R;
import citypass.jiyun.com.citypass.control.base.BaseActivity;
import citypass.jiyun.com.citypass.control.fragment.head.HeadLineFragment;
import citypass.jiyun.com.citypass.control.tools.FragmentUtils;

public class HomeActivity extends BaseActivity {

    @Bind(R.id.home_framelayout)
    FrameLayout homeFramelayout;
    @Bind(R.id.home_headbut)
    RadioButton homeHeadbut;
    @Bind(R.id.home_naobut)
    RadioButton homeNaobut;
    @Bind(R.id.home_locationbut)
    RadioButton homeLocationbut;
    @Bind(R.id.home_lifebut)
    RadioButton homeLifebut;
    @Bind(R.id.home_findbut)
    RadioButton homeFindbut;
    @Bind(R.id.home_radiogroup)
    RadioGroup homeRadiogroup;
    @Bind(R.id.activity_home)
    RelativeLayout activityHome;

    @Override
    public int getViewId() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        FragmentUtils.addFragment(getSupportFragmentManager(), new HeadLineFragment(), R.id.home_framelayout);
    }

    @Override
    public void loadData() {
//续少杰
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }


    @OnClick({R.id.home_headbut, R.id.home_naobut, R.id.home_locationbut, R.id.home_lifebut, R.id.home_findbut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_headbut:

                break;
            case R.id.home_naobut:

                break;
            case R.id.home_locationbut:

                break;
            case R.id.home_lifebut:

                break;
            case R.id.home_findbut:


                break;
        }
    }
}
