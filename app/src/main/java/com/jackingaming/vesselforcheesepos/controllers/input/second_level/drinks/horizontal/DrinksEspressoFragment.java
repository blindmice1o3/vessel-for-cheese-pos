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

public class DrinksEspressoFragment extends TabbedInputPaneFragment {
    public static final String TAG = DrinksEspressoFragment.class.getSimpleName();
    public static final int NUM_OF_COLUMNS_DEFAULT = 5;
    // TODO:
    public static final int NUM_OF_ROWS_DEFAULT = determineNumOfRowsDefault(
            NUM_OF_COLUMNS_DEFAULT,
            Menu.coldCoffees.get(2).getMenuItems().size() +
                    Menu.coldCoffees.get(4).getMenuItems().size() +
                    Menu.coldCoffees.get(5).getMenuItems().size() +
                    Menu.coldCoffees.get(6).getMenuItems().size() +
                    Menu.coldCoffees.get(7).getMenuItems().size() +
                    Menu.coldCoffees.get(8).getMenuItems().size() +
                    Menu.hotCoffees.get(0).getMenuItems().size() +
                    Menu.hotCoffees.get(2).getMenuItems().size() +
                    Menu.hotCoffees.get(3).getMenuItems().size() +
                    Menu.hotCoffees.get(4).getMenuItems().size() +
                    Menu.hotCoffees.get(5).getMenuItems().size() +
                    Menu.hotCoffees.get(6).getMenuItems().size() +
                    Menu.hotCoffees.get(7).getMenuItems().size()
    );

    private static final String ARG_NUM_OF_ROWS = "num of rows";
    private static final String ARG_NUM_OF_COLUMNS = "num of columns";

    private List<String> buttonTitleEspresso = new ArrayList<>();

    {
        // TODO:
        Section icedAmericano = Menu.coldCoffees.get(2);
        Section icedShakenEspresso = Menu.coldCoffees.get(4);
        Section icedFlatWhites = Menu.coldCoffees.get(5);
        Section icedLattes = Menu.coldCoffees.get(6);
        Section icedMacchiatos = Menu.coldCoffees.get(7);
        Section icedMocha = Menu.coldCoffees.get(8);
        Section americanos = Menu.hotCoffees.get(0);
        Section cappuccinos = Menu.hotCoffees.get(2);
        Section espressoShots = Menu.hotCoffees.get(3);
        Section flatWhites = Menu.hotCoffees.get(4);
        Section lattes = Menu.hotCoffees.get(5);
        Section macchiatos = Menu.hotCoffees.get(6);
        Section mochas = Menu.hotCoffees.get(7);

        for (MenuItem menuItem : icedAmericano.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedShakenEspresso.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedFlatWhites.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedLattes.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedMacchiatos.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : icedMocha.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : americanos.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : cappuccinos.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : espressoShots.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : flatWhites.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : lattes.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : macchiatos.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }
        for (MenuItem menuItem : mochas.getMenuItems()) {
            buttonTitleEspresso.add(
                    menuItem.getId()
            );
        }

        if (buttonTitleEspresso.size() < (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT)) {
            int numberOfEmptyButton = (NUM_OF_COLUMNS_DEFAULT * NUM_OF_ROWS_DEFAULT) - buttonTitleEspresso.size();
            for (int i = 0; i < numberOfEmptyButton; i++) {
                buttonTitleEspresso.add("");
            }
        }
    }

    public static DrinksEspressoFragment newInstance(int param1, int param2) {
        Log.i(TAG, "newInstance()");
        DrinksEspressoFragment fragment = new DrinksEspressoFragment();
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
                buttonTitleEspresso.get(indexButtonTitle)
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
                    Section icedAmericano = Menu.coldCoffees.get(2);
                    Section icedShakenEspresso = Menu.coldCoffees.get(4);
                    Section icedFlatWhites = Menu.coldCoffees.get(5);
                    Section icedLattes = Menu.coldCoffees.get(6);
                    Section icedMacchiatos = Menu.coldCoffees.get(7);
                    Section icedMocha = Menu.coldCoffees.get(8);
                    Section americanos = Menu.hotCoffees.get(0);
                    Section cappuccinos = Menu.hotCoffees.get(2);
                    Section espressoShots = Menu.hotCoffees.get(3);
                    Section flatWhites = Menu.hotCoffees.get(4);
                    Section lattes = Menu.hotCoffees.get(5);
                    Section macchiatos = Menu.hotCoffees.get(6);
                    Section mochas = Menu.hotCoffees.get(7);

                    for (MenuItem menuItem : icedAmericano.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedShakenEspresso.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedFlatWhites.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedLattes.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedMacchiatos.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : icedMocha.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : americanos.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : cappuccinos.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : espressoShots.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : flatWhites.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : lattes.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : macchiatos.getMenuItems()) {
                        if (tagOfSelectedButton.equals(menuItem.getId())) {
                            inputPaneFragmentListener.onMenuItemClicked(
                                    createCopyOfMenuItemFromMenu(menuItem)
                            );
                            return;
                        }
                    }
                    for (MenuItem menuItem : mochas.getMenuItems()) {
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
