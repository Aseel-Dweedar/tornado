package com.example.tornado;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeshFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeshFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "dishName";
    private static final String ARG_PARAM2 = "price";
    private static final String ARG_PARAM3 = "ingredients";

    // TODO: Rename and change types of parameters
    private String mDishName;
    private String mPrice;
    private String mIngredients;

    public DeshFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mDishName Parameter 1.
     * @param mPrice Parameter 2.
     * @param mIngredients Parameter 2.
     * @return A new instance of fragment DeshFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeshFragment newInstance(String mDishName, String mPrice, String mIngredients) {
        DeshFragment fragment = new DeshFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mDishName);
        args.putString(ARG_PARAM2, mPrice);
        args.putString(ARG_PARAM3, mIngredients);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDishName = getArguments().getString(ARG_PARAM1);
            mPrice = getArguments().getString(ARG_PARAM2);
            mIngredients = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desh, container, false);
    }
}