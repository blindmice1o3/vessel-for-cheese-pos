package com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.controllers.input.second_level.InputPaneTabbedFragment;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.water.FilteredTapWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.foods.Bread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrinksHomeInputPaneFragment extends InputPaneTabbedFragment {
    public static final String TAG = DrinksHomeInputPaneFragment.class.getSimpleName();
    public static final int NUM_OF_ROWS_DEFAULT = 1;
    public static final int NUM_OF_COLUMNS_DEFAULT = 1;

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    // TODO:
//    private List<String> buttonTitleDrinks = Menu.createListOfButtonTitleDrinks();
    private List<String> buttonTitleDrinks = Arrays.asList("Filtered Tap Water");

    public static DrinksHomeInputPaneFragment newInstance(int param1, int param2) {
        Log.i(TAG, "newInstance()");
        DrinksHomeInputPaneFragment fragment = new DrinksHomeInputPaneFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUM_OF_ROWS, param1);
        args.putInt(ARG_NUM_OF_COLUMNS, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");

        if (savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState == null");
            if (getArguments() != null) {
                Log.i(TAG, "getArguments() != null");
                numberOfRows = getArguments().getInt(ARG_NUM_OF_ROWS);
                numberOfColumns = getArguments().getInt(ARG_NUM_OF_COLUMNS);
            } else {
                Log.i(TAG, "getArguments() == null");
            }
        } else {
            Log.i(TAG, "savedInstanceState != null");
        }
    }

    @Override
    protected void initButtonText(Button buttonNew) {
        Log.i(TAG, "initButtonText()");
        buttonNew.setText(
                buttonTitleDrinks.get(indexButtonTitle)
        );
        indexButtonTitle++;
    }

    @Override
    protected void initOnClickListener(Button buttonNew) {
        Log.i(TAG, "initOnClickListener()");
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tagOfSelectedButton = (String) view.getTag();
                Log.i(TAG, tagOfSelectedButton);
                // TODO:
//                MenuItem menuItemSelected = Menu.instantiateMenuItemByButtonTag(tagOfSelectedButton);
                MenuItem menuItemSelected = new FilteredTapWater();
                inputPaneFragmentListener.onMenuItemClicked(menuItemSelected);
            }
        });
    }
}
