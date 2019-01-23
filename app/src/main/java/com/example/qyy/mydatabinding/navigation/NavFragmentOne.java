package com.example.qyy.mydatabinding.navigation;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.qyy.mydatabinding.R;

import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavFragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavFragmentOne extends Fragment {
    private Button mbtn;

    public NavFragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NavFragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static NavFragmentOne newInstance() {
        NavFragmentOne fragment = new NavFragmentOne();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("fffffdddd", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("fffffdddd", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment  要在layout 中id ed,不然数据不会保存
        View view = inflater.inflate(R.layout.fragment_nav_fragment_one, container, false);
        mbtn = (Button) view.findViewById(R.id.btn_one);
//        mbtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navFragmentOne_to_navFragmentTwo));
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //前往另一个fragment时 会调用onDestroyView
                //当按返回键重回这个页面时  会调用onCreateView
                Bundle bundle = new Bundle();
                bundle.putString("key", "我是One To Two");
                Navigation.findNavController(v).navigate(R.id.action_navFragmentOne_to_navFragmentTwo, bundle);
            }
        });
        Log.v("fffffdddd", "onCreateView");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("fffffdddd", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("fffffdddd", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("fffffdddd", "onDetach");
    }
}
