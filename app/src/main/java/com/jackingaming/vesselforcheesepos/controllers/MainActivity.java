package com.jackingaming.vesselforcheesepos.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.controllers.input.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.InputFragment;
import com.jackingaming.vesselforcheesepos.controllers.viewport.ViewportFragment;
import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class MainActivity extends AppCompatActivity
        implements InputPaneFragment.ClickListener, ViewportFragment.PostButtonListener {
    public static final String TAG = "MainActivity";

    private ViewportFragment viewportFragment;
    private InputFragment inputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            viewportFragment = ViewportFragment.newInstance(null, null);
            inputFragment = InputFragment.newInstance(null, null);

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fcv_viewport, viewportFragment, "viewport")
                    .add(R.id.fcv_input, inputFragment, "input")
                    .commitNow();
        }
    }

    @Override
    public void onInputPaneButtonClicked(MenuItem menuItem) {
        viewportFragment.addMenuItem(menuItem);
    }

    @Override
    public void onInputPaneButtonClicked(DrinkComponent drinkComponent) {
        viewportFragment.addDrinkComponent(drinkComponent);
    }

    @Override
    public void onPostButtonClicked() {
        Log.i(TAG, "onPostButtonClicked()");
    }
}