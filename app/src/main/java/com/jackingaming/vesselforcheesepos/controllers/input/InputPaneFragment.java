package com.jackingaming.vesselforcheesepos.controllers.input;

import android.content.Context;
import android.content.res.Resources;
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
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu.UndefinedMenuItem;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.other.Water;
import com.jackingaming.vesselforcheesepos.models.menu.foods.Bread;
import com.jackingaming.vesselforcheesepos.models.menu.sides.SteamedVegetable;
import com.jackingaming.vesselforcheesepos.views.input.VerticalTextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputPaneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputPaneFragment extends Fragment {
    public static final String TAG = InputPaneFragment.class.getSimpleName();

    private static final String ARG_TYPE = "type";
    private static final String ARG_NUMBER_OF_ROWS = "number of rows";
    private static final String ARG_NUMBER_OF_COLUMNS = "number of columns";
    private static final String ARG_TEXT_FOR_BUTTONS = "text for buttons";

    public enum Type {
        FOODS, SIDES, DRINKS_HOME,
        DRINKS_SYRUPS, DRINKS_MILKS, DRINKS_CUSTOMIZATIONS;
    }

    private Type type;
    private int numberOfRows;
    private int numberOfColumns;
    private String[] textForButtons;
    private VerticalTextView vtvSyrups, vtvMilks, vtvCustomizations;
    private ConstraintLayout constraintLayout;
    private Button[][] buttons;

    public interface InputPaneFragmentListener {
        void onMenuItemClicked(MenuItem menuItem);

        void onDrinkComponentClicked(DrinkComponent drinkComponent);
    }

    private InputPaneFragmentListener inputPaneFragmentListener;

    public InputPaneFragment() {
        // Required empty public constructor
    }

    public static InputPaneFragment newInstance(
            Type type, int numberOfRows, int numberOfColumns) {
        InputPaneFragment fragment = new InputPaneFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_TYPE, type);
        args.putInt(ARG_NUMBER_OF_ROWS, numberOfRows);
        args.putInt(ARG_NUMBER_OF_COLUMNS, numberOfColumns);
        fragment.setArguments(args);

        return fragment;
    }

    public static InputPaneFragment newInstance(
            Type type, int numberOfRows, int numberOfColumns,
            String[] textForButtons) {
        InputPaneFragment fragment = new InputPaneFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_TYPE, type);
        args.putInt(ARG_NUMBER_OF_ROWS, numberOfRows);
        args.putInt(ARG_NUMBER_OF_COLUMNS, numberOfColumns);
        args.putSerializable(ARG_TEXT_FOR_BUTTONS, textForButtons);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof InputPaneFragmentListener) {
            inputPaneFragmentListener = (InputPaneFragmentListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement InputPaneFragmentListener");
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
                        "onCreate() getArguments() != null (type=%s, numberOfRows=%d, numberOfColumns=%d)",
                        type.name(), numberOfRows, numberOfColumns));

                // TODO: load by pass-in list
                if (type == Type.DRINKS_CUSTOMIZATIONS) {
                    textForButtons = (String[]) getArguments().getSerializable(ARG_TEXT_FOR_BUTTONS);
                    int index = 0;
                    for (String word : textForButtons) {
                        Log.i(TAG, index + ": " + word);
                        index++;
                    }
                }
            } else {
                Log.e(TAG, "onCreate() getArguments() == null");
            }
        } else {
            Log.i(TAG, "onCreate() savedInstanceState != null");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;

        switch (type) {
            case FOODS:
            case SIDES:
                view = inflater.inflate(R.layout.fragment_input_pane_full_screen, container, false);
                break;
            case DRINKS_HOME:
            case DRINKS_SYRUPS:
            case DRINKS_MILKS:
            case DRINKS_CUSTOMIZATIONS:
                view = inflater.inflate(R.layout.fragment_input_pane_tabbed_screen, container, false);
                vtvSyrups = view.findViewById(R.id.vtv_syrups);
                vtvMilks = view.findViewById(R.id.vtv_milks);
                vtvCustomizations = view.findViewById(R.id.vtv_customizations);
                break;
            default:
                Log.e(TAG, "onCreateView() switch(Type)'s default");
                view = inflater.inflate(R.layout.fragment_input_pane_full_screen, container, false);
                break;
        }

        constraintLayout = view.findViewById(R.id.constraintlayout_input_pane);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            Log.i(TAG, "onViewCreated() savedInstanceState == null");
            switch (type) {
                case FOODS:
                case SIDES:
                    break;
                case DRINKS_HOME:
                case DRINKS_SYRUPS:
                case DRINKS_MILKS:
                case DRINKS_CUSTOMIZATIONS:
                    vtvSyrups.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Fragment newFragmentForInputPane = InputPaneFragment.newInstance(
                                    Type.DRINKS_SYRUPS, 3, 5);
                            replaceFragmentInInputPaneWith(newFragmentForInputPane);
                        }
                    });
                    vtvMilks.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Fragment newFragmentForInputPane = InputPaneFragment.newInstance(
                                    Type.DRINKS_MILKS, 5, 2);
                            replaceFragmentInInputPaneWith(newFragmentForInputPane);
                        }
                    });
                    vtvCustomizations.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String textFromFile = readTextFileFromRawResourceId(R.raw.drink_customization_tab);
                            String[] textProcessed = splitTextByCommaAndTrimmedWhiteSpace(textFromFile);

                            // TODO: testing
                            for (String word : textProcessed) {
                                Log.i(TAG, word);
                            }

                            // TODO: using the overloaded newInstance()!
                            Fragment newFragmentForInputPane = InputPaneFragment.newInstance(
                                    Type.DRINKS_CUSTOMIZATIONS, 7, 6,
                                    textProcessed);
                            replaceFragmentInInputPaneWith(newFragmentForInputPane);
                        }
                    });
                    break;
                default:
                    Log.e(TAG, "onViewCreated() switch(Type)'s default");
                    break;
            }

            initButtons();
        } else {
            Log.i(TAG, "onViewCreated() savedInstanceState != null");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        inputPaneFragmentListener = null;
    }

    private void initButtons() {
        buttons = new Button[numberOfRows][numberOfColumns];

        int indexTextForButtons = 0;
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
                    case SIDES:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(SteamedVegetable.NAME_DEFAULT);
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case DRINKS_HOME:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(Water.NAME_DEFAULT);
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case DRINKS_SYRUPS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(FlavorOptions.Sauce.DARK_CARAMEL.name());
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case DRINKS_MILKS:
                        if (row == 0 && column == 0) {
                            buttonNew.setText(MilkOptions.MilkBase.TWO_PERCENT.name());
                            buttonNew.setBackgroundColor(Color.MAGENTA);
                        } else {
                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        }
                        break;
                    case DRINKS_CUSTOMIZATIONS:
                        // TODO: load by pass-in list
                        buttonNew.setText(textForButtons[indexTextForButtons]);
                        indexTextForButtons++;

//                        if (row == 0 && column == 0) {
//                            buttonNew.setText(LineCupWithDrizzle.TAG + ": " + Sauce.Type.CARAMEL_DRIZZLE.name());
//                            buttonNew.setBackgroundColor(Color.MAGENTA);
//                        } else {
//                            buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
//                        }
                        break;
                    default:
                        Log.e(TAG, "initButtons() switch(Type)'s default (setting button's text)");
                        buttonNew.setText(UndefinedMenuItem.NAME_DEFAULT);
                        break;
                }

                switch (type) {
                    case FOODS:
                    case SIDES:
                    case DRINKS_HOME:
                        buttonNew.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String tagOfSelectedButton = (String) view.getTag();
                                MenuItem menuItemSelected = Menu.instantiateMenuItemByButtonTag(tagOfSelectedButton);
                                inputPaneFragmentListener.onMenuItemClicked(menuItemSelected);
                            }
                        });
                        break;
                    case DRINKS_SYRUPS:
                    case DRINKS_MILKS:
                    case DRINKS_CUSTOMIZATIONS:
                        buttonNew.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String tagOfSelectedButton = (String) view.getTag();
                                DrinkComponent customizedDrinkComponent = Menu.instantiateDrinkComponentByButtonTag(tagOfSelectedButton);
                                inputPaneFragmentListener.onDrinkComponentClicked(customizedDrinkComponent);
                            }
                        });
                        break;
                    default:
                        Log.e(TAG, "initButtons() switch(Type)'s default (setting button's click handler)");
                        break;
                }


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

    private void replaceFragmentInInputPaneWith(Fragment newFragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fcv_input_pane_full_screen, newFragment)
                .commitNow();
    }

    private String readTextFileFromRawResourceId(int resourceId) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = getResources().openRawResource(resourceId);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String[] splitTextByCommaAndTrimmedWhiteSpace(String text) {
        String[] textProcessed = text.split(",");
        for (int i = 0; i < textProcessed.length; i++) {
            textProcessed[i] = textProcessed[i].trim();
        }
        return textProcessed;
    }
}