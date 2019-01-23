package com.example.qyy.mydatabinding.bindingsetters;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.qyy.mydatabinding.RecyclerBaseAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomSetter {
    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int padding) {
        view.setPadding(padding, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    @BindingAdapter("recylist")
    public static void loadImage(RecyclerView view, List mlist) {
      RecyclerBaseAdapter adapter=(RecyclerBaseAdapter) view.getAdapter();
      if(adapter!=null&&mlist!=null){
          adapter.setData(mlist);
      }

    }

}
