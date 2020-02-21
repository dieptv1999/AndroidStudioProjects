package com.example.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RedFragment extends Fragment implements FragmentCallBacks{


    MainActivity main;
    TextView textRed;
    Button btnRed;

    private OnFragmentInteractionListener mListener;

    public RedFragment() {
        // Required empty public constructor
    }

    public static RedFragment newInstance(String strArg1) {
        RedFragment fragment = new RedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof MainCallBacks)) {
            throw new IllegalStateException( " Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(
                R.layout.fragment_red, null);
        textRed = view_layout_red.findViewById(R.id.textViewRed);

        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("arg1", "");
            textRed.setText(redMessage);
        } catch (Exception e) {
            Log.e("RED BUNDLE ERROR - ", "" + e.getMessage());
        }
        btnRed =view_layout_red.findViewById(R.id.btnRed);
        return view_layout_red;
    }

//    public void onButtonPressed(Uri uri) {
////        if (mListener != null) {
////            mListener.onFragmentInteraction(uri);
////        }
//    }

    @Override
    public void onMsgFromMainToFragment(String strValue) {
        textRed.setText("THIS MESSAGE COMES FROM MAIN:" + strValue);
    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
