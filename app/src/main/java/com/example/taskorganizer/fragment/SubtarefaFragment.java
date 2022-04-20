package com.example.taskorganizer.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.FragmentSubtarefaBinding;

public class SubtarefaFragment extends Fragment {

    private FragmentSubtarefaBinding bindingSubtarefa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindingSubtarefa = FragmentSubtarefaBinding.inflate(getLayoutInflater(), container, false);

        return bindingSubtarefa.getRoot();
    }
}