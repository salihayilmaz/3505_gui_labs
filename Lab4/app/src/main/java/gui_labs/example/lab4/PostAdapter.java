package gui_labs.example.lab4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gui_labs.example.lab4.Post;
import gui_labs.example.lab4.R;

public class PostAdapter extends BaseAdapter {

    List<Post> posts;

    private LayoutInflater inflater;

    public PostAdapter(Activity activity, List<Post> posts) {
        this.posts = posts;
        inflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return posts.size();
    }

    public Object getItem(int position) {
        return posts.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView;
        rowView = inflater.inflate(R.layout.row, null);
        EditText txtMessage = (EditText) rowView.findViewById(R.id.txtMessage);
        TextView txtLocation = (TextView) rowView.findViewById(R.id.txtLocation);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        Post post = posts.get(position);
        txtMessage.setText(post.getMessage());
        imageView.setImageBitmap(post.getImage());
        if (post.getLocation() != null) {
            txtLocation.setText(post.getLocation().getLatitude() + " "
                    + post.getLocation().getLongitude());
        }
        return rowView;


    }
}
