package com.example.qyy.mydatabinding.envent;

import android.content.Context;
import android.databinding.ObservableArrayMap;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qyy.mydatabinding.bean.FieldObj;
import com.example.qyy.mydatabinding.bean.TwoWayBean;
import com.example.qyy.mydatabinding.bean.User;

public class EventClick {
    private boolean isshow = true;

    public void onClicktoBinding(User user, TwoWayBean twoWayBean, Context context, TextView textView) {
        user.setName("我叫Qyy");
        user.setTip("我就是我，不一样的花火！");
        user.setAge(23);
        Toast.makeText(context,"点击事件"+textView.getText(),Toast.LENGTH_SHORT).show();
        Log.v("twoway:", "点击事件");
        Log.v("twoway:", "" + twoWayBean.getTwoway());

    }

    public void onClickImg(FieldObj fieldObj, ObservableArrayMap<String, Object> observableArrayMap, TwoWayBean twoWayBean) {
        if (isshow) {
            fieldObj.isvs.set(true);
            fieldObj.bookname.set("显示");
            observableArrayMap.put("one", "是第一个");
            observableArrayMap.put("two", "是哈哈");
            isshow = false;
        } else {
            fieldObj.isvs.set(false);
            observableArrayMap.put("one", "是one");
            observableArrayMap.put("three", "是姐姐");
            observableArrayMap.put("four", 150);
            fieldObj.bookname.set("长度" + observableArrayMap.size());
            isshow = true;
        }

        twoWayBean.setTwoway("刷新UI");
        twoWayBean.notifyChange();
    }
}
