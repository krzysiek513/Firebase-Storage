package pl.studia.firebasestoregedb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView1;
    TextView textView1;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(R.id.image_single_view);
        textView1 = itemView.findViewById(R.id.text_single_view);
    }
}
