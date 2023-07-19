package com.exequielvr.myappsprint

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.exequielvr.myappsprint.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var mBinding: FragmentSecondBinding
    private val mViewModel: ItemsViewModel by activityViewModels()

    // va almacenar el id del curso
    private var itemId: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->

            itemId = bundle.getString("itemId")
            Log.d("Item id", itemId.toString())
        }

        itemId?.let { id ->
            mViewModel.getItemDetailByIDFromInternet(id)
        }

        mViewModel.getItemDetail().observe(viewLifecycleOwner, Observer {
            Log.d("Item id:", itemId.toString())
            var id = it.id
            var name = it.nombre

            Glide.with(mBinding.ivLogo).load(it.imagenLink).into(mBinding.ivLogo)
            mBinding.tvnombre.text = it.nombre
            mBinding.tvmarca.text = it.marca
            mBinding.tventrega.text = if (it.entrega) "Cuenta con despacho" else "Sin despacho"
            mBinding.tvprecio.text = "$" + it.precio.toString()

            mBinding.btMail.setOnClickListener {
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.data = Uri.parse("mailto")
                emailIntent.type = "text/plain"

                emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("Zapato.ventas@unica.cl"))
                emailIntent.putExtra(
                    Intent.EXTRA_SUBJECT,
                    "Consulta por Producto " + name + "id " + id
                )
                emailIntent.putExtra(
                    Intent.EXTRA_TEXT, "Hola\n" +
                            "Vi el producto " + name + " de código " + id + " y me gustaría que me contactaran a este\n" +
                            "correo o al siguiente número correo@test.com numero 987654321\n" +
                            " _________\n" +
                            "Quedo atento."
                )
                try {
                    startActivity(emailIntent)
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}