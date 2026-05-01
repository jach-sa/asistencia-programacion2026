namespace apli.Modelo
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nombre { get; set; } = "";
        public string Apellido { get; set; } = "";
        public string Email { get; set; } = "";
        public string NombreUsuario { get; set; } = "";
        public string Contrasena { get; set; } = "";
        public byte[]? Foto { get; set; }
        public int NivelSeguridad { get; set; }
        public bool Bloqueado { get; set; }
        public int Intentos { get; set; }
        public DateTime? UltimoAcceso { get; set; }
        public bool Activo { get; set; } = true;

        public string NombreCompleto => $"{Nombre} {Apellido}";
    }
}