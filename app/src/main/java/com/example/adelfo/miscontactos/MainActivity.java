package com.example.adelfo.miscontactos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adelfo.miscontactos.adapter.PageAdapter;
import com.example.adelfo.miscontactos.fragment.FragmentPerfil;
import com.example.adelfo.miscontactos.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Activity fa;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
public static Context mainActivityContext;
    SharedPreferences miPrefereciaCompartida0 = null;
    public static String usuario_nombre = "perritocheno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityContext = this;
        fa = this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setLogo(R.drawable.dog_footprint_filled_50);
    }


    @Override
    protected void onStart() {
        super.onStart();
        miPrefereciaCompartida0= MainActivity.mainActivityContext.getSharedPreferences("UsuariosPetagram", Context.MODE_PRIVATE);
        usuario_nombre = miPrefereciaCompartida0.getString("usuario_nombre", "perritocheno");
        setUpViewPager();
    }

    public   ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragment());
        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.circled_user_male_filled_50);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mContacto) {
            Intent intent = new Intent(this, ContactarActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.mAcercaDe){
            Intent intent = new Intent(this, AcercaDeActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.mConfigurarCuenta) {
            Intent intent = new Intent(this, ConfigurarCuenta.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void guardarUsuarioPetagram(View v){
        EditText etAgregarUsuario = (EditText) findViewById(R.id.etAgregarUsuario);
        String usuario = etAgregarUsuario.getText().toString();

        SharedPreferences miPrefereciaCompartida = getSharedPreferences("UsuariosPetagram", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = miPrefereciaCompartida.edit();
        editor.putString(usuario, usuario);
        editor.commit();

        Toast.makeText(MainActivity.this, "Se ha guardado el usuario "+usuario+".", Toast.LENGTH_SHORT).show();
        etAgregarUsuario.setText("");
    }


}
