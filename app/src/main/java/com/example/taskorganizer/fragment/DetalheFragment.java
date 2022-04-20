package com.example.taskorganizer.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.FragmentDetalheBinding;

public class DetalheFragment extends Fragment {

    private FragmentDetalheBinding bindingDetalhe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindingDetalhe = FragmentDetalheBinding.inflate(getLayoutInflater(), container, false);

        return bindingDetalhe.getRoot();
    }
}