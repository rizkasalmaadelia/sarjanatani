package com.rizkasalma.test4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    private String []titles;
    private ArrayList<String>listtitles;
    private EditText editText;
    private ArrayAdapter<String>adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView=(ListView)findViewById(R.id.list);
        editText=(EditText)findViewById(R.id.search);

        titlelistmethod();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    titlelistmethod();
                    //      Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }else{
                    searchtitles(s.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void titlelistmethod(){
        titles=new String[]{"Matematika","Ipa","Ips","Agama","Seni"};
        listtitles= new ArrayList<>(Arrays.asList(titles));
        adapter=new ArrayAdapter<String>(this,R.layout.row_layout,R.id.text,listtitles);
        listView.setAdapter(adapter);
    }
    private void searchtitles(String titlessearch) {
        for (String i : titles ){
            if (!i.contains(titlessearch)){

                listtitles.remove(i);
            }

        }
        adapter.notifyDataSetChanged();
    }
}
