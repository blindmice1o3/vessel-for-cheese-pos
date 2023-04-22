package com.jackingaming.vesselforcheesepos.controllers.input._top_level;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.drinks.DrinksHomeInputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.foods.FoodsInputPaneFragment;
import com.jackingaming.vesselforcheesepos.controllers.input.second_level.sides.SidesInputPaneFragment;

public class InputFragment extends Fragment {
    public static final String TAG = InputFragment.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button buttonFoods, buttonDrinks, buttonSides;

    public InputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InputFragment newInstance(String param1, String param2) {
        Log.i(TAG, "newInstance()");
        InputFragment fragment = new InputFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            } else {
                Log.i(TAG, "getArguments() == null");
            }
        } else {
            Log.i(TAG, "savedInstanceState != null");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        buttonFoods = view.findViewById(R.id.button_foods);
        buttonDrinks = view.findViewById(R.id.button_drinks);
        buttonSides = view.findViewById(R.id.button_sides);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated()");
        if (savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState == null");

            Fragment fragmentFoods = FoodsInputPaneFragment.newInstance(
                    FoodsInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                    FoodsInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
            replaceFragmentInInputPaneWith(fragmentFoods);

            buttonFoods.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentFoods = FoodsInputPaneFragment.newInstance(
                            FoodsInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                            FoodsInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentFoods);
                }
            });
            buttonDrinks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentDrinksHome = DrinksHomeInputPaneFragment.newInstance(
                            DrinksHomeInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                            DrinksHomeInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentDrinksHome);
                }
            });
            buttonSides.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentSides = SidesInputPaneFragment.newInstance(
                            SidesInputPaneFragment.NUM_OF_ROWS_DEFAULT,
                            SidesInputPaneFragment.NUM_OF_COLUMNS_DEFAULT);
                    replaceFragmentInInputPaneWith(fragmentSides);
                }
            });
        } else {
            Log.i(TAG, "savedInstanceState != null");
        }
    }

    private void replaceFragmentInInputPaneWith(Fragment newFragment) {
        Log.i(TAG, "replaceFragmentInInputPaneWith()");
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fcv_input_pane_full_screen, newFragment)
                .commitNow();
    }
}