package com.example.qyy.mydatabinding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link fraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fraFragment extends Fragment {


    public fraFragment() {
        // Required empty public constructor
    }

    public static fraFragment newInstance() {
        fraFragment fragment = new fraFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.v("onlifecycle", "qqqqqqq" + "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getLifecycle().addObserver(new MyLifeObserver(9));
        Log.v("onlifecycle", "qqqqqqq" + "onCreateView");
        return inflater.inflate(R.layout.fragment_fra, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        Log.v("onlifecycle", "qqqqqqq" + "onResume");
        super.onResume();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }
}
