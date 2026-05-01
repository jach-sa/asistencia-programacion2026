using MySql.Data.MySqlClient;
using System.Data;

namespace apli.Modelo
{
    public class ConexionDB
    {
        private const string Cadena =
            "Server=127.0.0.1;Port=3306;Database=app_login_csharp;Uid=adsa;Pwd=Olmequitas6857;";

        private static ConexionDB? _instancia;
        private MySqlConnection? _conn;

        public static ConexionDB Instancia
        {
            get
            {
                if (_instancia == null)
                    _instancia = new ConexionDB();
                return _instancia;
            }
        }

        public MySqlConnection GetConexion()
        {
            if (_conn == null)
                _conn = new MySqlConnection(Cadena);

            if (_conn.State != ConnectionState.Open)
                _conn.Open();

            return _conn;
        }

        public static bool ProbarConexion()
        {
            try
            {
                using (var c = new MySqlConnection(Cadena))
                {
                    c.Open();
                    return true;
                }
            }
            catch
            {
                return false;
            }
        }
    }
}