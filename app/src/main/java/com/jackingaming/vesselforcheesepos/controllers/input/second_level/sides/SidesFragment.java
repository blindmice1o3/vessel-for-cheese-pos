package com.jackingaming.vesselforcheesepos.controllers.input.second_level.sides;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.controllers.input.second_level.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu_items.sides.SteamedVegetable;

import java.util.Arrays;
import java.util.List;

public class SidesFragment extends InputPaneFragment {
    public static final String TAG = SidesFragment.class.getSimpleName();
    public static final int NUM_OF_ROWS_DEFAULT = 2;
    public static final int NUM_OF_COLUMNS_DEFAULT = 2;

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    // TODO:
//    private List<String> buttonTitleSides = Menu.createListOfButtonTitleSides();
    private List<String> buttonTitleSides = Arrays.asList("Steamed Vegetable", "Steamed Vegetable", "Steamed Vegetable", "Steamed Vegetable");

    public static SidesFragment newInstance(int param1, int param2) {
        Log.i(TAG, "newInstance()");
        SidesFragment fragment = new SidesFragment();
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
                buttonTitleSides.get(indexButtonTitle)
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
                MenuItem menuItemSelected = new SteamedVegetable();
                inputPaneFragmentListener.onMenuItemClicked(menuItemSelected);
            }
        });
    }
}
