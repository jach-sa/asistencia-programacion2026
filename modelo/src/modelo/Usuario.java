/*
 * Clase Usuario
 * ---------------------------------------------------
 * Esta clase representa la entidad Usuario del sistema.
 * Aquí se almacenan todos los atributos relacionados
 * con cada usuario registrado en la base de datos.
 * 
 * Funciona como un POJO (Plain Old Java Object),
 * es decir, una clase simple usada para transportar datos.
 */

package modelo;

public class Usuario {

    // ══════════════════════════════════════════════════
    // ATRIBUTOS PRIVADOS DE LA CLASE
    // ══════════════════════════════════════════════════
    
    private int id;               // Identificador único del usuario
    private String nombre;        // Nombre del usuario
    private String apellido;      // Apellido del usuario
    private String email;         // Correo electrónico
    private String usuario;       // Nombre de usuario para iniciar sesión
    private String contrasena;    // Contraseña de acceso
    private byte[] foto;          // Foto almacenada como BLOB (arreglo de bytes)

    // ══════════════════════════════════════════════════
    // CONSTRUCTOR VACÍO
    // ══════════════════════════════════════════════════
    
    /**
     * Constructor sin parámetros.
     * Se utiliza cuando se crea el objeto vacío
     * y posteriormente se llenan los datos con setters.
     */
    public Usuario() {
    }

    // ══════════════════════════════════════════════════
    // CONSTRUCTOR COMPLETO
    // ══════════════════════════════════════════════════
    
    /**
     * Constructor con parámetros.
     * Se utiliza para crear un usuario con todos sus datos
     * al momento de insertarlo en la base de datos.
     * 
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param email Correo electrónico
     * @param usuario Nombre de usuario
     * @param contrasena Contraseña
     * @param foto Imagen del usuario en bytes
     */
    public Usuario(String nombre, String apellido, String email,
                   String usuario, String contrasena, byte[] foto) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.foto = foto;
    }

    // ══════════════════════════════════════════════════
    // GETTERS Y SETTERS
    // ══════════════════════════════════════════════════
    
    /**
     * Obtiene el ID del usuario.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna el ID del usuario.
     * @param id identificador único
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre.
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido.
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Asigna el apellido.
     * @param apellido apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna el correo electrónico.
     * @param email correo del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Asigna el nombre de usuario.
     * @param usuario nombre para login
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña.
     * @return contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Asigna la contraseña.
     * @param contrasena contraseña de acceso
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la foto del usuario.
     * @return arreglo de bytes con la imagen
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * Asigna la foto del usuario.
     * @param foto imagen convertida a bytes
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    // ══════════════════════════════════════════════════
    // MÉTODO toString()
    // ══════════════════════════════════════════════════
    
    /**
     * Método sobrescrito para mostrar el usuario
     * en formato legible cuando se imprime el objeto.
     * 
     * @return Cadena con nombre completo y usuario
     */
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + usuario + ")";
    }
}