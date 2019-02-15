package com.example.taicodepathinstagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class InstagramActivity extends AppCompatActivity {


    private final String TAG = "InstagramActivity";
    private EditText etDescription;
    private Button btnPic;
    private ImageView ivImage;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        etDescription = findViewById(R.id.etDescription);
        btnPic = findViewById(R.id.btnPic);
        ivImage = findViewById(R.id.imageView);
        btnSubmit = findViewById(R.id.btnSubmit);

        queryPost();
    }

    private void queryPost() {
            // Specify which class to query
            ParseQuery<Post> query = new ParseQuery<Post>(Post.class);
            query.include(Post.KEY_USER);
            query.findInBackground(new FindCallback<Post>() {
                @Override
                public void done(List<Post> posts, ParseException e) {
                  if(e!= null) {
                      Log.e(TAG, "Error with query");
                      e.printStackTrace();
                      return;
                  }
                   for(int i =0; i<posts.size(); i++) {
                       Post post = posts.get(i);
                       Log.d(TAG, "Post:" + posts.get(i).getDescription() + "username:" + post.getUser().getUsername());
                   }
                   }
            });
        }
    }

