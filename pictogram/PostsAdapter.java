package com.example.pictogram;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

private Context context;
private List<Post> posts;

// Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

// Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    public PostsAdapter(Context context, List<Post> posts)
    {
        this.context = context;
        this.posts = posts;
    }
    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvUsername;
        //private TextView tvTime;
        private ImageView ivImage;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivImage);
          //  tvTime = itemView.findViewById(R.id.tvTime);
        }

        public void bind(Post post) {
            //Bind post data to the view element
            tvDescription.setText(post.getDescription());
           // tvTime.setText(post.getTime());
            tvUsername.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            if(image != null)
            {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
