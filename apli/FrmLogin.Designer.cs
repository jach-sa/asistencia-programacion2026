using System;
using System.Drawing;
using System.Windows.Forms;

namespace apli
{
    partial class FrmLogin
    {
        private System.ComponentModel.IContainer components = null;

        private TextBox txtUsuario;
        private TextBox txtContrasena;
        private Button btnLogin;
        private Label lblEstado;
        private Label lblTitulo;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
                components.Dispose();
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            txtUsuario = new TextBox();
            txtContrasena = new TextBox();
            btnLogin = new Button();
            lblEstado = new Label();
            lblTitulo = new Label();
            SuspendLayout();

            // txtUsuario
            txtUsuario.Location = new Point(60, 70);
            txtUsuario.Size = new Size(200, 27);
            txtUsuario.PlaceholderText = "Usuario";

            // txtContrasena
            txtContrasena.Location = new Point(60, 110);
            txtContrasena.Size = new Size(200, 27);
            txtContrasena.PasswordChar = '●';
            txtContrasena.PlaceholderText = "Contraseña";

            // btnLogin
            btnLogin.Location = new Point(90, 150);
            btnLogin.Size = new Size(120, 30);
            btnLogin.Text = "Ingresar";
            btnLogin.Click += btnLogin_Click;

            // lblEstado
            lblEstado.Location = new Point(60, 220);
            lblEstado.Size = new Size(200, 20);
            lblEstado.ForeColor = Color.Red;
            lblEstado.TextAlign = ContentAlignment.MiddleCenter;

            // lblTitulo
            lblTitulo.Location = new Point(60, 20);
            lblTitulo.Size = new Size(200, 30);
            lblTitulo.Text = "Iniciar Sesión";
            lblTitulo.TextAlign = ContentAlignment.MiddleCenter;
            lblTitulo.Font = new Font("Segoe UI", 14, FontStyle.Bold);

            // FrmLogin
            ClientSize = new Size(320, 260);
            Controls.Add(txtUsuario);
            Controls.Add(txtContrasena);
            Controls.Add(btnLogin);
            Controls.Add(lblEstado);
            Controls.Add(lblTitulo);
            Text = "Login";
            Load += FrmLogin_Load;

            ResumeLayout(false);
            PerformLayout();
        }
    }
}