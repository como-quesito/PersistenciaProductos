# Peeristencia de Productos
Este pequeño tutorial muestra cómo utilizar archivos seralizados para generar persistencia en Android usando los métodos
* **openFileOutput("nombre", MODE_PRIVATE)** usado para generar un archivo, regresa un FileOutputStream
* **getFileStreamPath("nombre")** para ver si un archivo existe, regresa un File
* **openFileInput("nombre")** para abrir un archivo que ya existe, regresa un FileInputStream
* 
Todos estos métodos estan dentro de la clase **Context**,  http://developer.android.com/reference/android/content/Context.html .

Esta clase es una clase abstracta que es implementada por el sistema Android en el cual se esta ejecutando tu aplciación. Y sirve para que en ese sistema android puedas acceder a clases y recursos específicos dentro de tu sistema Android.


