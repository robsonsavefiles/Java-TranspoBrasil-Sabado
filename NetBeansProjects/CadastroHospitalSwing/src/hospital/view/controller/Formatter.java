package hospital.view.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 78522
 */
public class Formatter {

    public static String formatDate(LocalDate data) {
        return data == null ? "" : data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String formatDateTime(LocalDateTime data) {
        return data == null ? "" : data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
