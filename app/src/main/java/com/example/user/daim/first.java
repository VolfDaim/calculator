package com.example.user.daim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigInteger;

public class first extends Fragment {
    EditText Num1;
    TextView Result;
    Button btnresult;
    Spinner from;

    EditText From;
    EditText To;
    /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, data);
String s;String s1;*/
    private OnFragmentInteractionListener mListener;

    public first() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_first, container, false);
        Num1 = (EditText) v.findViewById(R.id.edittextnum1);

        /*adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         final Spinner from =(Spinner) v.findViewById(R.id.from);
       final  Spinner to=(Spinner) v.findViewById(R.id.to);
        from.setAdapter(adapter);to.setAdapter(adapter);
        from.setSelection(1);to.setSelection(1);
        from.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
s= from.getSelectedItem().toString();
            }
        });
        to.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
s1=to.getSelectedItem().toString();
            }
        });*/
        From=(EditText)v.findViewById(R.id.from);
        To=(EditText)v.findViewById(R.id.to);
        btnresult = (Button) v.findViewById(R.id.result);
        Result = (TextView) v.findViewById(R.id.textView4);
        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*float from = Float.parseFloat(s);
                float to=Float.parseFloat(s1);*/
                if (TextUtils.isEmpty(Num1.getText().toString())||
                        TextUtils.isEmpty(From.getText().toString())||
                        TextUtils.isEmpty(To.getText().toString()))
                    return;
                boolean b=false;
                String NUM = Num1.getText().toString();
                int from = Integer.parseInt(From.getText().toString());
                int to = Integer.parseInt(To.getText().toString());
                String result1 = "";
                try{
                BigInteger result;
                result=new BigInteger(NUM,from);
                result1=result.toString(to);
                Result.setText(result1);
                }
                catch (NumberFormatException e){
                    Result.setText("Ошибка! Недопустимые символы для исходной системы счисления!");
                }

            }

        };
        btnresult.setOnClickListener(onClickListener);
        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Перевод ");

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
