package tylkovich.interview_android_1.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import tylkovich.interview_android_1.R;
import tylkovich.interview_android_1.data.ShowParameter;
import tylkovich.interview_android_1.picasso.Picaso;


/**
 * Created by tylkovich on 10.08.2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context c;
    ArrayList<ShowParameter> mShowParameters;

    public MyAdapter(Context c, ArrayList<ShowParameter> showParameters) {
        this.c = c;
        this.mShowParameters = showParameters;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyHolder holder = new MyHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

//Изображение
        if (position == mShowParameters.size() - 1) {
           Toast.makeText(c, c.getString(R.string.all_item_loaded), Toast.LENGTH_LONG).show();
        }
        Picaso.downloadImage(c, mShowParameters.get(position).getUrl(), holder.img);
    }

    @Override
    public int getItemCount() {
        return mShowParameters.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView nameTxt;
        ImageView img;
        public MyHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.mImage);
        }
    }


}
