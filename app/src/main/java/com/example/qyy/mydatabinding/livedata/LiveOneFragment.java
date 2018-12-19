package com.example.qyy.mydatabinding.livedata;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveOneFragment extends Fragment {
    private LiveViewModel viewModel;
    private Button mbtn;
    private TextView mtvStr;

    public LiveOneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LiveOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiveOneFragment newInstance() {
        LiveOneFragment fragment = new LiveOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(LiveViewModel.class);
        viewModel.getMtvStr().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtvStr.setText(s);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live_one, container, false);
        mbtn = (Button) view.findViewById(R.id.one_btn);
        mtvStr = (TextView) view.findViewById(R.id.fragment_one_tv);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getMtvStr().setValue("我是重FragmentOne发出的POST，大侠没有眼泪，可是却想要流泪！！！");
            }
        });
        return view;
    }

}
