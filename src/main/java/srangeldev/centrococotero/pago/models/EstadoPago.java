package srangeldev.centrococotero.pago.models;

/**
 * Enum para el estado del pago
 */
public enum EstadoPago {
    PENDIENTE,
    PROCESANDO,
    COMPLETADO,
    FALLIDO,
    REEMBOLSADO,
    CANCELADO;
}
