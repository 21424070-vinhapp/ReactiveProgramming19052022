package com.example.reactiveprogramming19052022;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tao ra mang arr
        List<String> arr=new ArrayList<>(Arrays.asList("Ty","Teo","tun"));
        //tao ra bien iterable
        Iterable<String> data= handle(arr);
        //iterrator la otem cua iterable
        Iterator<String> value=data.iterator();

        //de hien ra du lieu cua iterator su dung vong lap while
        while (value.hasNext())
        {
            Log.d("BBB",value.next());
        }

    }

    private Iterable<String> handle(List<String> arr) {
        return arr;
    }


}