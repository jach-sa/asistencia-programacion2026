using apli.Modelo;

namespace apli.Controlador
{
    public class RegistroController
    {
        UsuarioDAO dao = new();

        public void Registrar(string n, string a, string e, string u, string p)
        {
            if (!PasswordUtils.EsValida(p))
            {
                MessageBox.Show("Contraseña débil");
                return;
            }

            dao.Insertar(new Usuario
            {
                Nombre = n,
                Apellido = a,
                Email = e,
                NombreUsuario = u,
                Contrasena = p
            });

            MessageBox.Show("Registrado");
        }
    }
}