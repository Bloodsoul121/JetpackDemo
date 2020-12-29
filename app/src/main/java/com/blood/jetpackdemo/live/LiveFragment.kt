package com.blood.jetpackdemo.live

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blood.jetpackdemo.R


/*
 *  @项目名：  JetpackDemo 
 *  @包名：    com.blood.jetpackdemo.live
 *  @文件名:   LiveFragment
 *  @创建者:   bloodsoul
 *  @创建时间:  2020/12/26 11:10
 *  @描述：    TODO
 */
class LiveFragment : Fragment() {

    private var rootView: View? = null
    private lateinit var textView: TextView

    private val handler: Handler = Handler(Looper.getMainLooper())

    init {
        println("$this init")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("$this onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$this onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.layout_fragment_live, container, false)
        }
        println("$this onCreateView $rootView")
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("$this onActivityCreated")
        super.onActivityCreated(savedInstanceState)

        textView = rootView!!.findViewById(R.id.text)
        println("$this onActivityCreated $textView")

        ViewModelProvider(this).get(LiveViewModel::class.java).data.observe(viewLifecycleOwner, Observer {
            println("$this data $it")
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("$this onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$this onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        println("$this onDetach")

        handler.postDelayed({
            textView.text = "123456\n789456"
        }, 2000)
    }

    /**
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e)} init
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onAttach
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onCreate
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onCreateView
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment}. onActivityCreated
    I/System.out: com.blood.jetpackdemo.live.LiveViewModel@fe42ec8 init
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onActivityCreated

    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onDestroyView
    I/System.out: com.blood.jetpackdemo.live.LiveViewModel@fe42ec8 onCleared
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onDestroy
    I/System.out: LiveFragment{2a78f62} (33b45635-558b-43db-b90f-d30d7d47846e) id=0x7f0800a6 tag_live_fragment} onDetach

    I/System.out: LiveFragment{2a78f62} (efe2a2b6-5a28-436c-8f4b-f86578a797fe) id=0x7f0800a6 tag_live_fragment} onAttach
    I/System.out: LiveFragment{2a78f62} (efe2a2b6-5a28-436c-8f4b-f86578a797fe) id=0x7f0800a6 tag_live_fragment} onCreate
    I/System.out: LiveFragment{2a78f62} (efe2a2b6-5a28-436c-8f4b-f86578a797fe) id=0x7f0800a6 tag_live_fragment} onCreateView
    I/System.out: LiveFragment{2a78f62} (efe2a2b6-5a28-436c-8f4b-f86578a797fe) id=0x7f0800a6 tag_live_fragment}. onActivityCreated
    I/System.out: com.blood.jetpackdemo.live.LiveViewModel@77bc99c init
    I/System.out: LiveFragment{2a78f62} (efe2a2b6-5a28-436c-8f4b-f86578a797fe) id=0x7f0800a6 tag_live_fragment} onActivityCreated
     */

}