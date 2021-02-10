package com.fj.nicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;

/**
 * Crea otra de las Activity principales
 * @author Fran
 * @see MainActivity
 */
public class MainActivity2 extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        ExpandableCardView card = findViewById(R.id.profile);

        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity2.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


        //LISTENER BOTON CENTRAL
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        //LISTENER ICONO DE LA IZQ
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //LISTENERS ICONOS DERECHA
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_bookmark:
                        Toast.makeText(MainActivity2.this, "Saves clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(MainActivity2.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_share:
                        Toast.makeText(MainActivity2.this, "Share clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override

        public void onRefresh() {
            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();
            //   opción SNACKBAR

            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.consLayout);
            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
            swipeLayout.setRefreshing(false);
        }
    };

}