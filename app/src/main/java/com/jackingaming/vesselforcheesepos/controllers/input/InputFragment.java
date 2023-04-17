package com.jackingaming.vesselforcheesepos.controllers.input;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jackingaming.vesselforcheesepos.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        buttonFoods = view.findViewById(R.id.button_foods);
        buttonDrinks = view.findViewById(R.id.button_drinks);
        buttonSides = view.findViewById(R.id.button_sides);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment initialFragmentForInputPane = InputPaneFragment.newInstance(
                InputPaneFragment.Type.FOODS, 4, 3);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fcv_input_pane_full_screen, initialFragmentForInputPane)
                .commitNow();


        buttonFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragmentForInputPane = InputPaneFragment.newInstance(
                        InputPaneFragment.Type.FOODS, 4, 3);
                replaceFragmentInInputPaneWith(newFragmentForInputPane);
            }
        });
        buttonDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragmentForInputPane = InputPaneFragment.newInstance(
                        InputPaneFragment.Type.DRINKS_HOME, 5, 5);
                replaceFragmentInInputPaneWith(newFragmentForInputPane);
            }
        });
        buttonSides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragmentForInputPane = InputPaneFragment.newInstance(
                        InputPaneFragment.Type.SIDES, 2, 3);
                replaceFragmentInInputPaneWith(newFragmentForInputPane);
            }
        });
    }

    private void replaceFragmentInInputPaneWith(Fragment newFragment) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fcv_input_pane_full_screen, newFragment)
                .commitNow();
    }
}