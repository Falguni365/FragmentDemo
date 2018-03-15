package com.example.akshay.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdepter adepter;
    private List<RecyclerItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        PlaceHolderFragment fragment = PlaceHolderFragment.newInstance(1);
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.mainf,fragment)
//                .commit();
//
//        PlaceHolderFragment fragment1 = PlaceHolderFragment.newInstance(1);
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.mainf,fragment1)
//                .commit();
//
//        for(int i=0;i<100;i++)
//        {
//            fragment1 = PlaceHolderFragment.newInstance(1);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.mainf,fragment1)
//                    .commit();
//        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i=0;i<=10;i++){
//            RecyclerView item = new RecyclerItem("Item "+(i+1),"Welcome");
            listItems.add(new RecyclerItem("Item "+(i+1),"Welcome"));
        }
        adepter = new MyAdepter(listItems,this );
        recyclerView.setAdapter(adepter);
    }

    public static class PlaceHolderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceHolderFragment() {

        }

        public static PlaceHolderFragment newInstance(int sectionNumber) {
            PlaceHolderFragment fragment = new PlaceHolderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            TextView textView = rootView.findViewById(R.id.section_lable1);
            textView.setText("AKSHAY");
            return rootView;
        }
    }
}