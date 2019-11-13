package io.github.lettucech.navcompexamples.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import io.github.lettucech.navcompexamples.R
import io.github.lettucech.navcompexamples.viewmodel.MessageViewModel
import kotlinx.android.synthetic.main.fragment_content_b.*

class ContentBFragment : Fragment() {
    private val messageViewModel: MessageViewModel by navGraphViewModels(R.id.nav_graph_toolbar)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView_message.text = messageViewModel.message.value
    }
}