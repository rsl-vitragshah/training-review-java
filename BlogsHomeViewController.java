import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.List;

public class BlogsHomeViewController {

    private SharedPreferences sharedPreferences;

    // SharedPreferences keys
    private static final String PREF_NAME = "MyBlogAppPrefs";
    private static final String FAVORITE_POSTS_KEY = "favoritePosts";

    private List<BlogPost> posts = Collections.emptyList();

    public BlogsHomeViewController() {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        fethBlogs();
    }

    public void onFavouriteIconClicked(String blogId) {
        togleFavouriteBlog(blogId);

    }

    public void onSortButtonClicked() {
        sortAlphabetically();
    }

    private void sortAlphabetically() {
        // sorts blogs alphabetically
        // updates UI
    }

    private void fethBlogs() {
        // Fire API request to fetch blogs
        List<BlogPost> blogs = Collections.emptyList();
        posts.addAll(blogs);
        // updates UI
    }


    public void togleFavouriteBlog(String blogId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getString(blogId, "").equals("")) {
            editor.putString(FAVORITE_POSTS_KEY+blogId, blogId);
        } else {
            editor.remove(FAVORITE_POSTS_KEY+blogId);
        }
        editor.apply();
    }
}
