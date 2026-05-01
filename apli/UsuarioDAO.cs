using MySql.Data.MySqlClient;

namespace apli.Modelo
{
    public class UsuarioDAO
    {
        private MySqlConnection Conn => ConexionDB.Instancia.GetConexion();

        public bool Insertar(Usuario u)
        {
            string sql = @"INSERT INTO usuarios
            (nombre, apellido, email, usuario, contrasena)
            VALUES (@n,@a,@e,@u,@c)";

            using var cmd = new MySqlCommand(sql, Conn);
            cmd.Parameters.AddWithValue("@n", u.Nombre);
            cmd.Parameters.AddWithValue("@a", u.Apellido);
            cmd.Parameters.AddWithValue("@e", u.Email);
            cmd.Parameters.AddWithValue("@u", u.NombreUsuario);
            cmd.Parameters.AddWithValue("@c", u.Contrasena);

            return cmd.ExecuteNonQuery() > 0;
        }

        public Usuario? Login(string usuario, string pass)
        {
            string sql = "SELECT * FROM usuarios WHERE usuario=@u AND contrasena=@p";

            using var cmd = new MySqlCommand(sql, Conn);
            cmd.Parameters.AddWithValue("@u", usuario);
            cmd.Parameters.AddWithValue("@p", pass);

            using var r = cmd.ExecuteReader();
            if (r.Read())
            {
                return new Usuario
                {
                    Nombre = r.GetString("nombre"),
                    Apellido = r.GetString("apellido"),
                    NombreUsuario = r.GetString("usuario")
                };
            }
            return null;
        }

        public bool UsuarioExiste(string user)
        {
            using var cmd = new MySqlCommand(
                "SELECT COUNT(*) FROM usuarios WHERE usuario=@u", Conn);
            cmd.Parameters.AddWithValue("@u", user);
            return Convert.ToInt32(cmd.ExecuteScalar()) > 0;
        }
    }
}