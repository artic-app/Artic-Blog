package anway.somani.artic_blog;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private BlogAdapter adapter;
    private List<BlogInstance> blogList;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
    }

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.all_blogs);

        blogList = new ArrayList<>();
        adapter = new BlogAdapter(this, blogList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(9, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareBlogs();

        return view ;
    }

    private void prepareBlogs() {
        BlogInstance bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

        bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

        bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

        bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

        bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

        bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

        bi = new BlogInstance(R.string.name_of_org, R.string.simple_desc, R.string.image, "");
        blogList.add(bi);

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


}
