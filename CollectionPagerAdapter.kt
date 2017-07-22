package myapp.abrahamjohngomez.com.interviewchallenges

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by ryuhyoko on 6/26/2017.
 */
class CollectionPagerAdapter(fm: FragmentManager, fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

    private val frags = fragments

    var last: Int = 0
        set(last) {
            field = last
            notifyDataSetChanged()
        }
    override fun getItem(position:Int) : Fragment{
        return frags[position]
    }
    override public  fun getCount() : Int {
        return frags.size
    }
    fun addFragment(fragment: Fragment) {

    }

}