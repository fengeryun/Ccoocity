package citypass.jiyun.com.citypass.control.activity;

import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import citypass.jiyun.com.citypass.R;
import citypass.jiyun.com.citypass.control.base.BaseActivity;
import citypass.jiyun.com.citypass.control.base.BaseFragment;
import citypass.jiyun.com.citypass.control.fragment.head.HeadLineFragment;
import citypass.jiyun.com.citypass.control.fragment.naonao.NaoNaoFragment;
import citypass.jiyun.com.citypass.control.tools.FragmentBuilder;
import citypass.jiyun.com.citypass.control.tools.LogToastUtils;

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
    long firsttime;
    int num = 1;

    @Override
    public int getViewId() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        FragmentBuilder.getInstance().start(R.id.home_framelayout, HeadLineFragment.class,true);
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
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_headbut, R.id.home_naobut, R.id.home_locationbut, R.id.home_lifebut, R.id.home_findbut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_headbut:
                FragmentBuilder.getInstance().start(R.id.home_framelayout,HeadLineFragment.class,true);
                break;
            case R.id.home_naobut:
                FragmentBuilder.getInstance().start(R.id.home_framelayout,NaoNaoFragment.class,true);
                break;
            case R.id.home_locationbut:
                break;
            case R.id.home_lifebut:
                break;
            case R.id.home_findbut:
                break;
        }
    }

    @Override
    public void onBackPressed() {

        FragmentManager message = getSupportFragmentManager();
        String lastback  = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        if(lastback.equals("HeadLineFragment") || lastback.equals("NaoNaoFragment")){
            if(num<2){
                firsttime = System.currentTimeMillis();
                LogToastUtils.getInstance().showToasts("再次点击退出应用");
                num++;
            }else {
                if(System.currentTimeMillis()-firsttime>2000){
                    firsttime = System.currentTimeMillis();

                    LogToastUtils.getInstance().showToasts("再次点击退出应用");
                }else {
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                }
            }

        }else {

            message.popBackStackImmediate();   //立即弹栈
            String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
            Log.e("--------------lastname",lastname);
            BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
            FragmentBuilder.getInstance().setLastFragment(fragment);

        }

    }
}
