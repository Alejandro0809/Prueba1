package com.example.prueba.ui.home

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prueba.databinding.FragmentHomeBinding
import com.google.zxing.integration.android.IntentIntegrator


class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Añadir función de escaner a un botón
        val bind = FragmentHomeBinding.inflate(layoutInflater)
        bind.camsc.setOnClickListener {
            escanear()
        }

        //Menú
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
             textView.text = it
         }*/

        return bind.root

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        //Código para los mensajes del Escaner
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        //Mandar mensajes de lectura
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(requireActivity(), "Lectura erronea", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(
                    requireActivity(),
                    "El articulo escaneado es: ${result.contents}",
                    Toast.LENGTH_SHORT


                ).show()

                //textView.setText(result.contents)
                binding.textHome.text = "${result.contents}"


            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)

        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun escanear() {

        val intentIntegrator = IntentIntegrator.forSupportFragment(this)
        //Tipos de código a escanear
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        intentIntegrator.setPrompt("Centra el código en el recuadro del escaner para obtener el artículo")
        //Sonido al hacer escaneo efetivo
        intentIntegrator.setBeepEnabled(true)
        intentIntegrator.initiateScan()
    }


}
