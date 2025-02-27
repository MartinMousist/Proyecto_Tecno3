package com.example.proyecto_tecno

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_tecno.adapter.EventosAdapter
import com.example.proyecto_tecno.databinding.ActivityPantallaHomeBinding

class pantalla_home : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaHomeBinding
    private var eventosList: MutableList<Evento> = EventosProvider.EventosList.toMutableList()
    private lateinit var adapter: EventosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        //initRecyclerView()
        //setupSearch()
        replaceFragment(Home())
       binding.bottomNavigation.setOnItemSelectedListener {
           when(it.itemId){
               R.id.home -> replaceFragment(Home())
               R.id.profile -> replaceFragment(Profile())
               R.id.favorites -> replaceFragment(Favorites())

               else ->{

               }


           }
           true

       }



       /* adapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("evento", it)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerEventos
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EventosAdapter(eventosList)
        recyclerView.adapter = adapter
    }

    private fun setupSearch() {
        binding.buscador.addTextChangedListener { userFilter ->
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
*/ }
    override fun onBackPressed() {

    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}

