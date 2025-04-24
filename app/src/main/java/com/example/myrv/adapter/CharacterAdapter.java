package com.example.myrv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrv.R;
import com.example.myrv.model.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> implements Filterable {
    private List<Character> characterList;
    private List<Character> characterListFull;

    public CharacterAdapter(List<Character> characterList) {
        this.characterList = characterList;
        this.characterListFull = new ArrayList<>(characterList);
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.imageView.setImageResource(character.getImageResourceId());
        holder.nameTextView.setText(character.getName());
        holder.descriptionTextView.setText(character.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), character.getName() + ": " + character.getDescription(), 
                         Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    @Override
    public Filter getFilter() {
        return characterFilter;
    }

    private Filter characterFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Character> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(characterListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Character character : characterListFull) {
                    if (character.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(character);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            characterList.clear();
            characterList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView descriptionTextView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.character_image);
            nameTextView = itemView.findViewById(R.id.character_name);
            descriptionTextView = itemView.findViewById(R.id.character_description);
        }
    }
} 