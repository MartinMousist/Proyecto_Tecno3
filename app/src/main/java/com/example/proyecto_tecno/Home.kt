package com.example.proyecto_tecno

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_tecno.adapter.EventosAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment(R.layout.fragment_home) {

    private lateinit var adapter: EventosAdapter
    private var eventosList: MutableList<Evento> = EventosProvider.EventosList.toMutableList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerEventos)
        val buscador: EditText = view.findViewById(R.id.buscador)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = EventosAdapter(eventosList)
        recyclerView.adapter = adapter

        buscador.addTextChangedListener { userFilter ->
            val filterText = userFilter.toString().trim()
            val eventosFiltered = if (filterText.isEmpty()) {
                eventosList
            } else {
                eventosList.filter { evento ->
                    evento.nombre.contains(filterText, ignoreCase = true)
                }
            }
            adapter.updateEventos(eventosFiltered)
        }

        adapter.onItemClick = {
            val intent = Intent(requireContext(), DetailedActivity::class.java)
            intent.putExtra("evento", it)
            startActivity(intent)
        }
    }
}

