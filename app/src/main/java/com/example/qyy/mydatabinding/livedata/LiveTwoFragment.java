package com.example.qyy.mydatabinding.livedata;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;
import com.example.qyy.mydatabinding.databinding.FragmentLiveTwoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveTwoFragment extends Fragment {
    private TextView mtv;
    private LiveViewModel model;

    public LiveTwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     *
     * @return A new instance of fragment LiveTwoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiveTwoFragment newInstance() {
        LiveTwoFragment fragment = new LiveTwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActivity()可以数据共享 activity、fragment
        model = ViewModelProviders.of(getActivity()).get(LiveViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLiveTwoBinding fragmentLiveTwoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_live_two, container, false);
        fragmentLiveTwoBinding.setViewmodel(model);
        fragmentLiveTwoBinding.setLifecycleOwner(this);
        return fragmentLiveTwoBinding.getRoot();
    }

}
