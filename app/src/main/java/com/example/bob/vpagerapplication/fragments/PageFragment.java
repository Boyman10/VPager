package com.example.bob.vpagerapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bob.vpagerapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    // Keys for our bundle
    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";

    public PageFragment() {
        // Required empty public constructor
    }


    /**
     * Creating new instance of page Fragment and adding data to its bundle
     * @param position
     * @param color
     * @return
     */
    public static PageFragment newInstance(int position, int color) {

        // Create a new instance
        PageFragment frag = new PageFragment();

        // create bundle and add data to the mapping
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        // get widgets from layout and serialize it
        LinearLayout rootView = (LinearLayout) view.findViewById(R.id.fragment_page_root_view);
        TextView textView = (TextView) view.findViewById(R.id.frg_page_title);

        // retrieve data from bundle
        int position = getArguments().getInt(KEY_POSITION,-1);
        int color = getArguments().getInt(KEY_COLOR,-1);

        // Update widget:
        rootView.setBackgroundColor(color);
        textView.setText("Page number " + position);

        return view;
    }

}
