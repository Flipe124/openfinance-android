package com.example.openfinance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.openfinance.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar o layout da atividade usando o ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar a barra de ferramentas (toolbar) como a ActionBar
        setSupportActionBar(binding.appBarMain.toolbar);

        // Configurar um listener de clique para o botão de ação flutuante (fab)
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Obter referências para o DrawerLayout e NavigationView
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configurar o AppBarConfiguration com os destinos de navegação (IDs dos menus)
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();

        // Obter o NavController para a navegação
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Configurar a ActionBar para trabalhar com o NavController
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Configurar o NavigationView para trabalhar com o NavController
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar o menu; isso adiciona itens à ActionBar, se estiver presente.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Configurar o suporte para navegação "Up" (voltar)
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

//    public class MeuFragmento extends Fragment {
//
//        private Button meuBotao;
//        private NavController navController;

//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
//
//            meuBotao = view.findViewById(R.id.botao_nova_despesa);
//            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
//
//            meuBotao.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    navController.navigate(R.id.nav_home);
//                }
//            });
//
//            return view;
//        }
//    }
