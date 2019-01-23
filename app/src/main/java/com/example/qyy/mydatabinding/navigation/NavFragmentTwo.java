package com.example.qyy.mydatabinding.navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.qyy.mydatabinding.R;

import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavFragmentTwo extends Fragment {


    private Button mbtn;
    private EditText med;

    public NavFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NavFragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static NavFragmentTwo newInstance() {
        NavFragmentTwo fragment = new NavFragmentTwo();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_fragment_two, container, false);
        mbtn = view.findViewById(R.id.btn_two);
        med = (EditText) view.findViewById(R.id.ed);
        med.setText("" + getArguments().getString("key"));
        mbtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navFragmentTwo_to_navFragmentThree));
        return view;
    }

}
