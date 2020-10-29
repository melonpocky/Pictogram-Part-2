package com.example.pictogram.fragments;

import android.util.Log;

import com.example.pictogram.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import static com.example.pictogram.Post.KEY_CREATED;

public class ProfileFragment extends PostFragment {

    @Override
    protected void queryPosts()
    {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(KEY_CREATED);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e != null)
                {
                    Log.e(TAG, "Issue with getting posts",e);
                    return;
                }

                for(Post post: posts)
                {
                    Log.i(TAG, "Post: " + post.getDescription() + ", username: "+ post.getUser().getUsername());
                }
                allPosts.clear();
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });


    }

}
