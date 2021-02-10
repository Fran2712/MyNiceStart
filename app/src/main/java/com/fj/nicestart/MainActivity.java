package com.fj.nicestart;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

/**
 * Crea la Acrivity
 * principal de la aplicación
 * @author Fran
 * @see MainActivity2
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bot = findViewById(R.id.boton1);
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        ImageView vew = findViewById(R.id.profilePC);
        Glide.with(this)
                .load(R.drawable.descarga)
                .centerCrop()
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(vew);
        //INICIAR MENU CONTEXT
        ImageView mycontext = findViewById(R.id.profilePC);
        registerForContextMenu(mycontext);
    }

    /**         MENU CONTEXT           */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    //    creamos una lista de eventos para los items del menus contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "going CONTEXT CAMERA", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "going CONTEXT SETTINGS", Toast.LENGTH_LONG);
                toast2.show();
                Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }

       /**         MENU APPBAR           */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    //    creamos una lista de eventos para los items del menu del AppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "going Settings", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.camera) {
            //Intent intent = new Intent(MainActivity.this, MainActivity.class);
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

    /**        Swipe up Reload                    */



    /** DIALOGO MODAL */
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida

         builder.setTitle("Achtung!");
         builder.setMessage("Where do you go?");
         builder.setIcon(R.drawable.ic_action_name);
        // un XML a medida para el diálogo
        //builder.setView(getLayoutInflater().inflate(R.layout.asd, null));
        // add the buttons
        builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Toast.makeText(MainActivity.this, "Glidee", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Toast.makeText(MainActivity.this, "chate", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Toast.makeText(MainActivity.this, "Glidee", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}