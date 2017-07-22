package myapp.abrahamjohngomez.com.interviewchallenges

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.qa_fragment.*

/**
 * Created by ryuhyoko on 6/26/2017.
 */
class Frag : Fragment() {
    private var viewPager:ViewPager? = null
    companion object {

        fun newInstance(question: String?, answer: String?): Frag {
            val f = Frag()
            val args = Bundle()
            args.putString("question", question)
            args.putString("answer", answer)
            f.arguments = args
            return f
        }
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        return super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args : Bundle = arguments
        val v = inflater?.inflate(R.layout.qa_fragment, container, false)
        val tvQuestion = v?.findViewById(R.id.tvQ) as TextView
        val tvAnswer = v?.findViewById(R.id.tvA) as TextView
        tvQuestion.text = args.getString("question")
        tvAnswer.text = args.getString("answer")
        return v
    }
}