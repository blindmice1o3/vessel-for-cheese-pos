package com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.controllers.input.second_level.InputPaneTabbedFragment;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DrinksHomeInputPaneFragment extends InputPaneTabbedFragment {
    public static final String TAG = DrinksHomeInputPaneFragment.class.getSimpleName();
    //    public static final int NUM_OF_ROWS_DEFAULT = 1;
//    public static final int NUM_OF_COLUMNS_DEFAULT = 1;
    public static final int NUM_OF_COLUMNS_DEFAULT = 5;
    public static final int NUM_OF_ROWS_DEFAULT = determineNumOfRowsDefault(
            NUM_OF_COLUMNS_DEFAULT, Menu.blendedBeverages.get(0).getMenuItems().size() + Menu.blendedBeverages.get(1).getMenuItems().size());

    private static int determineNumOfRowsDefault(int numOfColumns, int sizeOfCollection) {
        int numOfRowsDefault = 0;

        if (sizeOfCollection % numOfColumns == 0) {
            numOfRowsDefault = sizeOfCollection / numOfColumns;
        } else {
            numOfRowsDefault = (sizeOfCollection / numOfColumns) + 1;
        }

        return numOfRowsDefault;
    }

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    // TODO:
//    private List<String> buttonTitleDrinks = Menu.createListOfButtonTitleDrinks();
    private List<String> buttonTitleDrinks = new ArrayList<>();

    {
        for (Section section : Menu.blendedBeverages) {
            for (MenuItem menuItem : section.getMenuItems()) {
                buttonTitleDrinks.add(
                        menuItem.getId()
                );
            }
        }
        if (buttonTitleDrinks.size() < (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT)) {
            int numberOfEmptyButton = (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT) - buttonTitleDrinks.size();
            for (int i = 0; i < numberOfEmptyButton; i++) {
                buttonTitleDrinks.add("");
            }
        }
    }

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

                if (!tagOfSelectedButton.equals("")) {
                    MenuItem menuItemSelected = null;
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
