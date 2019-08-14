package com.rizkasalma.test4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtikelAdapter extends BaseAdapter {
    private final ArtikelFragment context;

    public ArtikelAdapter(ArtikelFragment context) {
        this.context = context;
        ArtikelItems = new ArrayList<>();
    }

    private ArrayList<ArtikelItem> ArtikelItems;

    public void setArtikelItems(ArrayList<ArtikelItem> artikelItems) {
        ArtikelItems = artikelItems;
    }

    @Override
    public int getCount() {
        return ArtikelItems.size();
    }

    @Override
    public Object getItem(int i) {
        return ArtikelItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_artikel, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        ArtikelItem artikelItem = (ArtikelItem) getItem(i);
        viewHolder.bind(artikelItem);
        return view;
    }

    private class ViewHolder {
        private ImageView imageArtikel;
        private TextView txtTitle;
        private TextView txtDescription;


        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.title);
            txtDescription = view.findViewById(R.id.textdescription);
            imageArtikel = view.findViewById(R.id.img_photo);

        }



        void bind(ArtikelItem film) {
            txtTitle.setText(film.getTitle());
            txtDescription.setText(film.getDescription());
            imageArtikel.setImageResource(film.getImageArtikel());
        }
    }
}
