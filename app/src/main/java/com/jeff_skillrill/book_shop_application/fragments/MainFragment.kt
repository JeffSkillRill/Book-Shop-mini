package com.jeff_skillrill.book_shop_application.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.jeff_skillrill.book_shop_application.R
import com.jeff_skillrill.book_shop_application.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var drawerLayout: DrawerLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        loadFragment(HomeFragment())

        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.wishlist -> {
                    loadFragment(WishlistFragment())
                    true
                }
                R.id.purchased -> {
                    loadFragment(SavedFragment())
                    true
                }
                R.id.account -> {
                    loadFragment(AccountFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

        drawerLayout = binding.drawerLayout
        var navigationView = binding.navView

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        navigationView.setNavigationItemSelectedListener(this)

        var toggle = ActionBarDrawerToggle(
            requireActivity(), binding.drawerLayout, binding.toolbar, R.string.open_nav,
            R.string.close_nav
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }


        return binding.root
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment()).commit()

            R.id.nav_settings -> requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, AccountFragment()).commit()

            R.id.nav_saved -> requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SavedFragment()).commit()

            R.id.nav_logout -> Toast.makeText(requireContext(), "Logout!", Toast.LENGTH_SHORT)
                .show()
        }
        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}