package com.example.admin.assignment3.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.admin.assignment3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InnerFragment extends Fragment {

    private LinearLayout linearLayout;
    private int fragmentId;

    /**
     * constructor
     */
    public InnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentId = getArguments().getInt("fragmentId");
        View view = inflater.inflate(R.layout.fragment_inner, container, false);
        linearLayout = (LinearLayout) view.findViewById(R.id.fragment_layout_inner);
        if (fragmentId == 1) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));
        } else {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorA, null));
        }
        return view;
    }

}
