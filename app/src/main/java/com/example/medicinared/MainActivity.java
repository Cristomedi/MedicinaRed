package com.example.medicinared;


import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.storage.StorageReference;


//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.Manifest.permission.CAMERA;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {

    private ImageView img2;

    private VideoView video;

    private TextView mTextMessage;
    private ListView List1;
    private ImageView Img;
    int[] Imagenes = {R.mipmap.catalinaugarte, R.mipmap.cmedina, R.mipmap.gsternal, R.mipmap.joaquinerrazuriz, R.mipmap.marcelofernandez, R.mipmap.marcoalvarez, R.mipmap.paulinajaque, R.mipmap.pmedina, R.mipmap.thabatta, R.mipmap.vanessaaracena};
    String[] Nombres = {"Catalina Ugarte", "Cristóbal Medina", " Georg Sternal", "Joaquin Errazuriz", "Marcelo Fernandez", "Marco Alvarez", "Paulina Jaque", "Pablo Medina", "Thabatta Echaiz", "Vanessa Aracena"};
    TextView Txt1;
    TextView Txt11;
    TextView Txt12;
    TextView Txt13;
    TextView Txt14;


    TextView Txt15;
    TextView Txt16;
    TextView Txt17;

    TextView Txt18;
    TextView Txt19;


    String[] detalles = new String[]{"Trauma de la Infancia", "Trauma de la Mujer", " Peleas Con Papas", "Problema com la Abuela", "Bajando la Ansiedad", "Superación de Traumas", "Superando Peleas", "Aprendiendo a Relacionarse", "Terapia con Mujeres", "Temas Sexuales"};
    String[] Enfermedad = {"Depresión", "TOC", " Sociopatia", "Esquizofrenia", "Depresión", "Stress", "Depresión", "TOC", "Sana", "Depresión"};
    ListView listview;


    ImageView Img1;

    ImageView Img2;

    ImageView Img3;

    ImageView Img4;

    ImageView Img5;

    ImageView img4;

    ImageView img5;

    ImageView img6;

    Button btn;


    Calendar c;
    DatePickerDialog dpd;
    Calendar c1;
    DatePickerDialog dpd1;
    String Name;
    // TextView Txt14;
    AutoCompleteTextView Edi;
    EditText Edi2;
    private String archivoSalida = null;
    //private String CARPETA_PRINCIPAL = "misImagenesApp/";
    private String CARPETA_IMAGEN = "imagenes";
    //private String CARPETA_ARCHIVOS = "Agenda/";

    // private String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGEN;

    private String CARPETA_PRINCIPAL = "Med/misImagenesApp/";
    private String CARPETA_ARCHIVOS = "Med/Agenda/";
    private String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGEN;

    private String path;

    private final int PHOTO_CODE = 100;

    private static final int COD_SELECCIONA = 10;
    private static final int COD_FOTO = 20;
    File fileImagen;
    Bitmap bitmap;


    //int [] Imagenes={R.mipmap.catalinaugarte, R.mipmap.cmedina,R.mipmap.gsternal,R.mipmap.joaquinerrazuriz,R.mipmap.marcelofernandez,R.mipmap.marcoalvarez,R.mipmap.paulinajaque,R.mipmap.pmedina,R.mipmap.thabatta,R.mipmap.vanessaaracena};
    String[] Sexo = {"Femenino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Femenino", "Masculino", "Femenino", "Femenino", "Femenino", "Femenino", "Femenino", "Femenino"};

    String Agenda[][] = new String[1000][1000]; //Cuaidado con la capacidad de la matriz
    String Adapter[][] = new String[1000][1000]; //Cuaidado con la capacidad de la matriz
    String Persona[][] = new String[1000][24]; //Cuaidado con la capacidad de la matriz
    String Lugar[][] = new String[1000][4]; //Cuaidado con la capacidad de la matriz
    String Sesiones[][] = new String[1000][12]; //Cuaidado con la capacidad de la matriz
    String Sesionesx[][] = new String[1000][12]; //Cuaidado con la capacidad de la matriz

    String Sesiones1[][] = new String[1000][10]; //Cuaidado con la capacidad de la matriz
    String Sesiones2[][] = new String[1000][10]; //Cuaidado con la capacidad de la matriz|

    //String Sesiones

    String LineaAgenda[][] = new String[1][10];


    String name;
    String nombrecito;
    String fechita;
    int sf;
    String julito;
    int djulito;


    private TextToSpeech textToSpeech;


    int cadp;
    int cadp2;
    int caper;
    int calu;
    int julio;
    int def;


    int gro;
    String lugarchico;
    String fecha[] = new String[1];

    //int julito;

    String textito;

    int PersonaAux[] = new int[1000]; //Cuaidado con la capacidad de la matriz

    String Copio[] = new String[2];

    String Config[][] = new String[1000][3];

    int caconfig;

    GridView gridview;

    String[] values = {"Catalina Ugarte", "Cristóbal Medina", " Georg Sternal", "Joaquin Errazuriz", "Marcelo Fernandez", "Marco Alvarez"};

    int[] images = {R.mipmap.catalinaugarte, R.mipmap.cmedina, R.mipmap.gsternal, R.mipmap.joaquinerrazuriz, R.mipmap.marcelofernandez, R.mipmap.marcoalvarez};

     private StorageReference mStorageRef;

    FirebaseAuth mAuth;

    DatabaseReference mdatabase;

    // StorageReference storageref;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);


                    Intent intent = new Intent(MainActivity.this, actividades.class);

                    intent.putExtra("IND", Integer.toString(0));


                    startActivity(intent);

                    return true;
                //return true;
                case R.id.navigation_dashboard:


                    Intent intent2 = new Intent(MainActivity.this, atenciones.class);


                    startActivity(intent2);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);


                    Intent intent3 = new Intent(MainActivity.this, actividades.class);

                    intent3.putExtra("IND", Integer.toString(1));


                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        img2 = (ImageView) findViewById(R.id.imageView2);

        video = (VideoView) findViewById(R.id.videoView);

        Txt11 = (TextView) findViewById(R.id.textView);
        Txt12 = (TextView) findViewById(R.id.textView2);
        Txt13 = (TextView) findViewById(R.id.textView3);
        Txt14 = (TextView) findViewById(R.id.textView4);
        Txt15 = (TextView) findViewById(R.id.textView5);
        Txt16 = (TextView) findViewById(R.id.textView6);

        btn = (Button) findViewById(R.id.button);





        Txt12.setText("Georg Sternal");
        Txt11.setText("Soltero");
        Txt13.setText("Edad:33");
        Txt15.setText("Perfil");
        Txt16.setText("Actodidacta , Musico, Matematico, Artista");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(MainActivity.this, busquedaespecialidades.class);

                startActivity(intent1);


            }
        });


        if (validaPermisos()) {

            //Toast.makeText(getApplicationContext(), " Sternal", Toast.LENGTH_SHORT).show();
            //silos permisos estan activo haga algo

        } else {


        }

        gridview = (GridView) findViewById(R.id.grid1);

        GridAdapter gridAdapter = new GridAdapter(this, values, images);

        gridview.setAdapter(gridAdapter);

        // Variables Incializadas

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), Integer.toString(i), Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(MainActivity.this, doctor2.class);

                intent1.putExtra("POSICION", Integer.toString(i));

                startActivity(intent1);


            }
        });


        //mStorageRef = FirebaseStorage.getInstance().getReference();

        /////Subir al Microsoft One Drive Tambien

           mAuth = FirebaseAuth.getInstance();

         FirebaseUser b = mAuth.getCurrentUser();


        if (b != null) {
          Toast.makeText(getApplicationContext(), "Accedio al Usuario", Toast.LENGTH_SHORT).show();
        String id = b.getUid();
         String token = b.getProviderId();
         String mail = b.getEmail();

         Toast.makeText(getApplicationContext(), id + " " + token, Toast.LENGTH_SHORT).show();


        } else {

          Toast.makeText(getApplicationContext(), "No accedio al Usuario", Toast.LENGTH_SHORT).show();

         }





      //  FirebaseFirestore db = FirebaseFirestore.getInstance();


        //bajarimagen();

        //bajarvideo();


    }

    private boolean validaPermisos() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {

            return true;

        } else {

            if ((checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED)) {

                return true;

            } else {

                //if((shouldShowRequestPermissionRationale(CAMERA)) || (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)){

                cargarDialogoRecomendacion();

            }

        }
        //return true;

        //} //else{


        //requestPermissions(new String[](WRITE_EXTERNAL_STORAGE,CAMERA),100);
        //ActivityCompat.requestPermissions(MainActivity.this,new String[]{(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) ,(android.Manifest.permission.CAMERA)},100);

        //}


        return false;

    }


    private void cargarDialogoRecomendacion() {

        android.app.AlertDialog.Builder dialogo = new android.app.AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CALL_PHONE},REQUEST_CALL);
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), (android.Manifest.permission.CAMERA), (Manifest.permission.SEND_SMS), (Manifest.permission.RECORD_AUDIO)}, 100);
                // ActivityCompat.requestPermissions(MainActivity.this,new String[],100);

                // if((checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(CALL_PHONE)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(SEND_SMS)==PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(INTERNET)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(VIBRATE)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(RECORD_AUDIO)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(READ_SMS)==PackageManager.PERMISSION_GRANTED)&& (checkSelfPermission(RECEIVE_SMS)==PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(SEND_SMS)==PackageManager.PERMISSION_GRANTED)
            }
        });

        dialogo.show();

    }

}


  //  private void bajarimagen() {

        //StorageReference storageRefx = FirebaseStorage.getInstance().getReference();


        //storageRefx.child("uploads/images/julio").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
          //  @Override
          //  public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
            //    Toast.makeText(getApplicationContext(), "medina", Toast.LENGTH_SHORT).show();


                //// Aca

              //  img2.setImageURI(uri);


           // }
        //}).addOnFailureListener(new OnFailureListener() {
          //  @Override
           // public void onFailure(@NonNull Exception exception) {
             //   Toast.makeText(getApplicationContext(), "nomedina", Toast.LENGTH_SHORT).show();


                // Handle any errors
           // }
        //});


       // storageRefx.child("uploads/images/julio").getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
         //   @Override
           // public void onSuccess(byte[] bytes) {

             //   Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
               // img2.setImageBitmap(bitmap);

       //     }
     //   });


   // }

///}



    //private void bajartextor() {


      //  mdatabase.child("users").addValueEventListener(new ValueEventListener() {
        //    @Override
          //  public void onDataChange(@NonNull DataSnapshot datasnapshot) {


            //    for (DataSnapshot snapshot : datasnapshot.getChildren()) {


              //      MapsPojo mapsPojo = snapshot.getValue(MapsPojo.class);


                ///    double latitud = mapsPojo.getlatitud();
                ///    double longitud = mapsPojo.getlongitud();


                   // Edi1.setText(Double.toString(latitud));

                //    Edi2.setText(Double.toString(longitud));


                    // Lee el ultimo

               /// }


           /// }

           /// @Override
            ///public void onCancelled(@NonNull DatabaseError error) {


   ///         }
      //  });


    //}


   /// private void bajarvideo() {

      ///  StorageReference storageRefx = FirebaseStorage.getInstance().getReference();


       /// storageRefx.child("uploads/videos/v1").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
          ///  @Override
          //  public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
            ///    Toast.makeText(getApplicationContext(), "medina", Toast.LENGTH_SHORT).show();


                //// Aca

                //  video.setMediaController(new MediaController(getApplicationContext()));

              ///  video.setVideoURI(uri);


                //Video.setVideoURI(uri);

               /// video.requestFocus();

               /// video.start();


           /// }
       /// }).addOnFailureListener(new OnFailureListener() {
          //  @Override
           /// public void onFailure(@NonNull Exception exception) {
              ///  Toast.makeText(getApplicationContext(), "nomedina", Toast.LENGTH_SHORT).show();


                // Handle any errors
           // }
        //});


        //  storageRefx.child("uploads/images/julio").getBytes(1024* 1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
        //    @Override
        //  public void onSuccess(byte[] bytes) {

        //    Bitmap bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        //  img2.setImageBitmap(bitmap);

        // }
        // });


    //}


    // public void writeNewUser(String userId, String name, String email) {
    //   User user = new User(name, email);

    // mdatabase.child("users").child(userId).setValue(user);
    // }


    // @IgnoreExtraProperties
    //public class User {

    //  public String username;
    //  public String email;

    // public User() {
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
    // }

    // public User(String username, String email) {
    //   this.username = username;
    // this.email = email;
    //}

    //}



//}
















