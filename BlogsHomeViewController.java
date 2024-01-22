import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.List;

/** Screen to show list of blogs. */
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
        sortByBlogSize();
    }

    private void sortByBlogSize() {
        int n = posts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (posts.get(j).getContentLength() > posts.get(j + 1).getContentLength()) {
                    // swap temp and arr[i]
                    BlogPost temp = posts.get(j);
                    posts.set(j, posts.get(j + 1));
                    posts.set(j + 1, temp);
                }
            }
        }
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
