import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("ejemplo@test.com", null);
        });
    }

    // Test adicional para cubrir un caso de dirección válida, pero mensaje nulo
    @Test
    public void testNotificarConDireccionValidaYMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("ejemplo@test.com", null);
        });
    }
}