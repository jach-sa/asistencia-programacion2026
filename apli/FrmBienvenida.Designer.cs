namespace apli
{
    partial class FrmBienvenida
    {
        private System.ComponentModel.IContainer components = null;
        private Label lblTexto;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
                components.Dispose();
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            lblTexto = new Label();
            SuspendLayout();
            // 
            // lblTexto
            // 
            lblTexto.Dock = DockStyle.Fill;
            lblTexto.Font = new Font("Segoe UI", 14F, FontStyle.Bold);
            lblTexto.Location = new Point(0, 0);
            lblTexto.Name = "lblTexto";
            lblTexto.Size = new Size(400, 200);
            lblTexto.TabIndex = 0;
            lblTexto.TextAlign = ContentAlignment.MiddleCenter;
            lblTexto.Click += lblTexto_Click;
            // 
            // FrmBienvenida
            // 
            ClientSize = new Size(400, 200);
            Controls.Add(lblTexto);
            Name = "FrmBienvenida";
            Text = "Bienvenida";
            ResumeLayout(false);
        }
    }
}