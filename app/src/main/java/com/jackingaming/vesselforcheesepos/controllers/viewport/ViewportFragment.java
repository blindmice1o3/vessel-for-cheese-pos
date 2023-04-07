package com.jackingaming.vesselforcheesepos.controllers.viewport;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.MenuItem;
import com.jackingaming.vesselforcheesepos.models.TwoPercentMilk;
import com.jackingaming.vesselforcheesepos.models.sides.SteamedVegetable;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewportFragment extends Fragment {

    public interface PostButtonListener {
        void onPostButtonClicked();
    }

    private PostButtonListener postButtonListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tvIndexDisplayer;
    private int indexSelected = -1;

    // TODO: initRecyclerView
    private RecyclerView rvStagingArea;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();
    private MenuItemAdapter adapter;

    private Button buttonPost;

    public ViewportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewportFragment newInstance(String param1, String param2) {
        ViewportFragment fragment = new ViewportFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof PostButtonListener) {
            postButtonListener = (PostButtonListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement PostButtonListener");
        }
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_viewport, container, false);

        tvIndexDisplayer = view.findViewById(R.id.tv_index_displayer);
        rvStagingArea = view.findViewById(R.id.rv_staging_area);
        buttonPost = view.findViewById(R.id.button_post);

        return view;
    }

    private View viewCurrentlySelected;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvIndexDisplayer.setText(Integer.toString(indexSelected));

        menuItems.add(new SteamedVegetable());
        menuItems.add(new TwoPercentMilk());

        adapter = new MenuItemAdapter(menuItems,
                new MenuItemAdapter.MenuItemAdapterListener() {
                    @Override
                    public void onMenuItemClicked(int position, View view) {
                        // updateSelection()
                        if (viewCurrentlySelected != null) {
                            viewCurrentlySelected.setAlpha(1.0f);
                        }

                        indexSelected = position;
                        tvIndexDisplayer.setText(Integer.toString(indexSelected));

                        view.setAlpha((0.5f));
                        viewCurrentlySelected = view;
                    }

                    @Override
                    public void onMenuItemLongClicked(int position) {
                        // removeSelection()
                        menuItems.remove(position);
                        adapter.notifyItemRemoved(position);

                        if (viewCurrentlySelected != null) {
                            viewCurrentlySelected.setAlpha(1.0f);
                        }

                        viewCurrentlySelected = null;
                        indexSelected = -1;
                        tvIndexDisplayer.setText(Integer.toString(indexSelected));
                    }
                });
        rvStagingArea.setAdapter(adapter);
        rvStagingArea.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rvStagingArea.addItemDecoration(itemDecoration);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        postButtonListener = null;
    }

    public void addItem(MenuItem menuItem) {
        // BEFORE change to data [record state]
//        int indexEnd = adapter.getItemCount();

        // TODO: May change to BIDIRECTIONAL relationship using MenuItem and OrderInfo
        //  classes. For this, MenuItem should have an OrderInfo field. After calling
        //  "orderInfo.addMenuItem(menuItem)", there should be "menuItem.setOrderInfo(orderInfo)".
        adapter.addItem(menuItem);
//        menuItems.add(menuItem);

        // AFTER change to data [update view]
//        adapter.notifyItemInserted(indexEnd);
    }
}