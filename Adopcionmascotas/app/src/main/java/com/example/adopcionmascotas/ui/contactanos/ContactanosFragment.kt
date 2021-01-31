package com.example.adopcionmascotas.ui.contactanos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.adopcionmascotas.R

class ContactanosFragment : Fragment() {

    private lateinit var contactanosViewModel: ContactanosViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactanosViewModel =
                ViewModelProviders.of(this).get(ContactanosViewModel::class.java)
        val root = inflater.inflate(R.layout.contactanos, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        contactanosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}