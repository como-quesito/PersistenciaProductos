package tesis.gera.com.persistenciaproductos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            PersistenciaProducto per = new PersistenciaProducto();
            per.guardarProducto(new Producto("gansito", 45f, 1));
            Toast.makeText(this,"Guardado con exito",Toast.LENGTH_LONG).show();

           int tama= per.leerTodos().size();
            Toast.makeText(this,"tamano:"+tama,Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    public class PersistenciaProducto implements Serializable {

        public ArrayList<Producto> leerTodos() throws Exception{
            ArrayList<Producto> productos=new ArrayList<Producto>();
         FileInputStream file= openFileInput("productos");
            ObjectInputStream ois=new ObjectInputStream(file);
           productos= (ArrayList<Producto>) ois.readObject();
                return productos;

        }

        public void guardarProducto(Producto p)throws Exception{
            ArrayList<Producto> productos=new ArrayList<Producto>();
            File file=  getFileStreamPath("productos");
            if(file.exists()) {
                productos = leerTodos();
                    }
            FileOutputStream fos= openFileOutput("productos",MODE_PRIVATE);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            productos.add(p);
            oos.writeObject(productos);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
