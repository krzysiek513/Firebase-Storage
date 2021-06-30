package pl.studia.firebasestoregedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {


    EditText search;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    FirebaseRecyclerOptions<Item> options;
    FirebaseRecyclerAdapter<Item, MyViewHolder> adapter;

    DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataRef = FirebaseDatabase.getInstance().getReference().child("car");

        search = findViewById(R.id.searchEt);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        floatingActionButton = findViewById(R.id.floatingBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        loadData();
//
//        adapter = new RecyclerAdapter(data, this);
//        recyclerView.setAdapter(adapter);

    }

    private void loadData() {

        options = new FirebaseRecyclerOptions.Builder<Item>().setQuery(dataRef, Item.class).build();
        adapter = new FirebaseRecyclerAdapter<Item, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Item model) {
                Picasso.get().load(model.getImageUrl()).into(holder.imageView1);
                holder.textView1.setText(model.getItemName());
            }

            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}