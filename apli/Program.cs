using apli.Modelo;

namespace apli
{
    internal static class Program
    {
        [STAThread]
        static void Main()
        {
            ApplicationConfiguration.Initialize();

            if (!ConexionDB.ProbarConexion())
            {
                MessageBox.Show("Error MySQL");
                return;
            }

            Application.Run(new FrmLogin());
        }
    }
}