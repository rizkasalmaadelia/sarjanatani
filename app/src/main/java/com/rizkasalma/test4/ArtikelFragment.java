package com.rizkasalma.test4;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class ArtikelFragment extends Fragment {
    private String[] Title;
    private String[] Description;
    private TypedArray ImageArtikel;
    private ArtikelAdapter adapter;
    private ArrayList<ArtikelItem> ArtikelItems = new ArrayList<>();

    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_artikel, container, false);
        ListView listview = (ListView) rootView.findViewById(R.id.listar);

        ArtikelItems = new ArrayList<>();
        adapter = new ArtikelAdapter(this);
        listview.setAdapter(adapter);

        prepare();
        addItem();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(ArtikelFragment.this,DetailActivity.class);
//                intent.putExtra("Detail",ArtikelItems.get(i));
//                startActivity(intent);
                Toast.makeText(getActivity().getApplicationContext(), "HAlo", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    private void addItem() {
        ArtikelItems = new ArrayList<>();
        for (int i = 0; i < Title.length; i++) {
            ArtikelItem artikelItem = new ArtikelItem();
            artikelItem.setImageArtikel((ImageArtikel.getResourceId(i, -1)));
            artikelItem.setTitle(Title[i]);
            artikelItem.setDescription(Description[i]);
            ArtikelItems.add(artikelItem);
        }
        adapter.setArtikelItems(ArtikelItems);
    }

    private void prepare() {
        Title = getResources().getStringArray(R.array.title);
        Description = getResources().getStringArray(R.array.description);
        ImageArtikel = getResources().obtainTypedArray(R.array.image_artikel);
    }

}
