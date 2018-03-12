package com.hero.infobeer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.android.volley.Response
import com.hero.infobeer.adapters.ItemAdapter
import com.hero.infobeer.models.Brewery
import com.hero.infobeer.models.ItemView
import com.hero.infobeer.network.GsonRequest
import com.hero.infobeer.network.RestClient
import com.hero.infobeer.presenters.ItemPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_template1.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(wx_toolbar)
        wx_rw_beers.layoutManager = LinearLayoutManager(this)
        wx_rw_beers.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        setupSearch(menu!!)
        return true
    }

    fun setupSearch(menu: Menu) {
        var itemSearch : MenuItem = menu.findItem(R.id.action_search)
        var searchView : SearchView = itemSearch.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                RestClient.getInstance(this@MainActivity).addToRequestQueue(GsonRequest<Brewery>(
                        "http://prost.herokuapp.com/api/v1/brewery/" + query.toLowerCase(),
                        Brewery::class.java,
                        null,
                        Response.Listener { response ->
                            var presenter = ItemPresenter()

                            response.beers.forEach {
                                beer -> presenter.add(ItemView(beer))
                            }

                            var adapter = ItemAdapter()

                            adapter.presenter = presenter
                            this@MainActivity.wx_rw_beers.adapter = adapter
                        },
                        Response.ErrorListener { error -> Log.w("Error", error.toString()) }
                ))

                return true
            }
        })
    }
}
