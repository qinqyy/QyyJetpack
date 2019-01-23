package com.example.qyy.mydatabinding.navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.qyy.mydatabinding.R;

import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavFragmentThree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavFragmentThree extends Fragment {
private Button mbtn;

    public NavFragmentThree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NavFragmentThree.
     */
    // TODO: Rename and change types and number of parameters
    public static NavFragmentThree newInstance() {
        NavFragmentThree fragment = new NavFragmentThree();
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
        View view = inflater.inflate(R.layout.fragment_nav_fragment_three, container, false);
        mbtn=view.findViewById(R.id.btn_three);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().finish();
                Navigation.findNavController(v).navigate(R.id.action_navFragmentThree_to_navActivity);
            }
        });
        return view;
    }

}
