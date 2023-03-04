package com.example.login_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
BASE ADAPTER//

--MAIN--
private lateinit var adaptadorDestino: AdaptadorDestino
        INSTANCIAS
arrayCiudades = ArrayList()
(pers)
adaptadorDestino = AdaptadorDestino(arrayCiudades,this)
binding.spinnerDestino.adapter = adaptadorDestino
(sencillo)
adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,R.array.paises,android.R.layout.simple_spinner_item)
adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

--CLASE--
 class AdaptadorDestino (var listaCiudades: ArrayList<Ciudad>, var contexto: Context) : BaseAdapter(){


    override fun getCount(): Int {
        return listaCiudades.size
    }

    override fun getItem(position: Int): Any {
        return listaCiudades.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // retona la vista (fila) ya rellena con los datos que estas
        // en una posición indicada -> p0
        // para poder rellenar la fila -> XML

        var vista: View =  LayoutInflater.from(contexto).inflate(R.layout.vista_spinnerorigen,parent,false)

        var nombre: TextView = vista.findViewById(R.id.texto_ciudad);
        var imagen: ImageView = vista.findViewById(R.id.imagen_ciudad);

        var ciudad = listaCiudades.get(position)
        nombre.text = ciudad.nombre
        imagen.setImageResource(ciudad.imagen)

        return vista;
    }
}


RECYCLER//

--MAIN--
private lateinit var adaptadorRecycler: AdaptadorRecycler

(onCreate)
adaptadorRecycler = AdaptadorRecycler(this,ArrayList<Viaje>())
        binding.recyclerViajes.adapter = adaptadorRecycler;
        binding.recyclerViajes.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL, false
        )


class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<Viaje>):
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView
        lateinit var boton_verDetalle: Button


        init {
            nombre = view.findViewById(R.id.texto_ciudad)
            imagen = view.findViewById(R.id.imagen_ciudad)
            boton_verDetalle = view.findViewById(R.id.boton_verDetalle)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.vista_recycler,parent,false)
        return MyHolder(view)
    }

    fun addViaje(viaje: Viaje){
        this.listaDatos.add(viaje)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var viaje: Viaje = listaDatos.get(position) as Viaje
        holder.imagen.setImageResource(viaje.ciudad.imagen)
        holder.nombre.setText(viaje.ciudad.nombre)

        holder.boton_verDetalle.setOnClickListener {
            Snackbar.make(
                holder.nombre,
                viaje.toString(),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnRecyclerCiudadSelected{
        fun onCiudadSelected(ciudad: Ciudad)
    }
}
// DIALOGO
class DialogoDatosUsuario : DialogFragment(){

    private lateinit var vista: View
    private lateinit var botonLogin: Button
    private lateinit var editNombre: EditText
    private lateinit var listener: OnDialogLogin

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogLogin
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.vista_usuario,null)
        builder.setView(vista)

        return builder.create();
    }

    fun acciones(){
        botonLogin.setOnClickListener{
            var usuario: Usuario = (Usuario(editNombre.text.toString()))
            listener.onDialogLogin(usuario)

            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }
    fun instancias(){
        botonLogin = vista.findViewById(R.id.botonLogin)
        editNombre = vista.findViewById(R.id.editText1)
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }

    interface OnDialogLogin{
        fun onDialogLogin(usuario: Usuario)
    }
}

//DIALOGO DETALLE COMPANION

class DialogoDetalle : DialogFragment() {

    private lateinit var vista: View

    private lateinit var nombre_label: TextView
    private lateinit var apellido_label: TextView
    private lateinit var correo_label: TextView
    private lateinit var edad_label: TextView
    private lateinit var puesto_label: TextView

    private lateinit var nombre: String
    private lateinit var apellido: String
    private lateinit var correo: String
    private lateinit var edad: String
    private lateinit var puesto: String

    companion object {
        // todo lo declarado aqui es accesible directamente
        // 1. TODO creo un método newInstance como parametro lo que va a recibir el dialogo
        //      devuelve el objeto del tipo que quiere construir

        fun newInstance(
            nombre: String,
            apellido: String,
            correo: String,
            edad: String,
            puesto: String
        ): DialogoDetalle {

            val dialogo = DialogoDetalle()
            // 2. TODO creo los argumentos con los datos que van en los parámetros
            // y se lo pongo al cuadro
            val bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putString("apellido", apellido)
            bundle.putString("correo", correo)
            bundle.putString("edad", edad)
            bundle.putString("puesto", puesto)
            dialogo.arguments = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 3. TODO recupero todos los argumentos que quiera utilizar
        this.nombre = this.arguments?.getString("nombre") ?: "Sin nombre"
        this.apellido = this.arguments?.getString("apellido") ?: "Sin apellido"
        this.correo = this.arguments?.getString("correo") ?: "Sin correo"
        this.edad = this.arguments?.getString("edad") ?: "Sin edad"
        this.puesto   = this.arguments?.getString("puesto") ?: "Sin puesto"
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_detalle, null)
        builder.setView(vista)

        return builder.create()
    }

    private fun instancias() {
        nombre_label = vista.findViewById(R.id.detalle_nombre)
        apellido_label = vista.findViewById(R.id.detalle_apellido)
        correo_label = vista.findViewById(R.id.detalle_correo)
        edad_label = vista.findViewById(R.id.detalle_edad)
        puesto_label = vista.findViewById(R.id.detalle_puesto)

        nombre_label.text = "Nombre: $nombre"
        apellido_label.text = "Apellido: $apellido"
        correo_label.text = "Correo: $correo"
        edad_label.text = "Edad: $edad"
        puesto_label.text = "Puesto: $puesto"
    }

    override fun onStart() {
        instancias()
        super.onStart()
    }
}

// MENU
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // AQUI LAS ACCIONES DE CADA OPCION DEL MENU
         when (item.itemId) {
            R.id.menu_add -> {
                DialogoAdd().show(supportFragmentManager, "")

            }
    }
*/