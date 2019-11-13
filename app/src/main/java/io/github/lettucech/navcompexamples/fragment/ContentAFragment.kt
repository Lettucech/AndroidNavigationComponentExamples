package io.github.lettucech.navcompexamples.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import io.github.lettucech.navcompexamples.R
import io.github.lettucech.navcompexamples.viewmodel.MessageViewModel
import io.github.lettucech.navcompexamples.viewmodel.ToolbarViewModel
import kotlinx.android.synthetic.main.fragment_content_a.*
import kotlinx.android.synthetic.main.fragment_content_a.view.*

class ContentAFragment : Fragment() {

    private val toolbarViewModel: ToolbarViewModel by navGraphViewModels(R.id.nav_graph_toolbar)
    private val messageViewModel: MessageViewModel by navGraphViewModels(R.id.nav_graph_toolbar)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_set_title.btn_set_title.setOnClickListener {
            toolbarViewModel.toolbarTitle.value = editText_title.text.toString()
        }

        btn_next_page.btn_next_page.setOnClickListener {
            messageViewModel.message.value = editText_message.text.toString()
            findNavController().navigate(R.id.action_contentAFragment_to_contentBFragment)
        }
    }
}