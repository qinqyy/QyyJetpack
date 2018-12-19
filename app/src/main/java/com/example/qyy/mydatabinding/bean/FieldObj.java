package com.example.qyy.mydatabinding.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

public class FieldObj {
    //它们都是一个包含单一属性的可观察的对象。为避免装箱、拆箱操作，可以在数据类中定义成 public final
    public final ObservableField<String> bookname = new ObservableField<>();
    public final ObservableBoolean isvs = new ObservableBoolean();
}
