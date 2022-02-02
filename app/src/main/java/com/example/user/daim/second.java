package com.example.user.daim;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link second.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link second#newInstance} factory method to
 * create an instance of this fragment.
 */
public class second extends Fragment {
    Button b1, b2, b3, b4, b5;
    Button b6, b7, b8, b9, b0;
    Button bplus, bmin, bs, bdiv, bres, bclear, bsys;
    Button aB,bB,cB,dB,eB,fB;
    TextView res;
    int a, from, to, p1, p2, prov;double result;BigInteger ch1,ch2;
    String chislo1; String chislo2;
    public second() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static second newInstance(String param1, String param2) {
        second fragment = new second();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_second, container, false);
        res=(TextView)v.findViewById(R.id.tv);
        b1=(Button)v.findViewById(R.id.btOne);
        b2=(Button)v.findViewById(R.id.btTwo);
        b3=(Button)v.findViewById(R.id.btThree);
        b4=(Button)v.findViewById(R.id.btFour);
        b5=(Button)v.findViewById(R.id.btFive);
        b6=(Button)v.findViewById(R.id.btSix);
        b7=(Button)v.findViewById(R.id.btSeven);
        b8=(Button)v.findViewById(R.id.btEight);
        b9=(Button)v.findViewById(R.id.btNine);
        b0=(Button)v.findViewById(R.id.b0);
        bplus=(Button)v.findViewById(R.id.btPlus);
        bmin=(Button)v.findViewById(R.id.btMinus);
        bdiv=(Button)v.findViewById(R.id.bdiv);
        bclear=(Button)v.findViewById(R.id.bclear);
        bres=(Button)v.findViewById(R.id.bres);
        bsys=(Button)v.findViewById(R.id.Bsys);
        bs=(Button)v.findViewById(R.id.bs);
        aB=(Button)v.findViewById(R.id.a);
        bB=(Button)v.findViewById(R.id.b);
        cB=(Button)v.findViewById(R.id.c);
        dB=(Button)v.findViewById(R.id.d);
        eB=(Button)v.findViewById(R.id.e);
        fB=(Button)v.findViewById(R.id.f);
        a=0;p1=0;p2=0;from=10;to=10;result=0;chislo1="";chislo2="";
        res.setText("0");
        final View.OnClickListener onClickListener=new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btOne:
                        Check(1);
                        break;
                    case R.id.btTwo:
                        Check(2);
                        break;
                    case R.id.btThree:
                        Check(3);
                        break;
                    case R.id.btFour:
                        Check(4);
                        break;
                    case R.id.btFive:
                        Check(5);
                        break;
                    case R.id.btSix:
                        Check(6);
                        break;
                    case R.id.btSeven:
                        Check(7);
                        break;
                    case R.id.btEight:
                        Check(8);
                        break;
                    case R.id.btNine:
                        Check(9);
                        break;
                    case R.id.b0:
                        Check(0);
                        break;
                    case R.id.a:
                        CheckSym("a");
                        break;
                    case R.id.b:
                        CheckSym("b");
                        break;
                    case R.id.c:
                        CheckSym("c");
                        break;
                    case R.id.d:
                        CheckSym("d");
                        break;
                    case R.id.e:
                        CheckSym("e");
                        break;
                    case R.id.f:
                        CheckSym("f");
                        break;
                    case R.id.bclear:
                        p1 = 0;
                        p2 = 0;
                        from = 10;
                        to = 10;
                        result = 0;
                        a = 0;
                        res.setText("0");
                        break;
                    case R.id.bdiv:
                        if(a==0)a = 4;
                        break;
                    case R.id.bres:
                        try{
                        ch1 = new BigInteger(chislo1,from);
                        String s = ch1.toString(10);
                        ch2 = new BigInteger(chislo2,to);
                        String s1 = ch2.toString(10);
                        p1 = Integer.parseInt(s);
                        p2 = Integer.parseInt(s1);
                        switch (a) {
                            case 1:
                                result = p1 + p2;
                                break;
                            case 2:
                                result = p1 - p2;
                                break;
                            case 3:
                                result = p1 * p2;
                                break;
                            case 4:
                                result = (double)p1 / (double)p2;
                                break;
                        }
                        if (a != 0) {
                            res.setText(Double.toString(result));
                            from = 10;
                            to = 10;
                            p1 = 0;
                            p2 = 0;
                            result = 0;
                            a = 0;
                            chislo1="";
                            chislo2="";
                        }} catch (NumberFormatException e){
                            res.setText("Ошибка! Недопустимые символы для исходной системы счисления.");
                        }
                        break;
                    case R.id.bs:
                        if(a==0)a = 3;
                        break;
                    case R.id.btMinus:
                        if(a==0)a = 2;
                        break;
                    case R.id.btPlus:
                        if(a==0)a = 1;
                        break;
                    case R.id.Bsys:
                        switch (prov){
                            case 1:
                            LayoutInflater lf = LayoutInflater.from(getActivity());
                            View provview=lf.inflate(R.layout.dialog, null);
                                AlertDialog.Builder DialogBuilder=new AlertDialog.Builder(getActivity());
                                DialogBuilder.setView(provview);
                                final EditText input=(EditText)provview.findViewById(R.id.input_text);
                                DialogBuilder
                                        .setCancelable(false)
                                        .setPositiveButton("Ok",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        String prob=input.getText().toString();
                                                        try{
                                                            from=Integer.parseInt(prob);
                                                        }catch (NumberFormatException e){
                                                            prob="";
                                                        }
                                                        Toast.makeText(getContext(),"Задана система счисления первого числа",Toast.LENGTH_LONG).show();
                                                    }
                                                })
                                        .setNegativeButton("Отмена",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialogInterface.cancel();
                                                    }
                                                });
                                AlertDialog alertDialog=DialogBuilder.create();
                                alertDialog.show();
                                break;
                            case 2:
                                LayoutInflater lf2 = LayoutInflater.from(getActivity());
                                View provview2=lf2.inflate(R.layout.dialog, null);
                                AlertDialog.Builder DialogBuilder2=new AlertDialog.Builder(getActivity());
                                DialogBuilder2.setView(provview2);
                                final EditText input2=(EditText)provview2.findViewById(R.id.input_text);
                                DialogBuilder2
                                        .setCancelable(false)
                                        .setPositiveButton("Ok",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        String prob=input2.getText().toString();
                                                        try{
                                                            to=Integer.parseInt(prob);
                                                        }catch (NumberFormatException e){
                                                            prob="";
                                                        }
                                                        Toast.makeText(getContext(),"Задана система счисления второго числа",Toast.LENGTH_LONG).show();
                                                    }
                                                })
                                        .setNegativeButton("Отмена",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialogInterface.cancel();
                                                    }
                                                });
                                AlertDialog alertDialog2=DialogBuilder2.create();
                                alertDialog2.show();
                                break;
                            case 0:
                         res.setText("Введите число");
                         break;}
                         break;
                }

            }
            public void CheckSym(String ch){
                if(a==0){
                    chislo1+=ch;res.setText(chislo1);
                }
                else{
                    chislo2+=ch;res.setText(chislo2);
                }
            }
            public void Check(int a1){
                if(a==0){
                    chislo1+=Integer.toString(a1);
                    res.setText(chislo1);
                    prov=1;
                }
                else {
                    chislo2+=Integer.toString(a1);
                    res.setText(chislo2);
                    prov=2;
                }}
        };
        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
        b3.setOnClickListener(onClickListener);
        b4.setOnClickListener(onClickListener);
        b5.setOnClickListener(onClickListener);
        b6.setOnClickListener(onClickListener);
        b7.setOnClickListener(onClickListener);
        b8.setOnClickListener(onClickListener);
        b9.setOnClickListener(onClickListener);
        b0.setOnClickListener(onClickListener);
        bplus.setOnClickListener(onClickListener);
        bmin.setOnClickListener(onClickListener);
        bdiv.setOnClickListener(onClickListener);
        bclear.setOnClickListener(onClickListener);
        bres.setOnClickListener(onClickListener);
        bsys.setOnClickListener(onClickListener);
        bs.setOnClickListener(onClickListener);
        aB.setOnClickListener(onClickListener);
        bB.setOnClickListener(onClickListener);
        cB.setOnClickListener(onClickListener);
        dB.setOnClickListener(onClickListener);
        eB.setOnClickListener(onClickListener);
        fB.setOnClickListener(onClickListener);
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Калькулятор");
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
