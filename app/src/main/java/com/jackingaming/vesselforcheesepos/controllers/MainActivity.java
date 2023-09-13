package com.jackingaming.vesselforcheesepos.controllers;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.controllers.input._top_level.InputFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.viewport.ViewportFragment;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;

public class MainActivity extends AppCompatActivity
        implements ViewportFragment.PostButtonListener,
        InputPaneFragment.InputPaneFragmentListener {
    public static final String TAG = MainActivity.class.getSimpleName();

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
    public void onMenuItemClicked(MenuItem menuItem) {
        viewportFragment.addMenuItem(menuItem);
    }

    @Override
    public void onDrinkComponentClicked(DrinkComponent drinkComponent) {
        viewportFragment.addDrinkComponent(drinkComponent);
    }

    @Override
    public void onPostButtonClicked() {
        Log.i(TAG, "onPostButtonClicked()");
    }
}