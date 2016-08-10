package tylkovich.interview_android_1.picasso;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import tylkovich.interview_android_1.R;
import tylkovich.interview_android_1.utils.ConstantManager;


/**
 * Created by tylkovich on 08.08.2016.
 */
public class Picaso {
    private static final String TAG = ConstantManager.TAG_PREFIX + "MyApp";

    public static void downloadImage(Context c, String url, ImageView img) {

        if (url != null && url.length() > 0) {

            Picasso.with(c).load(url).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.placeholder).error(R.drawable.placeholder_eror).resize(600, 300)
                    .centerInside().into(img, new Callback() {
                @Override
                public void onSuccess() {
                    Log.i(TAG, "картинка загрузилась");
                }

                @Override
                public void onError() {
                    Log.i(TAG, "картинка не загрузилась");
                }
            });
        } else {
            Picasso.with(c).load(R.drawable.placeholder).error(R.drawable.placeholder_eror).resize(600, 300)
                    .centerInside().into(img);
        }


    }
}

