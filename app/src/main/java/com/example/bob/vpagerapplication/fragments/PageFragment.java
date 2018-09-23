package com.example.bob.vpagerapplication.fragments;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private static final String KEY_EMO = "emo";

    private static TypedArray myEmo;

    public PageFragment() {
        // Required empty public constructor
    }


    /**
     * Creating new instance of page Fragment and adding data to its bundle
     * @param position
     * @param color
     * @return
     */
   // public static PageFragment newInstance(int position, int color, byte[] emo) {
     public static PageFragment newInstance(int position, int color, TypedArray emo) {

        // Create a new instance
        PageFragment frag = new PageFragment();

        // create bundle and add data to the mapping
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
       // args.putByteArray(KEY_EMO, emo);
        frag.setArguments(args);

         myEmo = emo;

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
        ImageView emoView = (ImageView) view.findViewById(R.id.frg_emo);

        // retrieve data from bundle
        int position = getArguments().getInt(KEY_POSITION,-1);
        int color = getArguments().getInt(KEY_COLOR,-1);
        byte[] emo = getArguments().getByteArray(KEY_EMO);

        // Update widget:
        rootView.setBackgroundColor(color);
        textView.setText("Page number " + position);
/*
        Bitmap bmp = BitmapFactory.decodeByteArray(emo, 0, emo.length);
        Bitmap drawableBitmap = bmp.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(drawableBitmap);

        Drawable emoD = emoView.getDrawable();
        emoD.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        emoD.draw(canvas);
        emoView.setImageDrawable(emoD);
*/
emoView.setImageDrawable(myEmo.getDrawable(position));

        Log.d("EMO","The emo in PageFrg is " + myEmo.getDrawable(position).toString());
        return view;
    }

}
