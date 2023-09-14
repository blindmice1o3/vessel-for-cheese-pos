package com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.horizontal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.controllers.input.second_level.TabbedInputPaneFragment;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DrinksOtherFragment extends TabbedInputPaneFragment {
    public static final String TAG = DrinksOtherFragment.class.getSimpleName();
    public static final int NUM_OF_COLUMNS_DEFAULT = 5;
    // TODO:
    public static final int NUM_OF_ROWS_DEFAULT = determineNumOfRowsDefault(
            NUM_OF_COLUMNS_DEFAULT, Menu.blendedBeverages.get(0).getMenuItems().size() + Menu.blendedBeverages.get(1).getMenuItems().size());

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    private List<String> buttonTitleOther = new ArrayList<>();

    {
        // TODO:
        for (Section section : Menu.blendedBeverages) {
            for (MenuItem menuItem : section.getMenuItems()) {
                buttonTitleOther.add(
                        menuItem.getId()
                );
            }
        }
        if (buttonTitleOther.size() < (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT)) {
            int numberOfEmptyButton = (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT) - buttonTitleOther.size();
            for (int i = 0; i < numberOfEmptyButton; i++) {
                buttonTitleOther.add("");
            }
        }
    }

    public static DrinksOtherFragment newInstance(int param1, int param2) {
        Log.i(TAG, "newInstance()");
        DrinksOtherFragment fragment = new DrinksOtherFragment();
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
                buttonTitleOther.get(indexButtonTitle)
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

                if (!tagOfSelectedButton.equals("")) {
                    MenuItem menuItemSelected = null;
                    // TODO:
                    for (Section section : Menu.blendedBeverages) {
                        for (MenuItem menuItem : section.getMenuItems()) {
                            if (tagOfSelectedButton.equals(menuItem.getId())) {
                                menuItemSelected = createCopyOfMenuItemFromMenu(menuItem);
                            } else {
                                Log.e(TAG, "could NOT find the selected menu item");
                            }
                        }
                    }
                    inputPaneFragmentListener.onMenuItemClicked(menuItemSelected);
                } else {
                    Log.e(TAG, "tagOfSelectedButton.equals(\"\")... do nothing");
                }
            }
        });
    }
}
