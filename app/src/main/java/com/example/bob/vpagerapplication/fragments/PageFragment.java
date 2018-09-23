package com.example.bob.vpagerapplication.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bob.vpagerapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment implements View.OnClickListener{

    private static final String PAGE_FRG_BUNDLE = "Page Fragment BUNDLE";

    // Keys for our bundle
    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";
    private static final String KEY_EMO = "emo";

    private static TypedArray myEmo;

    private static LayoutInflater inflater;


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

         this.inflater = inflater;
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


        emoView.setOnClickListener(this);

        Log.d("EMO","The emo in PageFrg is " + myEmo.getDrawable(position).toString());
        return view;
    }

    @Override
    public void onClick(View v) {

        int position = getArguments().getInt(KEY_POSITION,-1);

        Log.d(PAGE_FRG_BUNDLE,"Just clicked on button identified by position ! " + position);

        View layout = inflater.inflate(R.layout.layout_toast,
                (ViewGroup) v.findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getActivity()); // May be put that within the Activity and not in the fragment ...
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

     }
}
