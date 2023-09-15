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

public class DrinksTeaFragment extends TabbedInputPaneFragment {
    public static final String TAG = DrinksTeaFragment.class.getSimpleName();
    public static final int NUM_OF_COLUMNS_DEFAULT = 5;
    // TODO:
    public static final int NUM_OF_ROWS_DEFAULT = determineNumOfRowsDefault(
            NUM_OF_COLUMNS_DEFAULT,
            Menu.hotTeas.get(0).getMenuItems().size() +
                    Menu.hotTeas.get(1).getMenuItems().size() +
                    Menu.hotTeas.get(2).getMenuItems().size() +
                    Menu.hotTeas.get(3).getMenuItems().size() +
                    Menu.icedTeas.get(1).getMenuItems().size() +
                    Menu.icedTeas.get(2).getMenuItems().size() +
                    Menu.icedTeas.get(3).getMenuItems().size() +
                    Menu.icedTeas.get(4).getMenuItems().size()
    );

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    private List<String> buttonTitleTea = new ArrayList<>();

    {
        // TODO:
        Section chaiTeas = Menu.hotTeas.get(0);
        Section blackTeas = Menu.hotTeas.get(1);
        Section greenTeas = Menu.hotTeas.get(2);
        Section herbalTeas = Menu.hotTeas.get(3);
        Section icedBlackTeas = Menu.icedTeas.get(1);
        Section icedChaiTeas = Menu.icedTeas.get(2);
        Section icedGreenTeas = Menu.icedTeas.get(3);
        Section icedHerbalTeas = Menu.icedTeas.get(4);

        for (MenuItem menuItem : chaiTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : blackTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : greenTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : herbalTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedBlackTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedChaiTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedGreenTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedHerbalTeas.getMenuItems()) {
            buttonTitleTea.add(
                    menuItem.getId()
            );
        }

        if (buttonTitleTea.size() < (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT)) {
            int numberOfEmptyButton = (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT) - buttonTitleTea.size();
            for (int i = 0; i < numberOfEmptyButton; i++) {
                buttonTitleTea.add("");
            }
        }
    }

    public static DrinksTeaFragment newInstance(int param1, int param2) {
        Log.i(TAG, "newInstance()");
        DrinksTeaFragment fragment = new DrinksTeaFragment();
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
                buttonTitleTea.get(indexButtonTitle)
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
                    Section chaiTeas = Menu.hotTeas.get(0);
                    Section blackTeas = Menu.hotTeas.get(1);
                    Section greenTeas = Menu.hotTeas.get(2);
                    Section herbalTeas = Menu.hotTeas.get(3);
                    Section icedBlackTeas = Menu.icedTeas.get(1);
                    Section icedChaiTeas = Menu.icedTeas.get(2);
                    Section icedGreenTeas = Menu.icedTeas.get(3);
                    Section icedHerbalTeas = Menu.icedTeas.get(4);

                    for (MenuItem menuItem : chaiTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : blackTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : greenTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : herbalTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedBlackTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedChaiTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedGreenTeas.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedHerbalTeas.getMenuItems()) {
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
