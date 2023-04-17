package com.jackingaming.vesselforcheesepos.controllers.viewport;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.other.Water;
import com.jackingaming.vesselforcheesepos.models.menu.foods.Bread;
import com.jackingaming.vesselforcheesepos.views.viewport.MenuItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewportFragment extends Fragment {
    public static final String TAG = ViewportFragment.class.getSimpleName();

    public static final int INDEX_NO_SELECTION = -1;
    public static final float ALPHA_SELECTED = 0.5f, ALPHA_NOT_SELECTED = 1.0f;

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

    private int indexSelected = INDEX_NO_SELECTION;
    private TextView tvIndexDisplayer;
    private View viewSelected;

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

    private void updateSelection(int position, View view) {
        indexSelected = position;
        viewSelected = view;
    }

    private void resetViewSelected() {
        if (viewSelected != null) {
            unhighlightViewSelected();
            viewSelected = null;
        } else {
            Toast.makeText(getContext(), "viewSelected is null", Toast.LENGTH_SHORT).show();
        }

        indexSelected = INDEX_NO_SELECTION;
    }

    private void unhighlightViewSelected() {
        viewSelected.setAlpha(ALPHA_NOT_SELECTED);
        tvIndexDisplayer.setText(Integer.toString(indexSelected));
    }

    private void highlightViewSelected() {
        viewSelected.setAlpha(ALPHA_SELECTED);
        tvIndexDisplayer.setText(Integer.toString(indexSelected));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvIndexDisplayer.setText(Integer.toString(indexSelected));

        menuItems.add(new Bread());
        menuItems.add(new Water());

        adapter = new MenuItemAdapter(menuItems,
                new MenuItemAdapter.MenuItemAdapterListener() {
                    @Override
                    public void onMenuItemClicked(int position, View view) {
                        resetViewSelected();

                        updateSelection(position, view);

                        highlightViewSelected();
                    }

                    @Override
                    public void onMenuItemLongClicked(int position, View view) {
                        adapter.removeMenuItem(position);

                        resetViewSelected();
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

    public void addMenuItem(MenuItem menuItem) {
        adapter.addMenuItem(menuItem);
    }

    public void addDrinkComponent(DrinkComponent drinkComponent) {
        if (indexSelected == -1) {
            Log.i(TAG, "addDrinkComponent(DrinkComponent) indexSelected is -1. returning.");
            return;
        }

        MenuItem menuItemSelected = menuItems.get(indexSelected);
        if (menuItemSelected instanceof Drink) {
            Log.i(TAG, "addDrinkComponent(DrinkComponent) menuItemSelected is a Drink.");
            RecyclerView.ViewHolder viewHolderDrinkSelected = rvStagingArea.findViewHolderForAdapterPosition(indexSelected);
            adapter.addDrinkComponentToSelectedDrink(viewHolderDrinkSelected, drinkComponent);
        } else {
            Log.i(TAG, "addDrinkComponent(DrinkComponent) menuItemSelected is NOT a Drink.");
        }
    }
}