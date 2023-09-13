package com.jackingaming.vesselforcheesepos.controllers.input.second_level;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.Drink;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class InputPaneFragment extends Fragment {
    public static final String TAG = InputPaneFragment.class.getSimpleName();

    protected ConstraintLayout constraintLayout;
    protected int numberOfRows, numberOfColumns;
    protected int indexButtonTitle;
    private Button[][] buttons;

    public interface InputPaneFragmentListener {
        void onMenuItemClicked(MenuItem menuItem);

        void onDrinkComponentClicked(DrinkComponent drinkComponent);
    }

    protected InputPaneFragmentListener inputPaneFragmentListener;

    public InputPaneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
        if (context instanceof InputPaneFragmentListener) {
            Log.i(TAG, "context instanceof InputPaneFragmentListener");
            inputPaneFragmentListener = (InputPaneFragmentListener) context;
        } else {
            Log.i(TAG, "context NOT instanceof InputPaneFragmentListener");
            throw new ClassCastException(context.toString()
                    + " must implement InputPaneFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_input_pane_full_screen, container, false);
        constraintLayout = view.findViewById(R.id.constraintlayout_input_pane);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated()");
        if (savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState != null");
            initButtons();
        } else {
            Log.i(TAG, "savedInstanceState != null");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
        inputPaneFragmentListener = null;
    }

    protected abstract void initButtonText(Button buttonNew);

    protected abstract void initOnClickListener(Button buttonNew);

    protected Drink createCopyOfMenuItemFromMenu(MenuItem menuItem) {
        if (menuItem instanceof Drink) {
            Log.i(TAG, "menuItem instanceof Drink");

            Drink original = (Drink) menuItem;
            Drink copy = null;
            try {
                // Serialize the object
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(original);
                oos.close();

                // Deserialize the object
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                copy = (Drink) ois.readObject();
            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }

            return copy;
        } else {
            Log.e(TAG, "NOT menuItem instanceof Drink");

            return null;
        }
    }

    private void initButtons() {
        Log.i(TAG, "initButtons()");
        buttons = new Button[numberOfRows][numberOfColumns];

        indexButtonTitle = 0;
        View buttonPrevious = null;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                // Define the new Button and add it to the ConstraintLayout.
                // Without constraints, this view will be positioned at (0,0).
                Button buttonNew = new Button(getContext());
                buttons[row][column] = buttonNew;
                buttonNew.setId(View.generateViewId());
                buttonNew.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12.0f);

                // The sequence is important
                initButtonText(buttonNew);
                initOnClickListener(buttonNew);
                buttonNew.setTag(buttonNew.getText().toString());

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