public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        if (direccion == null || direccion.isEmpty()) {
            // No se envía el correo si la dirección está vacía o es nula
            return;
        }

        if (mensaje == null) {
            // Manejar adecuadamente un mensaje nulo (puede variar según la implementación deseada)
            // Por ejemplo, podríamos registrar un error o lanzar una excepción
            throw new IllegalArgumentException("El mensaje no puede ser nulo");
        }

        // Lógica para enviar una notificación por correo
        emailCliente.enviarCorreo(direccion, mensaje);
    }
}