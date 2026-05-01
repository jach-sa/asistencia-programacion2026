namespace apli
{
    partial class FrmRegistro
    {
        private System.ComponentModel.IContainer components = null;

        private TextBox txtNombre;
        private TextBox txtApellido;
        private TextBox txtUsuario;
        private TextBox txtContrasena;
        private Button btnGuardar;
        private Label lblTitulo;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
                components.Dispose();
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            txtNombre = new TextBox();
            txtApellido = new TextBox();
            txtUsuario = new TextBox();
            txtContrasena = new TextBox();
            btnGuardar = new Button();
            lblTitulo = new Label();

            SuspendLayout();

            // Título
            lblTitulo.Text = "Registro";
            lblTitulo.Font = new Font("Segoe UI", 16, FontStyle.Bold);
            lblTitulo.Location = new Point(80, 20);
            lblTitulo.Size = new Size(150, 30);

            // Campos
            txtNombre.PlaceholderText = "Nombre";
            txtApellido.PlaceholderText = "Apellido";
            txtUsuario.PlaceholderText = "Usuario";
            txtContrasena.PlaceholderText = "Contraseña";
            txtContrasena.PasswordChar = '●';

            txtNombre.Location = new Point(60, 70);
            txtApellido.Location = new Point(60, 110);
            txtUsuario.Location = new Point(60, 150);
            txtContrasena.Location = new Point(60, 190);

            txtNombre.Size = txtApellido.Size =
            txtUsuario.Size = txtContrasena.Size = new Size(200, 23);

            // Botón
            btnGuardar.Text = "Guardar";
            btnGuardar.Location = new Point(100, 230);
            btnGuardar.Size = new Size(120, 30);
            btnGuardar.BackColor = Color.FromArgb(30, 86, 49);
            btnGuardar.ForeColor = Color.White;
            btnGuardar.FlatStyle = FlatStyle.Flat;
            btnGuardar.Click += btnGuardar_Click;

            // Form
            ClientSize = new Size(320, 300);
            Controls.Add(lblTitulo);
            Controls.Add(txtNombre);
            Controls.Add(txtApellido);
            Controls.Add(txtUsuario);
            Controls.Add(txtContrasena);
            Controls.Add(btnGuardar);

            Text = "Registro";

            ResumeLayout(false);
            PerformLayout();
        }
    }
}