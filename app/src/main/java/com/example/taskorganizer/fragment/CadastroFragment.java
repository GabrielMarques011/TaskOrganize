package com.example.taskorganizer.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.FragmentCadastroBinding;

public class CadastroFragment extends Fragment {

    private FragmentCadastroBinding bindingCadastro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    bindingCadastro = FragmentCadastroBinding.inflate(getLayoutInflater(), container, false);

        return bindingCadastro.getRoot();
    }
}