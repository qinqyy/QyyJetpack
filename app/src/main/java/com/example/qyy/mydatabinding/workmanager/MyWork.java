package com.example.qyy.mydatabinding.workmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {
    private int num;
    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.v("vvv","dddd");
        String str = getInputData().getString("data");
        num=num+5;
        Data data=new Data.Builder().putString("redata","我给你回传值了:"+num).build();

        Log.v("vvv",num+" :"+str+" ："+Thread.currentThread().getName());
        return Result.success(data);
    }
}
