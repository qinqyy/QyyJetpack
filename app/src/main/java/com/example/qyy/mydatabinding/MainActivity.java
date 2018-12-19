package com.example.qyy.mydatabinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.example.qyy.mydatabinding.bean.FieldObj;
import com.example.qyy.mydatabinding.bean.Pojo;
import com.example.qyy.mydatabinding.bean.TwoWayBean;
import com.example.qyy.mydatabinding.bean.User;
import com.example.qyy.mydatabinding.databinding.ActivityMainBinding;
import com.example.qyy.mydatabinding.databinding.VsLayoutBinding;
import com.example.qyy.mydatabinding.envent.EventClick;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    User user;
    FieldObj fieldObj;
    private TwoWayBean twoWayBean;
    private ArrayList<Pojo.PP.QQ> mpps = new ArrayList<>();
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //设置重绑定回调函数,动画
        mainBinding.addOnRebindCallback(new OnRebindCallback() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup = (ViewGroup) binding.getRoot();
                //开启延时位移动画
                TransitionManager.beginDelayedTransition(viewGroup);
                return true;
            }
        });


        user = new User();
        fieldObj = new FieldObj();
        fieldObj.isvs.set(true);
        mainBinding.setTime(new Date());
        mainBinding.setPaddleft(200);
        mainBinding.setImgurl("http://pic34.photophoto.cn/20150202/0005018384491898_b.jpg");
        mainBinding.setUser(user);
        mainBinding.setEvent(new EventClick());
        mainBinding.setField(fieldObj);
        mainBinding.setMap(new ObservableArrayMap<String, Object>());
        mainBinding.tvtext.setText("不用findViewById了");
        Pojo.PP.QQ pp = new Pojo.PP.QQ();
        pp.setCc("kkkk");
        mpps.add(pp);
        mainBinding.setPojo(mpps);

        twoWayBean = new TwoWayBean();
        twoWayBean.setTwoway("双向绑定");
        mainBinding.setTwoway(twoWayBean);
        String na = stampToDate("1537248385000");
        Log.v("ssss", "" + na);


    }


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    @Override
    public void onClick(View v) {
        mainBinding.vs.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                VsLayoutBinding vsLayoutBinding = DataBindingUtil.bind(inflated);
                User user = new User();
                user.setName("我相信我就我");
                vsLayoutBinding.setUser(user);
            }
        });
        mainBinding.vs.getViewStub().inflate();
    }
}
