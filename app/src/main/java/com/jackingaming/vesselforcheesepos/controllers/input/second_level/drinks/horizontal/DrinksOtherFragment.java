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
            NUM_OF_COLUMNS_DEFAULT,
            Menu.hotDrinks.get(0).getMenuItems().size() +
                    Menu.hotDrinks.get(1).getMenuItems().size() +
                    Menu.hotDrinks.get(2).getMenuItems().size() +
                    Menu.coldDrinks.get(0).getMenuItems().size() +
                    Menu.coldDrinks.get(1).getMenuItems().size() +
                    Menu.coldDrinks.get(2).getMenuItems().size() +
                    Menu.coldDrinks.get(4).getMenuItems().size()
    );

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    private List<String> buttonTitleOther = new ArrayList<>();

    {
        // TODO:
        Section hotChocolates = Menu.hotDrinks.get(0);
        Section juice = Menu.hotDrinks.get(1);
        Section steamers = Menu.hotDrinks.get(2);
        Section refreshers = Menu.coldDrinks.get(0);
        Section icedJuice = Menu.coldDrinks.get(1);
        Section milk = Menu.coldDrinks.get(2);
        Section water = Menu.coldDrinks.get(4);

        for (MenuItem menuItem : hotChocolates.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : juice.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : steamers.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : refreshers.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedJuice.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : milk.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : water.getMenuItems()) {
            buttonTitleOther.add(
                    menuItem.getId()
            );
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
                    // TODO:
                    Section hotChocolates = Menu.hotDrinks.get(0);
                    Section juice = Menu.hotDrinks.get(1);
                    Section steamers = Menu.hotDrinks.get(2);
                    Section refreshers = Menu.coldDrinks.get(0);
                    Section icedJuice = Menu.coldDrinks.get(1);
                    Section milk = Menu.coldDrinks.get(2);
                    Section water = Menu.coldDrinks.get(4);

                    for (MenuItem menuItem : hotChocolates.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : juice.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : steamers.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : refreshers.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedJuice.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : milk.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : water.getMenuItems()) {
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
