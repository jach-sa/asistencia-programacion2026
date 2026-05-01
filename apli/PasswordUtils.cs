using System.Text.RegularExpressions;

namespace apli.Modelo
{
    public static class PasswordUtils
    {
        public static int CalcularFortaleza(string pass)
        {
            if (string.IsNullOrEmpty(pass)) return 0;

            int score = 0;
            if (pass.Length >= 8) score++;
            if (Regex.IsMatch(pass, "[A-Z]")) score++;
            if (Regex.IsMatch(pass, "[a-z]")) score++;
            if (Regex.IsMatch(pass, "[0-9]")) score++;
            if (Regex.IsMatch(pass, "[!@#$%^&*]")) score++;

            return Math.Min(4, score);
        }

        public static bool EsValida(string pass)
        {
            return pass.Length >= 8 &&
                   Regex.IsMatch(pass, "[A-Z]") &&
                   Regex.IsMatch(pass, "[a-z]") &&
                   Regex.IsMatch(pass, "[0-9]") &&
                   Regex.IsMatch(pass, "[!@#$%^&*]");
        }
    }
}