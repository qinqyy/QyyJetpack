package com.example.qyy.mydatabinding.workmanager;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import static androidx.work.WorkInfo.State.RUNNING;

/**
 * 1.启动app,断开网络，不会执行
 * 2.启动app，断开网络，不会执行，再连接网络，任务执行
 * 3.退出app(not kill进程)，连接网络，执行任务
 * 4.kill进程，连接网络，不会执行
 * 5.退出app(kill/not kill进程),重启,连接网络,打开app即会执行1次任务
 */
public class WorkActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        mtv = (TextView) findViewById(R.id.tv_one);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_zx:
                //开始执行任务
                starzx();
                break;
            default:
                break;
        }
    }

    private void starzx() {
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        Data data = new Data.Builder()
                .putString("data", "给Work传值")
                .build();
        //单次任务
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWork.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();
        //注意 定时任务 最小时间间隔为15分钟
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWork.class, 15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .setInputData(data)
                .build();
        WorkManager.getInstance().enqueue(periodicWorkRequest);
        WorkManager.getInstance().getWorkInfoByIdLiveData(periodicWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {
                        if (workInfo != null && workInfo.getState().isFinished()) {
                            String dd = workInfo.getOutputData().getString("redata");
                            mtv.setText("" + dd);
                        }
                    }
                });
    }
}
