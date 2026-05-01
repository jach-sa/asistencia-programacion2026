using apli.Modelo;

namespace apli
{
    public partial class FrmBienvenida : Form
    {
        public FrmBienvenida(Usuario u)
        {
            InitializeComponent();
            lblTexto.Text = $"Bienvenido {u.NombreCompleto}";
        }

        private void lblTexto_Click(object sender, EventArgs e)
        {

        }
    }
}