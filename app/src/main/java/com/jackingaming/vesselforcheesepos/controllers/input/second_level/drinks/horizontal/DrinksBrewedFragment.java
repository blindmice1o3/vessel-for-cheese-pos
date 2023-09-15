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

public class DrinksBrewedFragment extends TabbedInputPaneFragment {
    public static final String TAG = DrinksBrewedFragment.class.getSimpleName();
    public static final int NUM_OF_COLUMNS_DEFAULT = 5;
    // TODO:
    public static final int NUM_OF_ROWS_DEFAULT = determineNumOfRowsDefault(
            NUM_OF_COLUMNS_DEFAULT,
            Menu.coldCoffees.get(0).getMenuItems().size() +
                    Menu.coldCoffees.get(1).getMenuItems().size() +
                    Menu.coldCoffees.get(3).getMenuItems().size() +
                    Menu.hotCoffees.get(1).getMenuItems().size()
    );

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    private List<String> buttonTitleBrewed = new ArrayList<>();

    {
        // TODO:
        Section coldBrews = Menu.coldCoffees.get(0);
        Section nitroColdBrews = Menu.coldCoffees.get(1);
        Section icedCoffees = Menu.coldCoffees.get(3);
        Section brewedCoffees = Menu.hotCoffees.get(1);

        for (MenuItem menuItem : coldBrews.getMenuItems()) {
            buttonTitleBrewed.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : nitroColdBrews.getMenuItems()) {
            buttonTitleBrewed.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedCoffees.getMenuItems()) {
            buttonTitleBrewed.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : brewedCoffees.getMenuItems()) {
            buttonTitleBrewed.add(
                    menuItem.getId()
            );
        }

        if (buttonTitleBrewed.size() < (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT)) {
            int numberOfEmptyButton = (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT) - buttonTitleBrewed.size();
            for (int i = 0; i < numberOfEmptyButton; i++) {
                buttonTitleBrewed.add("");
            }
        }
    }

    public static DrinksBrewedFragment newInstance(int param1, int param2) {
        Log.i(TAG, "newInstance()");
        DrinksBrewedFragment fragment = new DrinksBrewedFragment();
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
                buttonTitleBrewed.get(indexButtonTitle)
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
                    // TODO:
                    Section coldBrews = Menu.coldCoffees.get(0);
                    Section nitroColdBrews = Menu.coldCoffees.get(1);
                    Section icedCoffees = Menu.coldCoffees.get(3);
                    Section brewedCoffees = Menu.hotCoffees.get(1);

                    for (MenuItem menuItem : coldBrews.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : nitroColdBrews.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedCoffees.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : brewedCoffees.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                } else {
                    Log.e(TAG, "tagOfSelectedButton.equals(\"\")... do nothing");
                }
            }
        });
    }
}
