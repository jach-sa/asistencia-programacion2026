using System;
using System.Drawing;
using System.Windows.Forms;
using apli.Controlador;

namespace apli
{
    public partial class FrmLogin : Form
    {
        private Button btnRegistro;

        public FrmLogin()
        {
            InitializeComponent();

            // 🔹 Botón Registrarse (bien posicionado)
            btnRegistro = new Button();
            btnRegistro.Text = "Registrarse";
            btnRegistro.Size = new Size(120, 30);

            // 👇 POSICIÓN SEGURA (debajo del botón login)
            btnRegistro.Location = new Point(90, 185);

            // 👇 Para que se vea claramente
            btnRegistro.BackColor = Color.Gray;
            btnRegistro.ForeColor = Color.White;
            btnRegistro.FlatStyle = FlatStyle.Flat;

            btnRegistro.Click += btnRegistro_Click;

            this.Controls.Add(btnRegistro);
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            new LoginController().Login(
                txtUsuario.Text,
                txtContrasena.Text,
                this
            );
        }

        private void btnRegistro_Click(object sender, EventArgs e)
        {
            FrmRegistro registro = new FrmRegistro();
            registro.ShowDialog();
        }

        public void SetEstado(string msg)
        {
            lblEstado.Text = msg;
        }

        private void FrmLogin_Load(object sender, EventArgs e)
        {

        }
    }
}