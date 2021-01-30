package com.example.adopcionmascotas.ui.noticias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.adopcionmascotas.R

class NoticiasFragment : Fragment() {

    private lateinit var noticiasViewModel: NoticiasViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        noticiasViewModel =
                ViewModelProviders.of(this).get(NoticiasViewModel::class.java)
        val root = inflater.inflate(R.layout.noticias, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        noticiasViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}