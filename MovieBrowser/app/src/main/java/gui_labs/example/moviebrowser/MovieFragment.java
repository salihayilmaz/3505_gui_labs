package gui_labs.example.moviebrowser;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gui_labs.example.moviebrowser.dummy.DummyContent;
import gui_labs.example.moviebrowser.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnMovieSelectionListener mListener;

    List<Movie> movies = new ArrayList<>();

    public MovieFragment() {
    }

    public static MovieFragment newInstance(int columnCount) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        movies.add(new Movie("The Shawshank Redemption","Frank Darabont",1994,
                Arrays.asList(new String[]{"Tim Robbins", "Morgan Freeman", "Bob Gunton"}),
                "Two imprisoned men bond over a number of years, " +
                        "finding solace and eventual redemption through acts of common decency."));
        movies.add(new Movie("The Godfather","Francis Ford Coppola",1972,
                Arrays.asList(new String[]{"Marlon Brando", "Al Pacino", " James Caan"}),
                "The aging patriarch of an organized crime dynasty transfers control of his "
                        +
                        "clandestine empire to his reluctant son."));
        movies.add(new Movie("Pulp Fiction","Quentin Tarantino",1994,
                Arrays.asList(new String[]{"John Travolta", "Uma Thurman", "Samuel L. Jackson"}),
                "The aging patriarch of an organized crime dynasty transfers control of " +
                        "his clandestine empire to his reluctant son."));

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyMovieRecyclerViewAdapter(movies, mListener));
        }
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMovieSelectionListener) {
            mListener = (OnMovieSelectionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnMovieSelectionListener {
        void movieSelected(Movie item);
    }
}
