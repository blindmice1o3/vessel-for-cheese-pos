package com.jackingaming.vesselforcheesepos.controllers;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.controllers.input._top_level.InputFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.viewport.ViewportFragment;
import com.jackingaming.vesselforcheesepos.models.Order;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItemInfo;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements ViewportFragment.PostButtonListener,
        InputPaneFragment.InputPaneFragmentListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String URL_ORDER = "http://192.168.1.184:8080/v1/orders";

    private ViewportFragment viewportFragment;
    private InputFragment inputFragment;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

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

    private List<MenuItemInfo> convertToListOfMenuItemInfo(List<MenuItem> order) {
        Log.i(TAG, "convertToListOfMenuItemInfo(List<MenuItem>)");

        List<MenuItemInfo> menuItemInfos = new ArrayList<>();

        for (MenuItem menuItem : order) {
            String menuItemId = menuItem.getId();
            String menuItemSize = null;
            List<String> menuItemCustomizations = new ArrayList<>();

            if (menuItem instanceof Drink) {
                Map<String, List<DrinkComponentWithDefaultAsString>> drinkComponents = ((Drink) menuItem).getDrinkComponents();
                for (String key : Menu.DRINK_COMPONENTS_KEYS) {
                    if (drinkComponents.containsKey(key)) {
                        List<DrinkComponentWithDefaultAsString> drinkComponentsGroup = drinkComponents.get(key);
                        for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                            DrinkComponent drinkComponent = drinkComponentsGroup.get(i).getDrinkComponent();
                            String drinkComponentDefaultAsString = drinkComponentsGroup.get(i).getDrinkComponentDefaultAsString();

                            if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                                continue;
                            }

                            if (drinkComponent instanceof Incrementable) {
                                String quantityAsString = Integer.toString(((Incrementable) drinkComponent).getQuantity());
                                if (quantityAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            } else if (drinkComponent instanceof Granular) {
                                String amountAsString = ((Granular) drinkComponent).getAmount().name();
                                if (amountAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            } else {
                                String typeAsString = drinkComponent.getTypeAsString();
                                if (typeAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            }

                            String drinkComponentDetails = null;
                            if (drinkComponent instanceof Incrementable) {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + ((Incrementable) drinkComponent).getQuantity();
                            } else if (drinkComponent instanceof GranularTwoOptions) {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + ((GranularTwoOptions) drinkComponent).getOption();
                            } else if (drinkComponent instanceof Granular) {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + ((Granular) drinkComponent).getAmount();
                            } else {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + "SimpleSelection";
                            }

                            menuItemCustomizations.add(drinkComponentDetails);
                        }
                    }
                }

                // convert DrinkSize to String
                String drinkSizeAsString = null;
                if (((Drink) menuItem) instanceof NotHandCrafted) {
                    float containerSize = ((NotHandCrafted) menuItem).getContainerSize();
                    drinkSizeAsString = (containerSize < 0) ?
                            "traveler" : containerSize + " fl oz";
                } else {
                    drinkSizeAsString = ((Drink) menuItem).getDrinkSize().getUserFriendlyName();
                }

                menuItemInfos.add(
                        new MenuItemInfo(menuItemId, drinkSizeAsString, menuItemCustomizations)
                );
            } else {
                Log.e(TAG, "menuItem NOT instanceof Drink");
            }
        }

        return menuItemInfos;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onPostButtonClicked() {
        Log.i(TAG, "onPostButtonClicked()");

        // TODO:
        Order order = new Order(
                LocalDateTime.now(),
                convertToListOfMenuItemInfo(
                        viewportFragment.getMenuItems()
                )

        );

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
        String orderAsJsonString = gson.toJson(order);

        JsonObjectRequest jsonObjectRequest = null;
        try {
            jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    URL_ORDER,
                    new JSONObject(orderAsJsonString),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Order responsePayload = gson.fromJson(response.toString(), Order.class);

                            LocalDateTime createdOnPayload = responsePayload.getCreatedOn();
                            Log.e(TAG, createdOnPayload.toString());

                            Log.i(TAG, "onResponse(JSONObject) clearing local menuItems from viewportFragment.");
                            viewportFragment.clearMenuItems();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error
                            Log.e(TAG, "onErrorResponse(VolleyError)" + error);
                        }
                    });
        } catch (JSONException e) {
            e.printStackTrace();
        }

        requestQueue.add(jsonObjectRequest);
    }
}