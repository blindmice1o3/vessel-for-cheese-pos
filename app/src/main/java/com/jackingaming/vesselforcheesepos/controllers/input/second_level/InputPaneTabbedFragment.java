package com.jackingaming.vesselforcheesepos.controllers.input.second_level;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.DrinksCustomizationsInputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.DrinksFlavorsInputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.DrinksMilksInputPaneFragment;
import com.jackingaming.vesselforcheesepos.views.input.VerticalTextView;

public abstract class InputPaneTabbedFragment extends InputPaneFragment {
    public static final String TAG = InputPaneTabbedFragment.class.getSimpleName();

    protected VerticalTextView vtvFlavors, vtvMilks, vtvCustomizations;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_input_pane_tabbed_screen, container, false);
        constraintLayout = view.findViewById(R.id.constraintlayout_input_pane);
        vtvFlavors = view.findViewById(R.id.vtv_syrups);
        vtvMilks = view.findViewById(R.id.vtv_milks);
        vtvCustomizations = view.findViewById(R.id.vtv_customizations);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated()");
        if (savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState == null");
            vtvFlavors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksFlavors =
                            DrinksFlavorsInputPaneFragment.newInstance(
                                    DrinksFlavorsInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksFlavorsInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksFlavors);
                }
            });
            vtvMilks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksMilks =
                            DrinksMilksInputPaneFragment.newInstance(
                                    DrinksMilksInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksMilksInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksMilks);
                }
            });
            vtvCustomizations.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksCustomizations =
                            DrinksCustomizationsInputPaneFragment.newInstance(
                                    DrinksCustomizationsInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksCustomizationsInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksCustomizations);
                }
            });
        } else {
            Log.i(TAG, "savedInstanceState != null");
        }
    }

    private void replaceFragmentInInputPaneWith(Fragment newFragment) {
        Log.i(TAG, "replaceFragmentInInputPaneWith()");
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fcv_input_pane_full_screen, newFragment)
                .commitNow();
    }
}
