package com.jackingaming.vesselforcheesepos.controllers.input;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweeteners.liquids.sauces.Sauce;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu.UndefinedMenuItem;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milks.Milk;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.other.Water;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_in.LineCupWithDrizzle;
import com.jackingaming.vesselforcheesepos.models.menu.foods.Bread;
import com.jackingaming.vesselforcheesepos.models.menu.sides.SteamedVegetable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputPaneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputPaneFragment extends Fragment {
    public static final String TAG = "InputPaneFragment";
    private static final String ARG_TYPE = "type";
    private static final String ARG_NUMBER_OF_ROWS = "number of rows";
    private static final String ARG_NUMBER_OF_COLUMNS = "number of columns";

    public enum Type {FOODS, DRINKS, SIDES, SYRUPS, MILKS, CUSTOMIZATIONS;}

    private Type type;
    private int numberOfRows;
    private int numberOfColumns;
    private ConstraintLayout constraintLayout;
    private Button[][] buttons;

    public interface ClickListener {
        void onInputPaneButtonClicked(MenuItem menuItem);

        void onInputPaneButtonClicked(DrinkComponent drinkComponent);
    }

    private ClickListener clickListener;

    public InputPaneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param numberOfRows    Parameter 1.
     * @param numberOfColumns Parameter 2.
     * @return A new instance of fragment InputPaneFragment.
     */
    public static InputPaneFragment newInstance(Type type, int numberOfRows, int numberOfColumns) {
        InputPaneFragment fragment = new InputPaneFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_TYPE, type);
        args.putInt(ARG_NUMBER_OF_ROWS, numberOfRows);
        args.putInt(ARG_NUMBER_OF_COLUMNS, numberOfColumns);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ClickListener) {
            clickListener = (ClickListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement ClickListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Log.i(TAG, "onCreate() savedInstanceState == null");
            if (getArguments() != null) {
                type = (Type) getArguments().getSerializable(ARG_TYPE);
                numberOfRows = getArguments().getInt(ARG_NUMBER_OF_ROWS);
                numberOfColumns = getArguments().getInt(ARG_NUMBER_OF_COLUMNS);
                Log.i(TAG, String.format(
                        "onCreate() getArguments() != null (numberOfRows=%d, numberOfColumns=%d)",
                        numberOfRows, numberOfColumns));
            }
            Log.e(TAG, "onCreate() getArguments() == null DO NOT HAVE numberOfRows and numberOfColumns");
        }
        Log.i(TAG, "onCreate() savedInstanceState != null");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_pane, container, false);
        constraintLayout = view.findViewById(R.id.constraintlayout_input_pane);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            Log.i(TAG, "onViewCreated() savedInstanceState == null");
            initButtons();
        }
        Log.i(TAG, "onViewCreated() savedInstanceState != null");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        clickListener = null;
    }

    private void initButtons() {
        buttons = new Button[numberOfRows][numberOfColumns];

        View buttonPrevious = null;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                // Define the new Button and add it to the ConstraintLayout.
                // Without constraints, this view will be positioned at (0,0).
                Button buttonNew = new Button(getContext());
                buttons[row][column] = buttonNew;
                buttonNew.setId(View.generateViewId());
                buttonNew.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12.0f);
                buttonNew.setText("(row:" + row + "|\ncolumn: " + column + ")");
                buttonNew.setTag(row + " " + column + " " + type.name());


                switch (type) {
                    case FOODS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(Bread.NAME_DEFAULT);
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case DRINKS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(Water.NAME_DEFAULT);
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case SIDES:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(SteamedVegetable.NAME_DEFAULT);
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case SYRUPS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(Sauce.Type.DARK_CARAMEL.name());
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case MILKS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(Milk.Type.TWO_PERCENT.name());
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case CUSTOMIZATIONS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(LineCupWithDrizzle.TAG + ": " + Sauce.Type.CARAMEL_DRIZZLE.name());
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    default:
                        buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        break;
                }

                buttonNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String tagOfSelectedButton = (String) view.getTag();

                        switch (type) {
                            case FOODS:
                            case DRINKS:
                            case SIDES:
                                MenuItem menuItemSelected = Menu.instantiateMenuItemByButtonTag(tagOfSelectedButton);
                                clickListener.onInputPaneButtonClicked(menuItemSelected);
                                break;
                            case SYRUPS:
                            case MILKS:
                            case CUSTOMIZATIONS:
                                DrinkComponent customizedDrinkComponent = Menu.instantiateDrinkComponentByButtonTag(tagOfSelectedButton);
                                clickListener.onInputPaneButtonClicked(customizedDrinkComponent);
                                break;
                            default:
                                Log.e(TAG, "initButtons() buttonNew.OnClickListener.onClick(View) switch(type)'s default case");
                                break;
                        }
                    }
                });

                float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics());
                float height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics());
                ConstraintLayout.LayoutParams layoutParams =
                        new ConstraintLayout.LayoutParams(
                                (int) width,
                                (int) height);
                constraintLayout.addView(buttonNew, layoutParams);

                // Move the new view into place by applying constraints.
                ConstraintSet constraintSet = new ConstraintSet();
                // Get existing constraints. This will be the base for modification.
                constraintSet.clone(constraintLayout);
                // Set up the connections for the new view. Constrain its top to the bottom of the top view.
                // VERTICAL CONSTRAINTS
                if (row == 0) { // first row
                    constraintSet.connect(buttonNew.getId(), ConstraintSet.TOP,
                            constraintLayout.getId(), ConstraintSet.TOP);
                } else { // not first row
                    if (row == numberOfRows - 1) { // last row
                        constraintSet.connect(buttons[row - 1][column].getId(), ConstraintSet.BOTTOM,
                                buttonNew.getId(), ConstraintSet.TOP);
                        constraintSet.connect(buttonNew.getId(), ConstraintSet.TOP,
                                buttons[row - 1][column].getId(), ConstraintSet.BOTTOM);
                        constraintSet.connect(buttonNew.getId(), ConstraintSet.BOTTOM,
                                constraintLayout.getId(), ConstraintSet.BOTTOM);
                    } else { // not last row (aka middle rows)
                        constraintSet.connect(buttons[row - 1][column].getId(), ConstraintSet.BOTTOM,
                                buttonNew.getId(), ConstraintSet.TOP);
                        constraintSet.connect(buttonNew.getId(), ConstraintSet.TOP,
                                buttons[row - 1][column].getId(), ConstraintSet.BOTTOM);
                    }
                }

                // HORIZONTAL CONSTRAINTS
                if (buttonPrevious == null) { // first column
                    Log.d(TAG, "buttonPrevious == null [FIRST ELEMENT IN ROW] column: " + column);
                    constraintSet.connect(buttonNew.getId(), ConstraintSet.LEFT,
                            constraintLayout.getId(), ConstraintSet.LEFT);
                } else { // not first column
                    Log.d(TAG, "buttonPrevious != null [not FIRST ELEMENT IN ROW] column: " + column);
                    if (column == numberOfColumns - 1) { // last column
                        constraintSet.connect(buttons[row][column - 1].getId(), ConstraintSet.RIGHT,
                                buttonNew.getId(), ConstraintSet.LEFT);
                        constraintSet.connect(buttonNew.getId(), ConstraintSet.LEFT,
                                buttons[row][column - 1].getId(), ConstraintSet.RIGHT);
                        constraintSet.connect(buttonNew.getId(), ConstraintSet.RIGHT,
                                constraintLayout.getId(), ConstraintSet.RIGHT);
                    } else { // not last column (aka middle columns)
                        constraintSet.connect(buttons[row][column - 1].getId(), ConstraintSet.RIGHT,
                                buttonNew.getId(), ConstraintSet.LEFT);
                        constraintSet.connect(buttonNew.getId(), ConstraintSet.LEFT,
                                buttons[row][column - 1].getId(), ConstraintSet.RIGHT);
                    }
                }

                // Finally, apply our good work to the layout.
                constraintSet.applyTo(constraintLayout);
                buttonPrevious = buttonNew;

                // last column
                if (column == numberOfColumns - 1) {
                    buttonPrevious = null;
                }
            }
        }
    }
}