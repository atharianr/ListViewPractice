package com.example.latihanlistviewdicoding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.latihanlistviewdicoding.databinding.ItemHeroBinding;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeroAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Hero> heroes = new ArrayList<>();

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public HeroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);
        return itemView;
    }

    private class ViewHolder {

        private final ItemHeroBinding binding;

//        private TextView txtName;
//        private TextView txtDescription;
//        private CircleImageView imgPhoto;

        public ViewHolder(View itemView) {
            binding = ItemHeroBinding.bind(itemView);
//            txtName = itemView.findViewById(R.id.txt_name);
//            txtDescription = itemView.findViewById(R.id.txt_description);
//            imgPhoto = itemView.findViewById(R.id.img_photo);
        }

        void bind(Hero hero) {
            binding.txtName.setText(hero.getName());
            binding.txtDescription.setText(hero.getDescription());
            binding.imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
