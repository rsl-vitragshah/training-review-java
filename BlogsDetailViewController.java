import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.List;

public class BlogsDetailViewController {

    private SharedPreferences sharedPreferences;

    // SharedPreferences keys
    private static final String PREF_NAME = "MyBlogAppPrefs";
    private static final String FAVORITE_POSTS_KEY = "favoritePosts";

    private List<BlogPost> posts = Collections.emptyList();

    public BlogsDetailViewController() {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void onFavouriteIconClicked(String blogId) {
        toggleFavouriteBlog(blogId);
    }
    
    public void toggleFavouriteBlog(String blogId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getString(blogId, "").equals("")) {
            editor.putString(FAVORITE_POSTS_KEY+blogId, blogId);
        } else {
            editor.remove(FAVORITE_POSTS_KEY+blogId);
        }
        editor.apply();
    }
}
