using apli.Modelo;

namespace apli.Controlador
{
    public class LoginController
    {
        UsuarioDAO dao = new();

        public void Login(string u, string p, FrmLogin f)
        {
            var user = dao.Login(u, p);

            if (user != null)
            {
                new FrmBienvenida(user).Show();
                f.Hide();
            }
            else
            {
                f.SetEstado("Datos incorrectos");
            }
        }
    }
}