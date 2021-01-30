package com.example.adopcionmascotas.ui.dona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.adopcionmascotas.R

class DonaFragment : Fragment() {

    private lateinit var donaViewModel: DonaViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        donaViewModel =
                ViewModelProviders.of(this).get(DonaViewModel::class.java)
        val root = inflater.inflate(R.layout.dona, container, false)
        val textView: TextView = root.findViewById(R.id.text_dona)
        donaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}