using apli.Controlador;

namespace apli
{
    public partial class FrmRegistro : Form
    {
        public FrmRegistro()
        {
            InitializeComponent();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            new RegistroController().Registrar(
                txtNombre.Text,
                txtApellido.Text,
                "",
                txtUsuario.Text,
                txtContrasena.Text
            );
        }
    }
}