package com.example.examplewithkotlin

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.examplewithkotlin.fragments.OneFragment
import com.example.examplewithkotlin.fragments.ThreeFragment
import com.example.examplewithkotlin.fragments.TwoFragment
import com.example.examplewithkotlin.views.CustomA
import com.example.examplewithkotlin.views.CustomB
import com.example.examplewithkotlin.views.CustomC
import kotlinx.android.synthetic.main.activity_main.*

class FragmentAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    var list = listOf<Fragment>()

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "One"
            1 -> "Two"
            2 -> "Three"
            else -> "Unknown"
        }
    }
}

class CustomPagerAdapter: PagerAdapter() {
    var views = listOf<View>()
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = views.get(position)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun setItems(list: List<View>) {
        views = list
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "AAA"
            1 -> "BBB"
            2 -> "CCC"
            3 -> "DDD"
            else -> "Unknown"
        }
    }

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setFragments()
        init()
    }

    private fun init() {
        val views = listOf(
            CustomA(this), CustomB(this),
            CustomC(this), CustomC(this))
        val customPagerAdapter = CustomPagerAdapter()
        customPagerAdapter.setItems(views)
        viewPager.adapter = customPagerAdapter
    }

    private fun initViewPagerUsingFragment() {
        val fragmentAdapter = FragmentAdapter(supportFragmentManager, 1)
        fragmentAdapter.list = listOf(OneFragment(), TwoFragment(), ThreeFragment())
        val pager = findViewById(R.id.viewPager) as ViewPager
        pager.adapter = fragmentAdapter
    }

//    private fun setFragments() {
        /*
        val listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
         */

        /*
        val customViewFragment = CustomViewFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, customViewFragment)
        transaction.commit()
        */
//    }

//    fun goDetail(data: PhoneModel) {
//        val bundle = Bundle()
//        bundle.putString("name", data.name)
//        bundle.putString("phone", data.phone)
//        bundle.putInt("age", data.age)
//
//        val detailFragment = DetailFragment()
//        detailFragment.arguments = bundle
//
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.frameLayout, detailFragment)
//        transaction.addToBackStack("detail")
//        transaction.commit()
//    }
//
//    fun goBack() {
//       onBackPressed()
//    }
}