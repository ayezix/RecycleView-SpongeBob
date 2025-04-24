package com.example.myrv;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrv.adapter.CharacterAdapter;
import com.example.myrv.model.Character;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CharacterAdapter adapter;
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize character list
        characterList = new ArrayList<>();
        populateCharacterList();

        // Set up adapter
        adapter = new CharacterAdapter(characterList);
        recyclerView.setAdapter(adapter);

        // Set up search functionality
        EditText searchBar = findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void populateCharacterList() {
        // Add characters with their corresponding images
        characterList.add(new Character("SpongeBob SquarePants", 
            "An optimistic sea sponge who works as a fry cook", 
            R.drawable.spongebob));
        characterList.add(new Character("Patrick Star", 
            "SpongeBob's best friend, a lovable but dim-witted starfish", 
            R.drawable.patrick_star));
        characterList.add(new Character("Squidward Tentacles", 
            "SpongeBob's grumpy neighbor and coworker", 
            R.drawable.squidward));
        characterList.add(new Character("Mr. Krabs", 
            "The money-loving owner of the Krusty Krab", 
            R.drawable.mr_krabs));
        characterList.add(new Character("Sandy Cheeks", 
            "A scientist squirrel from Texas", 
            R.drawable.sandy_cheeks));
        characterList.add(new Character("Plankton", 
            "The tiny owner of the Chum Bucket and rival of Mr. Krabs", 
            R.drawable.plankton));
        characterList.add(new Character("Gary the Snail", 
            "SpongeBob's pet snail who meows like a cat", 
            R.drawable.gary_snail));
        characterList.add(new Character("Mrs. Puff", 
            "SpongeBob's boating school teacher", 
            R.drawable.mrs_puff));
        characterList.add(new Character("Pearl Krabs", 
            "Mr. Krabs' teenage whale daughter", 
            R.drawable.pearl_krabs));
        characterList.add(new Character("Larry the Lobster", 
            "A muscular lobster who works as a lifeguard", 
            R.drawable.larry_lobster));
    }
}