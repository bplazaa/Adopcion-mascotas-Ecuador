package com.example.adopcionmascotas.ui.contactanos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.adopcionmascotas.R
import com.squareup.picasso.Picasso

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

        val imageContactos = root.findViewById<ImageView>(R.id.imageViewContactanos)
        Picasso.get().load("https://media.metrolatam.com/2020/06/10/perros1024x574-17bc3b2637843af290af3eda2cfbd2cb-1200x600.jpg").into(imageContactos)

//        val map:WebView = root.findViewById(R.id.webMap)
//        map.loadUrl("https://goo.gl/maps/z14bPZsv5z5CVHvj7")

        return root
    }
}