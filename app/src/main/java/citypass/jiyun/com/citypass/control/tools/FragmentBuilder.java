package citypass.jiyun.com.citypass.control.tools;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import citypass.jiyun.com.citypass.App;
import citypass.jiyun.com.citypass.control.base.BaseFragment;


/**
 *
 * Fragment  跳转
 * Created by my on 2017/5/13.
 */

public class FragmentBuilder {
    private static FragmentBuilder instance;
    BaseFragment fragment;
    BaseFragment lastFragment;
    FragmentManager manager;
    FragmentTransaction trans;
    String fragname;


    private FragmentBuilder(){
        manager = App.activity.getSupportFragmentManager();
    }
    public static FragmentBuilder getInstance(){
        if(instance == null){
            synchronized (FragmentBuilder.class){
                if(instance == null){
                    instance = new FragmentBuilder();
                }
            }
        }
        return instance;
    }

    public FragmentBuilder start(int fragLayout , Class<? extends BaseFragment> fragmentClass,boolean isback){
        trans = manager.beginTransaction();
        fragname = fragmentClass.getSimpleName();
        fragment = (BaseFragment) manager.findFragmentByTag(fragname);

        if(fragment == null){
            try {
                fragment = fragmentClass.newInstance();
                trans.add(fragLayout,fragment,fragname);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if(lastFragment != null){
            trans.hide(lastFragment);
        }
        trans.show(fragment);
        if(isback){
            trans.addToBackStack(fragname);
        }
        lastFragment = fragment;
        trans.commit();
        return this;
    }

    public FragmentBuilder setParams(Bundle bundle){
        fragment.setParams(bundle);
        return this;
    }

    public FragmentBuilder removeFrag(BaseFragment frag){
        trans.remove(frag);
        return this;
    }

    public BaseFragment getLastFragment() {
        return lastFragment;
    }

    public void setLastFragment(BaseFragment lastFragment) {
        this.lastFragment = lastFragment;
    }


}
