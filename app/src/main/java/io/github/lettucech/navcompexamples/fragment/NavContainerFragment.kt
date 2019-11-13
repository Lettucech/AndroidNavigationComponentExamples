package io.github.lettucech.navcompexamples.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import io.github.lettucech.navcompexamples.R
import io.github.lettucech.navcompexamples.view.OnBackPressedListener
import io.github.lettucech.navcompexamples.viewmodel.ToolbarViewModel
import kotlinx.android.synthetic.main.fragment_nav_container.*

class NavContainerFragment : Fragment(), OnBackPressedListener {
    private lateinit var toolbarViewModel: ToolbarViewModel
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nav_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            if (it is AppCompatActivity) {
                it.setSupportActionBar(toolbar)
            }

            navController = Navigation.findNavController(it, R.id.nav_host_fragment).apply {
                setGraph(R.navigation.nav_graph_toolbar)

                addOnDestinationChangedListener { _, destination, _ ->
                    if (it is AppCompatActivity) {
                        it.supportActionBar?.setDisplayHomeAsUpEnabled(destination.id != R.id.contentAFragment)
                    }
                }

                val owner = getViewModelStoreOwner(R.id.nav_graph_toolbar)
                val factory = ViewModelProvider.NewInstanceFactory()

                toolbarViewModel =
                    ViewModelProvider(owner, factory).get(ToolbarViewModel::class.java)
                toolbarViewModel.toolbarTitle.observe(
                    this@NavContainerFragment,
                    Observer { title -> toolbar.title = title })
            }
        }
    }

    override fun onBackPressed() : Boolean {
        return navController?.popBackStack() ?: false
    }
}