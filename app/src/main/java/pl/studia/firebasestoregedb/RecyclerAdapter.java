package pl.studia.firebasestoregedb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<Item> items;
    private OnListener onListener;

    public RecyclerAdapter(ArrayList<Item> data, OnListener onListener) {
        this.items = data;
        this.onListener = onListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view, onListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(Integer.parseInt(items.get(position).getImageUrl()));
        holder.name.setText(items.get(position).getItemName());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "cicked " + data.get(position).getNameId(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView name;
        TextView opis;
        OnListener onListener;

        public ViewHolder(@NonNull View itemView, OnListener onListener) {
            super(itemView);

            image = itemView.findViewById(R.id.recIv);
            name = itemView.findViewById(R.id.recTv1);

            this.onListener = onListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListener.onListener(getLayoutPosition());
        }
    }

    public interface OnListener{
        void onListener(int position);
    }

}
