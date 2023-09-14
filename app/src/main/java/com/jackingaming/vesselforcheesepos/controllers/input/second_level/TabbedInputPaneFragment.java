package com.jackingaming.vesselforcheesepos.controllers.input.second_level;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.horizontal.DrinksBlendedFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.horizontal.DrinksBrewedFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.horizontal.DrinksEspressoFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.horizontal.DrinksOtherFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.horizontal.DrinksTeaFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.vertical.DrinksCustomizationsFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.vertical.DrinksFlavorsFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.vertical.DrinksMilksFragment;
import com.jackingaming.vesselforcheesepos.views.input.VerticalTextView;

public abstract class TabbedInputPaneFragment extends InputPaneFragment {
    public static final String TAG = TabbedInputPaneFragment.class.getSimpleName();

    protected VerticalTextView vtvFlavors, vtvMilks, vtvCustomizations;
    protected TextView tvBrewed, tvEspresso, tvBlended, tvTea, tvOther;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_input_pane_tabbed_screen, container, false);
        constraintLayout = view.findViewById(R.id.constraintlayout_input_pane);
        vtvFlavors = view.findViewById(R.id.vtv_syrups);
        vtvMilks = view.findViewById(R.id.vtv_milks);
        vtvCustomizations = view.findViewById(R.id.vtv_customizations);
        tvBrewed = view.findViewById(R.id.tv_brewed);
        tvEspresso = view.findViewById(R.id.tv_espresso);
        tvBlended = view.findViewById(R.id.tv_blended);
        tvTea = view.findViewById(R.id.tv_tea);
        tvOther = view.findViewById(R.id.tv_other);
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
                            DrinksFlavorsFragment.newInstance(
                                    DrinksFlavorsFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksFlavorsFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksFlavors);
                }
            });
            vtvMilks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksMilks =
                            DrinksMilksFragment.newInstance(
                                    DrinksMilksFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksMilksFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksMilks);
                }
            });
            vtvCustomizations.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksCustomizations =
                            DrinksCustomizationsFragment.newInstance(
                                    DrinksCustomizationsFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksCustomizationsFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksCustomizations);
                }
            });
            tvBrewed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksBrewed =
                            DrinksBrewedFragment.newInstance(
                                    DrinksBrewedFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksBrewedFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksBrewed);
                }
            });
            tvEspresso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksEspresso =
                            DrinksEspressoFragment.newInstance(
                                    DrinksEspressoFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksEspressoFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksEspresso);
                }
            });
            tvBlended.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksBlended =
                            DrinksBlendedFragment.newInstance(
                                    DrinksBlendedFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksBlendedFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksBlended);
                }
            });
            tvTea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksTea =
                            DrinksTeaFragment.newInstance(
                                    DrinksTeaFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksTeaFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksTea);
                }
            });
            tvOther.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksOther =
                            DrinksOtherFragment.newInstance(
                                    DrinksOtherFragment.NUM_OF_ROWS_DEFAULT,
                                    DrinksOtherFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksOther);
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

    protected static int determineNumOfRowsDefault(int numOfColumns, int sizeOfCollection) {
        int numOfRowsDefault = 0;

        if (sizeOfCollection % numOfColumns == 0) {
            numOfRowsDefault = sizeOfCollection / numOfColumns;
        } else {
            numOfRowsDefault = (sizeOfCollection / numOfColumns) + 1;
        }

        return numOfRowsDefault;
    }
}
